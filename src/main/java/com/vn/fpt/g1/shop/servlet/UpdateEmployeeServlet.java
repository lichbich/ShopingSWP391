package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.AdminDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@WebServlet(name = "UpdateEmployeeServlet", value = "/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String role_id = request.getParameter("role");
        String isActive = request.getParameter("isActive");

        int rid = Integer.parseInt(role_id);
        int status = Integer.parseInt(isActive);

        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        // Convert Instant to Timestamp
        Timestamp timestamp = Timestamp.from(instant);

        AdminDao dao = new AdminDao();
        dao.editEmployee(status, rid, email, timestamp);
        response.sendRedirect("EmployeeManagement");

    }
}