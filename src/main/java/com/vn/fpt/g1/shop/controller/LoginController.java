package com.vn.fpt.g1.shop.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginControl", value = "/LoginControl")
public class LoginController extends HttpServlet {
    @Override
    protected void processResquest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try {
            String user = req.getParameter("username");
            String pass = req.getParameter("password");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}