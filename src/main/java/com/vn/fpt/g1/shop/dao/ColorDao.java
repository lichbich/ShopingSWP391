package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.common.Pagination;
import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.dto.ColorDto;
import com.vn.fpt.g1.shop.dto.ProductStockDto;
import com.vn.fpt.g1.shop.dto.SizeDto;
import com.vn.fpt.g1.shop.entity.ProductColor;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDao extends DbContext {
    private final Connection connection = DbContext.getConnection();

    public List<ColorDto> listAllColor(Pagination pagination, String colorName, String colorCode){
        List<ColorDto> list = new ArrayList<>();
        String conditionSql = " product_color pc " +
                " WHERE LOWER(pc.color_name) LIKE ? " +
                " AND LOWER(pc.color_code) LIKE ? ";
        String sql = "SELECT * FROM " + conditionSql + " ORDER BY pc.create_date desc " + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        String countSql = "SELECT COUNT(*) FROM " + conditionSql;

        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            PreparedStatement countPstmt = connection.prepareStatement(countSql);

            pstmt.setString(1, "%" + colorName.toLowerCase() + "%");
            pstmt.setString(2, "%" + colorCode.toLowerCase() + "%");
            pstmt.setInt(3, pagination.getSize());
            pstmt.setInt(4, pagination.getOffset());
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                ColorDto colorDto = new ColorDto();
                colorDto.setProductColorId(rs.getLong("product_color_id"));
                colorDto.setColorName(rs.getString("color_name"));
                colorDto.setColorCode(rs.getString("color_code"));
                list.add(colorDto);
            }
            countPstmt.setString(1, "%" + colorName.toLowerCase() + "%");
            countPstmt.setString(2, "%" + colorCode.toLowerCase() + "%");
            ResultSet countRs = countPstmt.executeQuery();
            if (countRs.next()) {
                long totalElements = countRs.getLong(1);
                pagination.setTotalElements(totalElements);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int addNewColor(ProductColor color) throws SQLException {
        String sql = "insert into product_color (product_id, product_color_id, color_name, color_code, create_date, update_date) " +
                "values (?,?,?,?,?,?)";
        int result = 0;
        try ( Connection connection = getConnection();  PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setLong(1, color.getProductId());
            stm.setLong(2, color.getProductColorId());
            stm.setString(3, color.getColorName());
            stm.setString(4, color.getColorCode());
            stm.setDate(5, color.getCreateDate());
            stm.setDate(6, color.getUpdateDate());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
