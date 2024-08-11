package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.common.BusinessCommon;
import com.vn.fpt.g1.shop.common.Pagination;
import com.vn.fpt.g1.shop.dao.StockDao;
import com.vn.fpt.g1.shop.dto.ProductStockDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/stock")
public class StockServlet extends HttpServlet {
    private final StockDao stockDao = new StockDao();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        int size = 10;
        String productCode = "";
        String productName = "";
        long isActive = 0L;

        String pageParam = req.getParameter("page");
        String sizeParam = req.getParameter("size");
        String productCodeRaw = req.getParameter("productCode");
        String productNameRaw = req.getParameter("productName");
        String isActiveRaw = req.getParameter("isActive");

        if (pageParam != null && !pageParam.isEmpty()) {
            page = BusinessCommon.validatePage(pageParam, page, 1);
        }
        if (sizeParam != null && !sizeParam.isEmpty()) {
            size = BusinessCommon.validatePage(sizeParam, size, 10);
        }
        Pagination pagination = new Pagination(page, size);

        if(!BusinessCommon.isNullOrEmpty(productCodeRaw)){
            productCode = productCodeRaw;
        }

        if(!BusinessCommon.isNullOrEmpty(productNameRaw)){
            productName = productNameRaw;
        }

        if(!BusinessCommon.isNullOrEmpty(isActiveRaw)){
            isActive = Long.parseLong(isActiveRaw);
        }

        List<ProductStockDto> stockList = stockDao.listProductWithStock(pagination, productCode, productName, isActive);
        req.setAttribute("stock", stockList);
        req.setAttribute("pagination", pagination);
//        req.getRequestDispatcher("../webapp/stock-management/stock-page.jsp").forward(req, resp);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/stock-management/stock-page.jsp");
        if (dispatcher == null) {
            throw new ServletException("Dispatcher not found for path: " + "/stock-management/stock-page.jsp");
        }

        dispatcher.forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
