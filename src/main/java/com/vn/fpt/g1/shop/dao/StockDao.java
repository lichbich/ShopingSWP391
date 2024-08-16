package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.common.Pagination;
import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.dto.ColorDto;
import com.vn.fpt.g1.shop.dto.ProductStockDto;
import com.vn.fpt.g1.shop.dto.SizeDto;
import com.vn.fpt.g1.shop.entity.ProductDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.vn.fpt.g1.shop.dto.ProductImportDto;
import com.vn.fpt.g1.shop.dto.ProductStockDto;
import com.vn.fpt.g1.shop.dto.SizeDto;
import jakarta.servlet.http.Part;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StockDao extends DbContext {
    private final Connection connection = DbContext.getConnection();
    private final ColorDao colorDao = new ColorDao();
    private final SizeDao sizeDao = new SizeDao();
    public List<ProductStockDto> listProductWithStock(Pagination pagination, String productCode, String productName, Long isActive) {
        List<ProductStockDto> stockList = new ArrayList<>();
        String conditionSql = " product_detail pd " +
                " JOIN product p ON pd.product_id = p.product_id " +
                " JOIN product_color c ON pd.product_id = c.product_id " +
                " JOIN image_product i ON pd.product_id = i.product_id " +
                " WHERE LOWER(pd.product_code) LIKE ? " +
                " AND LOWER(p.product_name) LIKE ? " +
                " AND pd.isActive = ? ";
        String sql = "SELECT * FROM " + conditionSql + " ORDER BY pd.create_date desc " + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        String countSql = "SELECT COUNT(*) FROM " + conditionSql;
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            PreparedStatement countPstmt = connection.prepareStatement(countSql);
            pstmt.setString(1, "%" + productCode.toLowerCase() + "%");
            pstmt.setString(2, "%" + productName.toLowerCase() + "%");
            pstmt.setLong(3, isActive);
            pstmt.setInt(4, pagination.getSize());
            pstmt.setInt(5, pagination.getOffset());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ProductStockDto stockDto = new ProductStockDto();
                stockDto.setProductId(rs.getInt("product_id"));
                stockDto.setProductName(rs.getString("product_name"));
                stockDto.setProductCode(rs.getString("product_code"));
                stockDto.setDescription(rs.getString("description"));
                stockDto.setPrice(rs.getDouble("product_price"));
                stockDto.setIsActive(rs.getInt("isActive"));
                stockDto.setImageUrl(rs.getString("image_url"));
                stockDto.setQuantity(rs.getLong("quantity"));

                ColorDto colorDto = new ColorDto();
                colorDto.setProductColorId(rs.getLong("product_color_id"));
                colorDto.setColorName(rs.getString("color_name"));
                colorDto.setColorCode(rs.getString("color_code"));

                SizeDto sizeDto = new SizeDto();
                sizeDto.setSizeId(rs.getLong("size_id"));
                sizeDto.setSize(rs.getLong("size"));

                stockDto.getColorDtos().add(colorDto);
                stockDto.getSizeDtos().add(sizeDto);
                stockList.add(stockDto);
            }

            countPstmt.setString(1, "%" + productCode.toLowerCase() + "%");
            countPstmt.setString(2, "%" + productName.toLowerCase() + "%");
            countPstmt.setLong(3, isActive);
            ResultSet countRs = countPstmt.executeQuery();
            if (countRs.next()) {
                long totalElements = countRs.getLong(1);
                pagination.setTotalElements(totalElements);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return stockList;
    }

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "ID", "Name", "Code", "Description", "Price", "Color", "Size","Quantity" };
    static String SHEET = "product";

    public static boolean hasExcelFormat(Part filePart) {
        return TYPE.equals(filePart.getContentType());
    }

    public static boolean hasExcelFormat(InputStream is, String contentType) {
        return TYPE.equals(contentType);
    }

    public static List<ProductImportDto> excelToProductList(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SHEET);
            Iterator<Row> rows = sheet.iterator();

            List<ProductImportDto> productList = new ArrayList<>();
            int rowNumber = 0;

            while (rows.hasNext()) {
                Row currentRow = rows.next();

                // Skip header
                if (rowNumber == 0) {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cellsInRow = currentRow.iterator();
                ProductImportDto product = new ProductImportDto();

                int cellIdx = 0;
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    switch (cellIdx) {
                        case 0:
                            product.setProductId((long) currentCell.getNumericCellValue());
                            break;
                        case 1:
                            product.setProductName(currentCell.getStringCellValue());
                            break;
                        case 2:
                            product.setProductCode(currentCell.getStringCellValue());
                            break;
                        case 3:
                            product.setDescription(currentCell.getStringCellValue());
                            break;
                        case 4:
                            product.setPrice(currentCell.getNumericCellValue());
                            break;
                        case 5:
                            product.setColorCode(currentCell.getStringCellValue());
                            break;
                        case 6:
                            product.setSize((int) currentCell.getNumericCellValue());
                            break;
                        case 7:
                            product.setQuantity((long) currentCell.getNumericCellValue());
                            break;
                        default:
                            break;
                    }

                    cellIdx++;
                }

                productList.add(product);
            }

            workbook.close();
            return productList;
        } catch (IOException e) {
            throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
        }
    }

    public int addNewProduct(ProductImportDto productImportDto){
        String sql = "insert into dbo.product (product_id, product_name, description, product_code, price, import_date," +
                "                         create_date, update_date) " +
                "values (?,?,?,?,?,?,?,?)";
        int create = 0;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, productImportDto.getProductId());
            stm.setString(2, productImportDto.getProductName());
            stm.setString(3, productImportDto.getDescription());
            stm.setString(4, productImportDto.getProductCode());
            stm.setDouble(5, productImportDto.getPrice());
            stm.setDate(6, Date.valueOf(LocalDate.now()));
            stm.setDate(7, Date.valueOf(LocalDate.now()));
            stm.setDate(8, Date.valueOf(LocalDate.now()));
            create = stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return create;
    }

    public int addNewProductDetail(ProductImportDto productImportDto){
        String sql = "insert into product_detail (product_id, product_code, color_id, price, isActive, size_id, quantity, " +
                "                            create_date, update_date) " +
                "values (?,?,?,?,?,?,?,?,?)";
        int create = 0;
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, productImportDto.getProductId());
            stm.setString(2, productImportDto.getProductCode());
            stm.setLong(3, productImportDto.getColorDto().getProductColorId());
            stm.setDouble(4, productImportDto.getPrice());
            stm.setInt(5, 1);
            stm.setLong(6, productImportDto.getSizeDto().getSizeId());
            stm.setLong(7, productImportDto.getQuantity());
            stm.setDate(8, Date.valueOf(LocalDate.now()));
            stm.setDate(9, Date.valueOf(LocalDate.now()));
            create = stm.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return create;
    }
}
