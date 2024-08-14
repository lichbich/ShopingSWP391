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

@WebServlet("/editCategory")
public class EditCategoryServlet extends HttpServlet {

    private CategoryDAO categoryDAO;

    @Override
    public void init() {
        categoryDAO = new CategoryDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String description = request.getParameter("description");
        int status = Integer.parseInt(request.getParameter("status"));

        CategoryDto category = new CategoryDto();
        category.setId(id);
        category.setDescription(description);
        category.setStatus(status);

//        try {
//            categoryDAO.updateCategory(category);
//            response.sendRedirect("listCategory.jsp");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.sendRedirect("error.jsp");
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

//        try {
//            CategoryDto category = categoryDAO.getCategoryById(id);
//            request.setAttribute("category", category);
//            request.getRequestDispatcher("WEB-INF/saleManagerment/editCategory.jsp").forward(request, response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//            response.sendRedirect("error.jsp");
//        }
    }
}
