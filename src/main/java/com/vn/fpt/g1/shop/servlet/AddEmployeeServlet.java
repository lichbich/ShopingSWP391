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

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@WebServlet(name = "AddEmployeeServlet", value = "/addemployee")
public class AddEmployeeServlet extends HttpServlet {
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
        String password = request.getParameter("password");
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

        if (!BusinessCommon.isValidPassword(password)|| BusinessCommon.isNullOrEmpty(password)) {
            request.setAttribute("error", "Password is required. Password must has more than 8 letter and contain upper and lowercase letter, number and special symple[@$!%*?&]");
            request.getRequestDispatcher("add_employee.jsp").forward(request, response);

        }
        if (!BusinessCommon.isValidPhoneNumber(phone) || BusinessCommon.isNullOrEmpty(phone)) {
            request.setAttribute("error", "Phone is required. Phone number has to follow formart: 123-456-7890 or 1234567890");
            request.getRequestDispatcher("add_employee.jsp").forward(request, response);


        }

        UserDao userDao = new UserDao();
        User user = userDao.checkAccountExist(email);
        if (user == null) { // // there is no user with same email in db

            try {
                // Encryption the password
                String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                LocalDateTime now = LocalDateTime.now();
                Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
                // Convert Instant to Timestamp
                Timestamp timestamp = Timestamp.from(instant);
                AdminDao dao = new AdminDao();

                dao.addEmployee(firstname,lastname,email,phone,hashedPassword,role,timestamp);
                response.sendRedirect("employeeManagement");


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