package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteProductServlet", value = "/deleteProduct")
public class DeteleProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productDetailId = Integer.parseInt(request.getParameter("productDetailId"));
        ProductDAO productDAO = new ProductDAO();
        productDAO.deleteProductById(productDetailId);
        request.getRequestDispatcher("productManagement").forward(request, response);
    }


}