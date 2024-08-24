package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.common.BusinessCommon;
import com.vn.fpt.g1.shop.dao.AdminDao;
import com.vn.fpt.g1.shop.dao.UserDao;
import com.vn.fpt.g1.shop.entity.Role;
import com.vn.fpt.g1.shop.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Properties;

@WebServlet(name = "AddEmployeeServlet", value = "/addemployee")
public class AddEmployeeServlet extends HttpServlet {

    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "@$!%*?&";
    private static final String ALL_CHARACTERS = LOWERCASE + UPPERCASE + DIGITS + SPECIAL_CHARACTERS;

    private static final int PASSWORD_LENGTH = 8;
    private static final SecureRandom random = new SecureRandom();

    private void sendEmail(String recipient, String password) {
        // Sender's email credentials
        final String username = "vinhvu272@gmail.com";
        final String passwordEmail = "asnnjectgqqgqorz";

        // Setup mail server
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Get the Session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, passwordEmail);
                    }
                });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);
            // Set From: header field
            message.setFrom(new InternetAddress(username));
            // Set To: header field
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            // Set Subject: header field
            message.setSubject("Your New Account Password");
            // Now set the actual message
            message.setText("Dear Staff,\n\nYour account has been created. Your password is: " + password + "\nYou can use your email you provide and this password to login to system");
            // Send message
            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

//    private String generateRandomPassword(int length) {
//        String chars = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
//        SecureRandom random = new SecureRandom();
//        StringBuilder password = new StringBuilder(length);
//
//        for (int i = 0; i < length; i++) {
//            password.append(chars.charAt(random.nextInt(chars.length())));
//        }
//        return password.toString();
//    }

    public static String generatePassword() {
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        // Ensure at least one character from each category is included
        password.append(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        password.append(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        password.append(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        // Fill the remaining spots with random characters from all categories
        for (int i = 4; i < PASSWORD_LENGTH; i++) {
            password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
        }

        // Shuffle the characters to ensure randomness
        return shuffleString(password.toString());
    }

    private static String shuffleString(String input) {
        char[] a = input.toCharArray();

        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            // Swap characters at positions i and j
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        return new String(a);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get data from dao
        AdminDao dao = new AdminDao();
        List<Role> listRole = dao.getEmployeeRole();

        //set data to jsp
        request.setAttribute("listRole", listRole);
        request.getRequestDispatcher("add_employee.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String role = request.getParameter("role");

        //get data from dao
        AdminDao dao1 = new AdminDao();
        List<Role> listRole = dao1.getEmployeeRole();

        //set data to jsp
        request.setAttribute("listRole", listRole);

        if (!BusinessCommon.isValidName(firstname) || BusinessCommon.isNullOrEmpty(firstname)) {


            request.setAttribute("error", "Wrong name. Name must start with an uppercase letter, contain lowercase letter and does not have more than 29 letter");
            request.getRequestDispatcher("/add_employee.jsp").forward(request, response);



        }
        if (!BusinessCommon.isValidName(lastname) || BusinessCommon.isNullOrEmpty(lastname)) {
            request.setAttribute("error", "Wrong name. Name must start with an uppercase letter, contain lowercase letter and does not have more than 29 letter");
            request.getRequestDispatcher("/add_employee.jsp").forward(request, response);
            //


        }
        if (!BusinessCommon.isValidEmail(email) || BusinessCommon.isNullOrEmpty(email)) {
            request.setAttribute("error", "Invalid email. Email must has format :example@example.example");
            request.getRequestDispatcher("/add_employee.jsp").forward(request, response);


        }
        if (!BusinessCommon.isValidPhoneNumber(phone) || BusinessCommon.isNullOrEmpty(phone)) {
            request.setAttribute("error", "Phone is required. Phone number has to follow formart: 123-456-7890 or 1234567890");
            request.getRequestDispatcher("add_employee.jsp").forward(request, response);


        }

        UserDao userDao = new UserDao();
        User user = userDao.checkAccountExist(email);
        if (user == null) { // there is no user with same email in db

            try {
                //Genarate password
                String password = generatePassword();
                // Encryption the password
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                LocalDateTime now = LocalDateTime.now();
                Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
                // Convert Instant to Timestamp
                Timestamp timestamp = Timestamp.from(instant);
                AdminDao dao = new AdminDao();

                dao.addEmployee(firstname,lastname,email,phone,hashedPassword,role,timestamp);
                //send Email
                sendEmail(email, password);

                response.sendRedirect("EmployeeManagement");


            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        } else {
            //message
            request.setAttribute("error", "Add false. Account has already existed");
            request.getRequestDispatcher("add_employee.jsp").forward(request, response);


        }






    }
}