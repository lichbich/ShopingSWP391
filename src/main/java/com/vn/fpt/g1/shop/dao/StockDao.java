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
import java.util.List;

public class StockDao extends DbContext {
    private final Connection connection = DbContext.getConnection();

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
}
