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

@WebServlet("/addCategory")
public class AddCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/saleManagerment/addCategory.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        String statusStr = request.getParameter("status");

        if (description == null || description.isEmpty() || statusStr == null || statusStr.isEmpty()) {
            response.sendRedirect("addCategory.jsp"); // Redirect back to add page with an error
            return;
        }

        try {
            int status = Integer.parseInt(statusStr);
            Timestamp currentTimestamp = new Timestamp(new Date().getTime());

            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setDescription(description);
            categoryDto.setStatus(status);
            categoryDto.setCreateDate(currentTimestamp);
            categoryDto.setUpdateDate(currentTimestamp); // Assuming update date is the same as create date initially

            CategoryDAO categoryDAO = new CategoryDAO();
            categoryDAO.addCategory(categoryDto);

            response.sendRedirect("listCategory"); // Redirect to the list page after adding
        } catch (NumberFormatException e) {
            response.sendRedirect("addCategory"); // Redirect back to add page with an error
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("addCategory"); // Redirect back to add page with an error
        }
    }
}
