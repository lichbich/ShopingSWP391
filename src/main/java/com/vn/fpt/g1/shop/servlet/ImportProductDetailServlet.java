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
        //get data from dao
        AdminDao dao = new AdminDao();
        List<Role> listRole = dao.getEmployeeRole();

        //set data to jsp
        request.setAttribute("listRole", listRole);
        request.getRequestDispatcher("add_employee.jsp").forward(request, response);

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
            productDetail.setProduct_id((int) row.getCell(1).getNumericCellValue());
            productDetail.setProduct_name(row.getCell(2).getStringCellValue());
            productDetail.setDescription(row.getCell(3).getStringCellValue());
            productDetail.setPrice(row.getCell(4).getNumericCellValue());
            productDetail.setColor_code((int)row.getCell(5).getNumericCellValue());
            productDetail.setSize(row.getCell(6).getStringCellValue());
            productDetail.setQuantity((int)row.getCell(7).getNumericCellValue());
            productDetailDAO.addProductDetail(productDetail);
        }
        workbook.close();
        request.setAttribute("data", "success");
        request.getRequestDispatcher("/display.jsp").forward(request, response);

    }
    }

