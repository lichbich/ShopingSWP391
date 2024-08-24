package com.vn.fpt.g1.shop.controller;

import com.vn.fpt.g1.shop.common.BusinessCommon;
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

            // Validate email
            if (email == null || email.isEmpty() || !BusinessCommon.isValidEmail(email)) {
                req.setAttribute("error", "Invalid email.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                return;
            }

            // Validate password
            if (pass == null || pass.isEmpty() || !BusinessCommon.isValidPassword(pass)) {
                req.setAttribute("error", "Invalid password.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
                return;
            }

            LoginDAO loginDAO = new LoginDAO();
            Users user = loginDAO.checkLogin(email, pass);
            if (user == null) {
                req.setAttribute("error", "Invalid email or password.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }else if (!BusinessCommon.checkPassword(pass, user.getPassword())) {
                req.setAttribute("error", "Invalid password.");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                String roleId = user.getRole_id();
                System.out.println("User role_id: " + user.getRole_id());

                // Redirect based on role_id
                switch (roleId) {
                    case "1":
                        resp.sendRedirect("EmployeeManagement");
                        break;
                    case "2":
                        resp.sendRedirect("stock.jsp");
                        break;
                    case "3":
                        resp.sendRedirect("orderManagement");
                        break;
                    case "4":
                        resp.sendRedirect("products");
                        break;
                    default:
                        req.setAttribute("error", "Unauthorized access.");
                        req.getRequestDispatcher("login.jsp").forward(req, resp);
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "An error occurred during login. Please try again.");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
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