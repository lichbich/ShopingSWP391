package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.ProductDAO;
import com.vn.fpt.g1.shop.dto.ProductDto;
import com.vn.fpt.g1.shop.dbcontext.DbContext;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/editProduct")
public class EditProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int status = Integer.parseInt(request.getParameter("status"));

        ProductDto product = new ProductDto(name, description, price, categoryId, status);
        product.setProductId(productId);
        try (Connection connection = DbContext.getConnection()) {
            ProductDAO productDAO = new ProductDAO(connection);
            productDAO.updateProduct(product);
            response.sendRedirect("productManagement/listProduct.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Failed to update product.");
            request.getRequestDispatcher("productManagement/editProduct.jsp").forward(request, response);
        }
    }
}
