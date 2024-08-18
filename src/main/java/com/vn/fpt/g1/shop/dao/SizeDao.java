package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.dto.SizeDto;

import java.sql.*;
import java.time.LocalDate;

public class SizeDao extends DbContext {
//    private final Connection connection = DbContext.getConnection();
//
//    public SizeDto getSizeByIdOrValue(Long sizeId, Long size) {
//        String sql = "";
//        SizeDto sizeDto = new SizeDto();
//
//        try {
//            PreparedStatement stm;
//
//            if (sizeId != null) {
//                sql = "SELECT * FROM dbo.size s WHERE s.size_id = ?";
//                stm = connection.prepareStatement(sql);
//                stm.setLong(1, sizeId);
//            }
//            else if (size != null) {
//                sql = "SELECT * FROM dbo.size s WHERE s.size = ?";
//                stm = connection.prepareStatement(sql);
//                stm.setLong(1, size);
//            } else {
//                return sizeDto;
//            }
//
//            ResultSet rs = stm.executeQuery();
//            if (rs.next()) {
//                sizeDto.setSizeId(rs.getLong("size_id"));
//                sizeDto.setSize(rs.getLong("size"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return sizeDto;
//    }
//
//    public void insertSize(SizeDto sizeDto, long productId) {
//        String sql = "INSERT INTO dbo.size (size_id, size, product_id, create_date, update_date) VALUES (?, ?, ?, ?, ?)";
//
//        try {
//            PreparedStatement stm = connection.prepareStatement(sql);
//
//            stm.setLong(1, sizeDto.getSizeId());
//            stm.setLong(2, sizeDto.getSize());
//            stm.setLong(3, productId);
//            stm.setDate(4, Date.valueOf(LocalDate.now()));
//            stm.setDate(5,Date.valueOf(LocalDate.now()));
//
//            int rowsInserted = stm.executeUpdate();
//
//            if (rowsInserted > 0) {
//                System.out.println("A new size was inserted successfully!");
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }

}
