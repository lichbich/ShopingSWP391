package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.CategoryDAO;
import com.vn.fpt.g1.shop.dto.CategoryDto;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "AddCategoryServlet", value = "/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet {
    private final CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form parameters
        String description = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));

        // Create CategoryDto object
        CategoryDto categoryDto = new CategoryDto(description, status);

        // Add category using CategoryDAO
        categoryDAO.addCategory(categoryDto);

        // Redirect to the category list page
        response.sendRedirect("listCategory.jsp");
    }
}
