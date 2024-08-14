package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.CustomerDAO;
import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "customerDetail", value = "/customerDetail")
public class customerDetail extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String uid = req.getParameter("cid");
        CustomerDAO cdao = new CustomerDAO();
        List<Users> list = cdao.getListCustomerByID(uid);

        req.setAttribute("list", list);
        req.getRequestDispatcher("customerDetail.jsp").forward(req, resp);
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