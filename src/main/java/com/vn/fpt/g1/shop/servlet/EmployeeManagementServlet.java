package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.AdminDao;
import com.vn.fpt.g1.shop.entity.Role;
import com.vn.fpt.g1.shop.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeManagementServlet", value = "/EmployeeManagement")
public class EmployeeManagementServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //get data from dao
        AdminDao dao = new AdminDao();
        List<User> list = dao.getAllEmployee();
        List<Role> listRole = dao.getEmployeeRole();

        //set data to jsp
        request.setAttribute("listE", list);
        request.setAttribute("listRole", listRole);
        request.getRequestDispatcher("employee_management.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}