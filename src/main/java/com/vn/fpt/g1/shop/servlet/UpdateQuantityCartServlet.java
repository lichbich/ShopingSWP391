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

        try{
            String productName = request.getParameter("cart_product_name");
            String colorName = request.getParameter("cart_color_name");
            String size = request.getParameter("cart_size");
            String cid = request.getParameter("cartId");
            String quantity = request.getParameter("quantity");
            if (cid == null || quantity == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing parameters");
                return;
            }
            int cartId = Integer.parseInt(cid);
            int cartQuantity = Integer.parseInt(quantity);
            UserDao dao = new UserDao();
            int productDetailQuantity = dao.getQuantityOfProductDetail(productName, colorName, size);
            if(cartQuantity > productDetailQuantity){
                request.setAttribute("error", "We don't have enough shoe for your request");
                request.getRequestDispatcher("/cart.jsp").forward(request, response);
                return;
            }

            dao.updateQuantity(cartId, cartQuantity);

            response.sendRedirect("cart");
        }catch (NumberFormatException e) {
            // Xử lý lỗi chuyển đổi kiểu dữ liệu
            e.printStackTrace(); // Ghi log lỗi hoặc thông báo cho người dùng
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input format");



        }catch (Exception e) {
            // Xử lý các lỗi khác
            e.printStackTrace(); // Ghi log lỗi hoặc thông báo cho người dùng
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An error occurred");


        }


    }
}