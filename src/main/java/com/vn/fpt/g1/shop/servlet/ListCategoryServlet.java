package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.CategoryDAO;
import com.vn.fpt.g1.shop.entity.Category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listCategories")
public class ListCategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categoryList = categoryDAO.getAllCategories();
        request.setAttribute("categories", categoryList);
        request.getRequestDispatcher("/WEB-INF/saleManager/listCategories.jsp").forward(request, response);
    }
}
