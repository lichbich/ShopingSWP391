package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.ProductDAO;
import com.vn.fpt.g1.shop.entity.Category;
import com.vn.fpt.g1.shop.entity.Product;
import com.vn.fpt.g1.shop.entity.ProductDetail;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductManagementServlet", value = "/productManagement")
public class ProductManagementServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try {
            // Get all products
            ProductDAO productDAO = new ProductDAO();
            List<Product> products = productDAO.getAllProducts();
            List<Category> categories = ProductDAO.getAllCategories();
            req.setAttribute("products", products);
            req.setAttribute("categories", categories);

            req.getRequestDispatcher("product_management.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "An error occurred during login. Please try again.");
            req.getRequestDispatcher("product_management.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}