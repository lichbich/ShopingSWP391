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
            if (path.startsWith("/LoginController") || path.startsWith("/RegisterController") || path.startsWith("/static") || path.equals("/login.jsp") || path.equals("/register.jsp") || path.equals("/logout") || path.equals("/products") || path.equals("/index.jsp")) {
                chain.doFilter(request, response);
            } else {
                if (session != null) {
                    session.removeAttribute("user");
                }
                resp.sendRedirect(req.getContextPath() + "/LoginController");
            }
        } else {
            String role = user.getRole_id();
            if ((role.equals("1") && (path.startsWith("/EmployeeManagement") || path.startsWith("/admin") || path.startsWith("/search") || path.startsWith("/loadEmployee") || path.startsWith("/updateEmployee") || path.startsWith("/addemployee"))) ||
                    (role.equals("2") && path.startsWith("/stock.jsp")) ||
                    (role.equals("3") && path.startsWith("/sale.jsp")) ||
                    (role.equals("4") && !(path.startsWith("/EmployeeManagement") || path.startsWith("/admin") || path.startsWith("/stock.jsp") || path.startsWith("/sale.jsp"))) ||
                    path.startsWith("/static") || path.startsWith("/LogoutController")) {
                chain.doFilter(request, response);
            } else {
                resp.sendRedirect(req.getContextPath() + "/accessDenied.jsp");
            }
        }
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }
}