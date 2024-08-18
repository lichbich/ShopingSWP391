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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = DbContext.getConnection()) {
            ProductDAO productDAO = new ProductDAO(connection);
            List<ProductDto> productList = productDAO.getAllProducts();
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("listProduct").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Error fetching product list.");
            request.getRequestDispatcher("listProduct").forward(request, response);
        }
    }
}
