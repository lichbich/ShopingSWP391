package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/changePassword")
public class ChangePasswordServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() {
        userDao = new UserDao(); // Khởi tạo UserDao không cần truyền Connection
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/changePassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String currentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");
        String email = (String) request.getSession().getAttribute("userEmail");

        if (email == null) {
            request.setAttribute("message", "User is not logged in.");
            request.getRequestDispatcher("/WEB-INF/changePassword.jsp").forward(request, response);
            return;
        }

        if (!newPassword.equals(confirmPassword)) {
            request.setAttribute("message", "New password and confirm password do not match.");
            request.getRequestDispatcher("/WEB-INF/changePassword.jsp").forward(request, response);
            return;
        }

        // Xác thực mật khẩu hiện tại
        boolean isAuthenticated = userDao.authenticate(email, currentPassword);
        if (!isAuthenticated) {
            request.setAttribute("message", "Current password is incorrect.");
            request.getRequestDispatcher("/WEB-INF/changePassword.jsp").forward(request, response);
            return;
        }

        // Thay đổi mật khẩu
        userDao.changePassword(email, newPassword);
        request.setAttribute("message", "Password changed successfully.");

        request.getRequestDispatcher("/WEB-INF/changePassword.jsp").forward(request, response);
    }
}
