package com.vn.fpt.g1.shop.servlet.myorder;

import com.vn.fpt.g1.shop.common.BusinessCommon;
import com.vn.fpt.g1.shop.common.Pagination;
import com.vn.fpt.g1.shop.config.Constant;
import com.vn.fpt.g1.shop.dao.OrderDao;
import com.vn.fpt.g1.shop.dao.TrackingDao;
import com.vn.fpt.g1.shop.entity.Order;
import com.vn.fpt.g1.shop.entity.Users;
import com.vn.fpt.g1.shop.exception.RestExceptionHandler;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/my-order")
public class MyOrderServlet extends HttpServlet {
    private final OrderDao orderDao = new OrderDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession(false);
//        Users user = new Users();
//        if(session != null){
//            user = (Users) session.getAttribute("user");
//        }
//        if(user == null){
//            throw new RestExceptionHandler(Constant.INVALID_USER);
//        }
        int page = 1;
        int size = 10;
        String status = null;
        Date fromDate = null;
        Date endDate = null;

        String pageParam = req.getParameter("page");
        String sizeParam = req.getParameter("size");
        String statusRaw = req.getParameter("status");
        String fromDateRaw = req.getParameter("fromDate");
        String endDateRaw = req.getParameter("endDate");

        if (pageParam != null && !pageParam.isEmpty()) {
            page = BusinessCommon.validatePage(pageParam, page, 1);
        }
        if (sizeParam != null && !sizeParam.isEmpty()) {
            size = BusinessCommon.validatePage(sizeParam, size, 10);
        }
        Pagination pagination = new Pagination(page, size);

        if(!BusinessCommon.isNullOrEmpty(statusRaw)){
            status = statusRaw;
        }

        if(!BusinessCommon.isNullOrEmpty(fromDateRaw) && BusinessCommon.isValidDate(fromDateRaw)){
            fromDate = (Date) BusinessCommon.convertStringToDate(fromDateRaw, "yyyy-MM-dd");
        }

        if(!BusinessCommon.isNullOrEmpty(endDateRaw) && BusinessCommon.isValidDate(endDateRaw)){
            endDate = (Date) BusinessCommon.convertStringToDate(endDateRaw, "yyyy-MM-dd");
        }

//        List<Order> orderList = orderDao.getAllOrderByUserId(user.getUser_id(), pagination, status, fromDate, endDate);
        List<Order> orderList = orderDao.getAllOrderByUserId(2, pagination, status, fromDate, endDate);
        req.setAttribute("order", orderList);
        req.setAttribute("pagination", pagination);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/my-order/my-order.jsp");
        if (dispatcher == null) {
            throw new ServletException("Dispatcher not found for path: " + "/my-order/my-order.jsp");
        }

        dispatcher.forward(req, resp);
    }
}
