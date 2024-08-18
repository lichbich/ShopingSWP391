package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.common.BusinessCommon;
import com.vn.fpt.g1.shop.dao.UserDao;
import com.vn.fpt.g1.shop.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


@WebServlet(name = "RegisterController", value = "/register")
public class RegisterController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phone = request.getParameter("phonenumber");
        String birthdate = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re-password");
//        String createTime = getCurrentDateTime();
//        String updateTime = getCurrentDateTime();
        if (!BusinessCommon.isValidName(firstname) || BusinessCommon.isNullOrEmpty(firstname)) {
            request.setAttribute("error", "First name is required.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;

        }
        if (!BusinessCommon.isValidName(lastname) || BusinessCommon.isNullOrEmpty(lastname)) {
            request.setAttribute("error", "Last name is required.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;

        }

        if (!BusinessCommon.isValidEmail(email) || BusinessCommon.isNullOrEmpty(email)) {
            request.setAttribute("error", "Email is required.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;

        }

//        if (!BusinessCommon.isValidPhoneNumber(phone) || BusinessCommon.isNullOrEmpty(phone)) {
//            request.setAttribute("error", "Phone is required.");
//            request.getRequestDispatcher("/register.jsp").forward(request, response);
//            return;
//
//        }

        if (BusinessCommon.isNullOrEmpty(email)) {
            request.setAttribute("error", "Address is required.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;

        }

        if (!BusinessCommon.isValidPassword(password)|| BusinessCommon.isNullOrEmpty(password)) {
            request.setAttribute("error", "Password is required.");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
            return;

        }



        if (!password.equals(rePassword)) {
            request.setAttribute("error", "Re-password is not similar to password");
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } else {
            UserDao userDao = new UserDao();
            User user = userDao.checkAccountExist(email);
            if (user == null) { // // there is no user with same email in db
                // register
                try {
                    // Encryption the password
                    String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
                    LocalDateTime now = LocalDateTime.now();
                    Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
                    // Convert Instant to Timestamp
                    Timestamp timestamp = Timestamp.from(instant);
                    Date sqlDate = Date.valueOf(birthdate);
                    userDao.register(firstname, lastname, address, sqlDate, phone, email, hashedPassword, gender, timestamp, timestamp);
                    response.sendRedirect("index.jsp");

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }

            } else {
                //message
                request.setAttribute("error", "Sign up failed, Email address already used!");
                request.getRequestDispatcher("/register.jsp").forward(request, response);


            }
        }


    }
}