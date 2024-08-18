package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.CategoryDAO;
import com.vn.fpt.g1.shop.dto.CategoryDto;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/listCategory")
public class ListCategoryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve filter parameters
        String searchName = request.getParameter("searchName");
        String statusFilter = request.getParameter("statusFilter");

        // Initialize CategoryDAO and fetch filtered categories
        CategoryDAO categoryDAO = new CategoryDAO();
        List<CategoryDto> categoryList = categoryDAO.getFilteredCategories(searchName, statusFilter);

        // Set attributes for JSP
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("searchName", searchName);
        request.setAttribute("statusFilter", statusFilter);

        // Forward to JSP page
        request.getRequestDispatcher("/WEB-INF/saleManagerment/listCategory.jsp").forward(request, response);
    }
}
