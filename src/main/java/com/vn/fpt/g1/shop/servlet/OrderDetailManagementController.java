package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.UserDao;
import com.vn.fpt.g1.shop.entity.Order;
import com.vn.fpt.g1.shop.entity.OrderDetail;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderDetailManagementController", value = "/orderDetailManagement")
public class OrderDetailManagementController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("order_id");
        int order_id = Integer.parseInt(id);
        UserDao dao = new UserDao();
        Order order = dao.getOrderById(order_id);
        List<OrderDetail> orderDetails = dao.getOrderDetailById(order_id);

        request.setAttribute("detail", order);
        request.setAttribute("orderDetails", orderDetails);
        request.getRequestDispatcher("orderDetailManagement.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}