package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.CategoryDAO;
import com.vn.fpt.g1.shop.entity.Category;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "listCategoriesServlet", value = "/listCategoriesServlet")
public class listCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categoryList = categoryDAO.getAllCategories();
        request.setAttribute("categories", categoryList);
        request.getRequestDispatcher("/WEB-INF/saleManager/listCategories.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
