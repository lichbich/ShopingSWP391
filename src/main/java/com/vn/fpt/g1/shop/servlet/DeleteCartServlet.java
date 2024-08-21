package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "DeleteCartServlet", value = "/delete")
public class DeleteCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid = request.getParameter("cid");
        int id = Integer.parseInt(cid);
        UserDao dao = new UserDao();
        dao.deleteCart(id);
        response.sendRedirect("cart");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}