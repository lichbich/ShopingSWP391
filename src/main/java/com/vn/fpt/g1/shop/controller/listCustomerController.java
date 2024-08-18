package com.vn.fpt.g1.shop.controller;
import com.vn.fpt.g1.shop.dao.CustomerDAO;
import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "listCustomerController", value = "/listCustomerController")
public class listCustomerController extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        CustomerDAO cdao = new CustomerDAO();
        List<Users> usersList = cdao.getListCustomer();

        req.setAttribute("usersList", usersList);
        req.getRequestDispatcher("listCustomer.jsp").forward(req, resp);
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