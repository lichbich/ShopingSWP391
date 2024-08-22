package com.vn.fpt.g1.shop.controller;

import com.vn.fpt.g1.shop.dao.ProductDAO;
import com.vn.fpt.g1.shop.dao.ProductDetailDAO;
import com.vn.fpt.g1.shop.entity.ProductDetail;
import com.vn.fpt.g1.shop.entity.Color;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/productDetail")
public class ProductDetailController extends HttpServlet {
    private ProductDetailDAO productDetailDAO;

    @Override
    public void init() throws ServletException {
        productDetailDAO = new ProductDetailDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String product_id = request.getParameter("productId");
        String color_code = request.getParameter("colorCode");
        ProductDetail productDetail = productDetailDAO.getProductDetailByIdAndColorCode(Integer.parseInt(product_id), Integer.parseInt(color_code));
        List<Color> colors = productDetailDAO.getColorsByProductId(Integer.parseInt(product_id));
        request.setAttribute("productDetail", productDetail);
        request.setAttribute("colors", colors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productDetail.jsp");
        dispatcher.forward(request, response);
    }
}