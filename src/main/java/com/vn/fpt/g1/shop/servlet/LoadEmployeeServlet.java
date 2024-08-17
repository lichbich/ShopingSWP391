package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.AdminDao;
import com.vn.fpt.g1.shop.entity.Role;
import com.vn.fpt.g1.shop.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoadEmployeeServlet", value = "/loadEmployee")
public class LoadEmployeeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("eid");
        int eid = Integer.parseInt(id);
        AdminDao dao = new AdminDao();
        User user = dao.getEmployeeById(eid);
        List<Role> listRole = dao.getEmployeeRole();

        //set data to jsp
        request.setAttribute("listRole", listRole);
        request.setAttribute("detail", user);
        request.getRequestDispatcher("update_employee.jsp").forward(request,response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}