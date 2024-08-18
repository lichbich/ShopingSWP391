package com.vn.fpt.g1.shop.controller;

import com.vn.fpt.g1.shop.dao.CustomerDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "updateCustomerStatusServlet", value = "/updateCustomerStatusServlet")
public class updateCustomerStatusServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String customerId = req.getParameter("customerId");
        String status = req.getParameter("status");

        int newStatus = Integer.parseInt(status);

        CustomerDAO cdao = new CustomerDAO();
        cdao.updateCustomerStatus(customerId, newStatus);
        
        resp.sendRedirect("listCustomerServlet");
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