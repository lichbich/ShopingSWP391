package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ActionOrderServlet", value = "/actionOrder")
public class ActionOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String orderId = request.getParameter("order_id");
        String receiverName = request.getParameter("receiver_name");
        String shippingAddress = request.getParameter("shipping_address");
        String receiverPhone = request.getParameter("receiver_phone");

        String status = "Canceled";
        Integer order_id = Integer.parseInt(orderId);

        UserDao dao = new UserDao();
        String action = request.getParameter("action");
        if ("update".equals(action)) {
            dao.updateReceiverInfo(order_id, receiverName, shippingAddress, receiverPhone);

        } else if ("cancel".equals(action)) {
            dao.updateStatusOrder(order_id, status);

        }
        String referer = request.getHeader("referer");


        if (referer != null) {
            response.sendRedirect(referer);
        } else {
            response.sendRedirect("products");
        }


    }
}