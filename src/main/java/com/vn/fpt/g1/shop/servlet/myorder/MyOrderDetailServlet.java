package com.vn.fpt.g1.shop.servlet.myorder;

import com.vn.fpt.g1.shop.dao.OrderDao;
import com.vn.fpt.g1.shop.dao.TrackingDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet("/my-order/detail")
public class MyOrderDetailServlet extends HttpServlet {
    private final OrderDao orderDao = new OrderDao();
    private final TrackingDao trackingDao = new TrackingDao();
}
