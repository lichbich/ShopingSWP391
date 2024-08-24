package com.vn.fpt.g1.shop.servlet;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import com.vn.fpt.g1.shop.dao.UserDao;
import com.vn.fpt.g1.shop.entity.Order;
import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerListOrderServlet", value = "/customerListOrder")
public class CustomerListOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        HttpSession session = request.getSession(false);
        if(session != null){
            Users user = (Users)session.getAttribute("user");
            UserDao dao = new UserDao();
            List<Order> orders = dao.customerListOrder(user.getEmail(), status);

            request.setAttribute("orders", orders);
            request.setAttribute("selectedStatus", status);

            request.getRequestDispatcher("orderList.jsp").forward(request, response);

        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}