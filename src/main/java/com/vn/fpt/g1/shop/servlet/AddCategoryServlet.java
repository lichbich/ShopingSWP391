package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.CategoryDAO;
import com.vn.fpt.g1.shop.dto.CategoryDto;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
    private CategoryDAO categoryDAO;

    @Override
    public void init() throws ServletException {
        categoryDAO = new CategoryDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String description = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));

        CategoryDto category = new CategoryDto(0, description, status);

        try {
            categoryDAO.addCategory(category);
            response.sendRedirect("listCategory.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
