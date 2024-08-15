package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.CategoryDAO;
import com.vn.fpt.g1.shop.dto.CategoryDto;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet("/editCategory")
public class EditCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryIdStr = request.getParameter("categoryId");
        if (categoryIdStr == null || categoryIdStr.isEmpty()) {
            response.sendRedirect("listCategory"); // Redirect to the list page or show an error message
            return;
        }

        try {
            int categoryId = Integer.parseInt(categoryIdStr);
            CategoryDAO categoryDAO = new CategoryDAO();
            CategoryDto category = categoryDAO.getCategoryById(categoryId);
            request.setAttribute("category", category);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/saleManagerment/editCategory.jsp");
            dispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            response.sendRedirect("listCategory"); // Redirect or show an error page
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("listCategory"); // Redirect or show an error page
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryIdStr = request.getParameter("categoryId");
        String description = request.getParameter("description");
        String statusStr = request.getParameter("status");

        if (categoryIdStr == null || categoryIdStr.isEmpty() || description == null || description.isEmpty() || statusStr == null || statusStr.isEmpty()) {
            response.sendRedirect("editCategory?categoryId=" + categoryIdStr); // Redirect back to edit page with an error
            return;
        }

        try {
            int categoryId = Integer.parseInt(categoryIdStr);
            int status = Integer.parseInt(statusStr);
            Timestamp currentTimestamp = new Timestamp(new Date().getTime());

            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setCategoryId(categoryId);
            categoryDto.setDescription(description);
            categoryDto.setStatus(status);
            categoryDto.setUpdateDate(currentTimestamp); // Update the date field on modification

            CategoryDAO categoryDAO = new CategoryDAO();
            categoryDAO.updateCategory(categoryDto);

            response.sendRedirect("listCategory"); // Redirect to the list page after updating
        } catch (NumberFormatException e) {
            response.sendRedirect("editCategory?categoryId=" + categoryIdStr); // Redirect back to edit page with an error
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("editCategory?categoryId=" + categoryIdStr); // Redirect back to edit page with an error
        }
    }
}
