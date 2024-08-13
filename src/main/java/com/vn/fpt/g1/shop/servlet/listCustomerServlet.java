package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.CustomerDAO;
import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listCustomerServlet", value = "/listCustomerServlet")
public class listCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CustomerDAO cdao = new CustomerDAO();
        List<Users> usersList = cdao.getListCustomer();

        request.setAttribute("usersList", usersList);
        request.getRequestDispatcher("listCustomer.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}