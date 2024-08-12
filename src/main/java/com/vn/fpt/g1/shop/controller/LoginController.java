package com.vn.fpt.g1.shop.controller;

import com.vn.fpt.g1.shop.dao.LoginDAO;
import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try {
            String email = req.getParameter("email");
            String pass = req.getParameter("password");
            LoginDAO loginDAO = new LoginDAO();
            Users user = loginDAO.checkLogin(email, pass);
            if (user == null) {
                resp.sendRedirect("login.jsp");
                System.out.println("User or password is wrong");
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                resp.sendRedirect("index.jsp");
                System.out.println("Login success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }
}