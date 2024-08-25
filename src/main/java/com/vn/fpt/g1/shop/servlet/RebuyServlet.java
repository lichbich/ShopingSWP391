package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.UserDao;
import com.vn.fpt.g1.shop.entity.Cart;
import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "RebuyServlet", value = "/rebuy")
public class RebuyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pdid = request.getParameter("productDetailId");
        int product_detail_id = Integer.parseInt(pdid);
        HttpSession session = request.getSession(false);

        if(session != null){
            Users user = (Users)session.getAttribute("user");
            UserDao dao = new UserDao();
            dao.rebuyProduct(user.getEmail(), product_detail_id);
            String referer = request.getHeader("referer");


            if (referer != null) {
                response.sendRedirect(referer);
            } else {
                response.sendRedirect("products");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}