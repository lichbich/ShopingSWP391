package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "AddProductServlet", value = "/update-product")
public class UpdateProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        int CategoryID = Integer.parseInt(request.getParameter("CategoryID"));

            try {
                ProductDAO productDAO = new ProductDAO();
                productDAO.addProduct(productName, description, CategoryID);

                response.sendRedirect("productManagement");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

    }
}