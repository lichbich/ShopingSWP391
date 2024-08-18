package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.UserDao;
import com.vn.fpt.g1.shop.entity.Cart;
import com.vn.fpt.g1.shop.entity.User;
import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CartContactServlet", value = "/cartContact")
public class CartContactServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session1 = request.getSession(false);
        HttpSession session = request.getSession();
        if(session1 != null){
            Users user = (Users)session.getAttribute("user");
            UserDao dao = new UserDao();
            User user1 = dao.getCustomerByEmail(user.getEmail());

            List<Cart> listCartContact = (List<Cart>) session.getAttribute("listCart");


            request.setAttribute("listCartContact", listCartContact);
            request.setAttribute("detail", user1);
            request.getRequestDispatcher("cartContact.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}