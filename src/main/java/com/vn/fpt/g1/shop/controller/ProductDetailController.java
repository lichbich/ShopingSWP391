package com.vn.fpt.g1.shop.controller;

import com.vn.fpt.g1.shop.dao.ProductDetailDAO;
import com.vn.fpt.g1.shop.entity.ProductDetail;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductDetailController", value = "/productDetail")
public class ProductDetailController extends HttpServlet {
    private ProductDetailDAO productDetailDAO;

    @Override
    public void init() throws ServletException {
        productDetailDAO = new ProductDetailDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");

        if (productId == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing required parameters");
            return;
        }

        List<ProductDetail> productDetails = productDetailDAO.getProductDetailById(Integer.parseInt(productId));

        if (productDetails == null || productDetails.isEmpty()) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Product not found");
            return;
        }

        request.setAttribute("productDetails", productDetails);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
        dispatcher.forward(request, response);
    }
}