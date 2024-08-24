package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.UserDao;
import com.vn.fpt.g1.shop.entity.OrderDetail;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateOrderStatusServlet", value = "/updateOrderStatus")
public class UpdateOrderStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderId = request.getParameter("orderId");
        String currentStatus = request.getParameter("currentStatus");
        String newStatus = request.getParameter("status");


        int order_id = Integer.parseInt(orderId);


        UserDao dao = new UserDao();
        boolean statusUpdate = dao.updateOrderStatus(order_id, newStatus);

        if(statusUpdate && "Shop Processing".equals(currentStatus) && "Shipping".equals(newStatus)){

            List<OrderDetail> orderDetails = dao.getOrderDetailById(order_id);
            for(OrderDetail detail : orderDetails){
                dao.updateStockQuantity(detail.getProduct_detail_id(), detail.getQuantity());
            }
        }

        String referer = request.getHeader("referer");

        if (referer != null) {
            response.sendRedirect(referer);
        } else {
            response.sendRedirect("products");
        }


    }
}