package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.common.BusinessCommon;
import com.vn.fpt.g1.shop.dao.UserDao;
import com.vn.fpt.g1.shop.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


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
        String phone = request.getParameter("phone");
        String birthdate = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String password = request.getParameter("password");
        String rePassword = request.getParameter("re-password");
//        String createTime = getCurrentDateTime();
//        String updateTime = getCurrentDateTime();
//        if (!BusinessCommon.isValidName(firstname) && !BusinessCommon.isValidName(lastname)) {
//            request.setAttribute("errorMessage", "Username or lastname wrong.");
//
//            request.getRequestDispatcher("register.jsp").forward(request, response);
//
//        }
        if (!password.equals(rePassword)) {
            request.setAttribute("mess1", "Name has to follow format!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        } else {
            UserDao userDao = new UserDao();
            User user = userDao.checkAccountExist(email);
            if (user == null) { // // there is no user with same email in db
                // register
                try {
                    // Define the date format
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    // Parse the date string to java.util.Date
                    java.util.Date parsedDate = null;
                    parsedDate = dateFormat.parse(birthdate);
                    // Convert java.util.Date to java.sql.Date
                    Date birth_date = new Date(parsedDate.getTime());
                    userDao.register(firstname, lastname, address, birth_date, phone, email, gender, password);
                    response.sendRedirect("hello-servlet");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            } else {
                // return to register page
                //message
                response.sendRedirect("register.jsp");

            }
        }


    }
}