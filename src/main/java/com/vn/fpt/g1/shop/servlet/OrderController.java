package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@WebServlet(name = "OrderController", value = "/order")
public class OrderController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user_id = request.getParameter("customer_id");
        String totalPrice = request.getParameter("total_price");
        String receiver_name = request.getParameter("name_receiver");
        String receiver_phone = request.getParameter("phone");
        String shippingAddress = request.getParameter("address");

        int id = Integer.parseInt(user_id);
        UserDao dao = new UserDao();
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        // Convert Instant to Timestamp
        Timestamp timestamp = Timestamp.from(instant);

        dao.order(id, timestamp, totalPrice, shippingAddress, receiver_name, receiver_phone);

    }
}