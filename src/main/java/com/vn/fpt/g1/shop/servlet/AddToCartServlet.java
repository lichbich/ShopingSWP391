// Update the `AddToCartServlet` to call the new method in `ProductDetailDAO`.

package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.ProductDetailDAO;
import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "AddToCartServlet", value = "/addToCart")
public class AddToCartServlet extends HttpServlet {
    private ProductDetailDAO productDetailDAO;

    @Override
    public void init() throws ServletException {
        productDetailDAO = new ProductDetailDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<String, Map<Integer, Integer>> cart = (Map<String, Map<Integer, Integer>>) session.getAttribute("cart");

        if (cart == null) {
            cart = new HashMap<>();
        }

        int productDetailId = Integer.parseInt(request.getParameter("productId"));

//        cart.putIfAbsent(userId, new HashMap<>());
//        Map<Integer, Integer> userCart = cart.get(userId);
//        userCart.put(productDetailId, userCart.getOrDefault(productDetailId, 0) + quantity);

//        session.setAttribute("cart", cart);

        Users user = (Users)session.getAttribute("user");

        // Add to cart in the database
        productDetailDAO.addToCart(user.getEmail(), productDetailId);

        response.sendRedirect("products");
    }
}