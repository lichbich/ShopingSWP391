package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.common.Pagination;
import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.dto.ColorDto;
import com.vn.fpt.g1.shop.entity.Color;

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
        String conditionSql = " color pc " +
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

    public int addNewColor(Color color) throws SQLException {
        String sql = "insert into product_color (color_name, color_code) " +
                "values (?,?)";
        int result = 0;
        try ( Connection connection = getConnection();  PreparedStatement stm = connection.prepareStatement(sql)) {
            stm.setString(1, color.getColorName());
            stm.setString(2, color.getColorCode());
            result = stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }


    public ColorDto getColorById(Integer colorId, String colorCode){
        String sql = "";
        ColorDto colorDto = new ColorDto();

        try {
            PreparedStatement stm;

            if (colorId != null) {
                sql = "SELECT * FROM dbo.product_color c WHERE c.product_color_id = ?";
                stm = connection.prepareStatement(sql);
                stm.setLong(1, colorId);
            }
            else if (colorCode != null) {
                sql = "SELECT * FROM dbo.product_color c WHERE c.color_code = ?";
                stm = connection.prepareStatement(sql);
                stm.setString(1, colorCode);
            } else {
                return colorDto;
            }

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                colorDto.setProductColorId(rs.getLong("product_color_id"));
                colorDto.setColorName(rs.getString("color_name"));
                colorDto.setColorCode(rs.getString("color_code"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return colorDto;
    }
}
