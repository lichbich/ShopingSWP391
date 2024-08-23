package com.vn.fpt.g1.shop.servlet;

import com.vn.fpt.g1.shop.dao.AdminDao;
import com.vn.fpt.g1.shop.dao.ProductDetailDAO;
import com.vn.fpt.g1.shop.entity.ProductDetail;
import com.vn.fpt.g1.shop.entity.Role;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.soap.Detail;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "ImportProductDetailServlet", value = "/import-product-detail")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB
        maxFileSize=1024*1024*50,      	// 50 MB
        maxRequestSize=1024*1024*100)
public class ImportProductDetailServlet extends HttpServlet {

    private static final String UPLOAD_DIR = "uploads";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("importProduct.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        InputStream fileContent = filePart.getInputStream();

        Workbook workbook = new XSSFWorkbook(fileContent);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        ProductDetailDAO productDetailDAO = new ProductDetailDAO();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            if (row.getRowNum() == 0) {
                continue;
            }
            ProductDetail productDetail = new ProductDetail();
            productDetail.setColor_code((int) row.getCell(0).getNumericCellValue());
            productDetail.setPrice(row.getCell(3).getNumericCellValue());
            productDetail.setSize((float)row.getCell(1).getNumericCellValue());
            productDetail.setQuantity((int)row.getCell(2).getNumericCellValue());
            productDetailDAO.addProductDetail(productDetail);
        }
        workbook.close();
        request.setAttribute("data", "success");
        request.getRequestDispatcher("/importProduct.jsp").forward(request, response);
    }
    }

