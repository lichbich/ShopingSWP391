package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.UserDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "UpdateQuantityCartServlet", value = "/updateCart")
public class UpdateQuantityCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cid = request.getParameter("cartId");
        String quantity = request.getParameter("quantity");



        try{
            int cartId = Integer.parseInt(cid);
            int cartQuantity = Integer.parseInt(quantity);
            UserDao dao = new UserDao();
            dao.updateQuantity(cartId, cartQuantity);
        }catch (NumberFormatException e) {
            // Xử lý lỗi chuyển đổi kiểu dữ liệu
            e.printStackTrace(); // Ghi log lỗi hoặc thông báo cho người dùng
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");
            return; // Dừng thực hiện thêm nếu có lỗi

        }catch (Exception e) {
            // Xử lý các lỗi khác
            e.printStackTrace(); // Ghi log lỗi hoặc thông báo cho người dùng
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred");
            return; // Dừng thực hiện thêm nếu có lỗi
        }

        response.sendRedirect("cart");
    }
}