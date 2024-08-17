package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.AdminDao;
import com.vn.fpt.g1.shop.entity.Role;
import com.vn.fpt.g1.shop.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchEmployeeServlet", value = "/search")
public class SearchEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String role = request.getParameter("role");
        String status = request.getParameter("status");
        String txtSearch = request.getParameter("txtSearch");

        AdminDao dao = new AdminDao();
        List<User> list = dao.search(role, status, txtSearch);
        List<Role> listRole = dao.getEmployeeRole();

        //set data to jsp
        request.setAttribute("listRole", listRole);
        request.setAttribute("listE", list);

        request.setAttribute("selectedRole", role);
        request.setAttribute("selectedStatus", status);
        request.setAttribute("searchedName", txtSearch);
        request.getRequestDispatcher("employee_management.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}