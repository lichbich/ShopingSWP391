package com.vn.fpt.g1.shop.controller;

//import com.vn.fpt.g1.shop.dao.CategoryDAO;
import com.vn.fpt.g1.shop.dao.ProductDAO;
import com.vn.fpt.g1.shop.entity.Category;
import com.vn.fpt.g1.shop.entity.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListController", value = "/ProductListController")

public class ProductListController extends HttpServlet {
    protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        try {
            // Get all products
            ProductDAO productDAO = new ProductDAO();
            String searchQuery = req.getParameter("searchQuery");
            String categoryId = req.getParameter("categoryId");
            List<Product> products;
            if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                products = productDAO.searchProducts(searchQuery);
            } else {
                products = productDAO.getAllProducts();
            }
            List<Category> categories = ProductDAO.getAllCategories();
            List<Product> latestProducts = productDAO.getLatestProducts();
            List<Product> filter = productDAO.getProductByCategory(categoryId);
            req.setAttribute("products", filter);
            req.setAttribute("products", products);
            req.setAttribute("latestProducts", latestProducts);
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("index.jsp").forward(req, resp);

        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "An error occurred during login. Please try again.");
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
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