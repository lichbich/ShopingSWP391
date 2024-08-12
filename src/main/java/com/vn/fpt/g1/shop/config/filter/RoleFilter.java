package com.vn.fpt.g1.shop.config.filter;

import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "RoleFilter", urlPatterns = {"/admin/*", "/customer/*"})
public class RoleFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        if (session != null) {
            Users user = (Users) session.getAttribute("user");
            String path = req.getServletPath();

            if (user != null) {
                if (path.startsWith("/admin") && user.hasRole("ADMIN")) {
                    chain.doFilter(request, response);
                } else if (path.startsWith("/stock") && user.hasRole("STOCK_MANAGER")) {
                    chain.doFilter(request, response);
                } else if (path.startsWith("/sale") && user.hasRole("SALE_MANAGER")) {
                    chain.doFilter(request, response);
                } else if (path.startsWith("/customer") && user.hasRole("CUSTOMER")) {
                    chain.doFilter(request, response);
                } else {
                    resp.sendRedirect("accessDenied.jsp");
                }
                return;
            }
        }
        resp.sendRedirect("login.jsp");
    }
}