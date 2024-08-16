package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.common.BusinessCommon;
import com.vn.fpt.g1.shop.common.Pagination;
import com.vn.fpt.g1.shop.dao.StockDao;
import com.vn.fpt.g1.shop.dto.ProductImportDto;
import com.vn.fpt.g1.shop.dto.ProductStockDto;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/stock")
@MultipartConfig
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
        Part filePart = req.getPart("file");
        String contentType = filePart.getContentType();

        // Validate the file type
        if (!StockDao.TYPE.equals(contentType)) {
            resp.getWriter().println("Invalid file format. Please upload an Excel file.");
            return;
        }

        // Process the file
        try (InputStream fileContent = filePart.getInputStream()) {
            List<ProductImportDto> productList = StockDao.excelToProductList(fileContent);

            req.getRequestDispatcher("/stock-management/stock-page.jsp").forward(req, resp);
        } catch (Exception e) {
            resp.getWriter().println("Error processing file: " + e.getMessage());
        }
    }
}
