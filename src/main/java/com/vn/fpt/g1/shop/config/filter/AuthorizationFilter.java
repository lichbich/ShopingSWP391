// src/main/java/com/vn/fpt/g1/shop/filter/AuthorizationFilter.java
package com.vn.fpt.g1.shop.config.filter;

import com.vn.fpt.g1.shop.entity.Users;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter("/*")
public class AuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        Users user = (session != null) ? (Users) session.getAttribute("user") : null;
        String path = req.getRequestURI().substring(req.getContextPath().length());

        if (user == null) {
            if (path.startsWith("/LoginController") || path.startsWith("/RegisterController") || path.startsWith("/static") || path.equals("/login.jsp") || path.equals("/logout")) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(req.getContextPath() + "/LoginController");
            }
        } else {
            String role = user.getRole_id();
            if ((role.equals("1") && path.startsWith("/listCustomer")) ||
                    (role.equals("2") && path.startsWith("/stock")) ||
                    (role.equals("3") && path.startsWith("/sale")) ||
                    (role.equals("4") && (path.startsWith("/index.jsp") || path.startsWith("/products") || path.startsWith("/cart") || path.startsWith("/order") || path.startsWith("/profile"))) ||
                    path.startsWith("/static") || path.startsWith("/LogoutController")) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(req.getContextPath() + "/unauthorized.jsp");

            }
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}