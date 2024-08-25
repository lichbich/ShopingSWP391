package com.vn.fpt.g1.shop.controller;

import com.vn.fpt.g1.shop.dao.ProductDAO;
import com.vn.fpt.g1.shop.entity.Category;
import com.vn.fpt.g1.shop.entity.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoryController", value = "/category")
public class CategoryController extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String categoryId = req.getParameter("categoryId");

        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.getProductsByCategory(categoryId);
        List<Category> categories = ProductDAO.getAllCategories();
        List<Product> latestProducts = productDAO.getLatestProducts();

        req.setAttribute("products", products);
        req.setAttribute("latestProducts", latestProducts);
        req.setAttribute("categories", categories);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}