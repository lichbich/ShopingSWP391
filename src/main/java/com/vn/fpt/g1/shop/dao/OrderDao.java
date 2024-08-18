package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.common.Pagination;
import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.dto.DetailOrderDto;
import com.vn.fpt.g1.shop.dto.MyOrderDto;
import com.vn.fpt.g1.shop.dto.ProductStockDto;
import com.vn.fpt.g1.shop.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDao extends DbContext {
    private final Connection connection = DbContext.getConnection();

    public MyOrderDto getOrderById(Long orderId) {
        String sql = "SELECT * FROM order_detail od " +
                "JOIN dbo.[order] o on o.order_id = od.order_id " +
                "JOIN dbo.product_detail pd on pd.product_detail_id = od.product_detail_id " +
                "JOIN dbo.[user] u on u.user_id = o.user_id " +
                "JOIN dbo.product p on pd.product_id = p.product_id " +
                "WHERE od.order_id = ?";
        MyOrderDto myOrder = new MyOrderDto();

        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setLong(1, orderId);


            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                myOrder.setOrderId(rs.getLong("od.order_id"));
                myOrder.setStatus(rs.getString("status"));
                myOrder.setOrderDate(rs.getDate("order_date"));
                myOrder.setTotalPrice(rs.getDouble("total_price"));
                myOrder.setShippingAddress(rs.getString("shipping_address"));
                myOrder.setReceiverName(rs.getString("receiver_name"));
                myOrder.setReceiverPhone(rs.getString("receiver_phone"));

                DetailOrderDto detailOrderDto = new DetailOrderDto();
                detailOrderDto.setProductId(rs.getLong("pd.product_id"));
                detailOrderDto.setProductName(rs.getString("product_name"));
                detailOrderDto.setColorCode(rs.getLong("color_code"));
                detailOrderDto.setSize(rs.getDouble("size"));
                detailOrderDto.setQuantity(rs.getLong("od.quantity"));
                detailOrderDto.setPrice(rs.getDouble("pd.price"));
                detailOrderDto.setTotalPriceOfProduct(rs.getDouble("od.price"));

                myOrder.setDetailOrder(detailOrderDto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return myOrder;
    }

    public List<Order> getAllOrderByUserId(int userId, Pagination pagination, String status, Date fromDate, Date endDate) {
        List<Order> orderList = new ArrayList<>();
        String sql = "SELECT * FROM [order] o WHERE o.user_id = ?" +
//                " AND (? IS NULL OR LOWER(o.status) LIKE ?)" +
//                " AND (? IS NULL OR o.order_date >= ?)" +
//                " AND (? IS NULL OR o.order_date <= ?)" +
                " ORDER BY o.order_date DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        String countSql = "SELECT COUNT(*) FROM [order] o " +
                "WHERE o.user_id = ?" +
                " AND (? IS NULL OR LOWER(o.status) LIKE ?)" +
                " AND (? IS NULL OR o.order_date >= ?)" +
                " AND (? IS NULL OR o.order_date <= ?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            PreparedStatement countPstmt = connection.prepareStatement(countSql);

            int paramIndex = 1;
//            pstmt.setInt(paramIndex++, userId);
//            pstmt.setString(paramIndex++, status);
//            pstmt.setString(paramIndex++, status != null ? "%" + status.toLowerCase() + "%" : null);
//            pstmt.setDate(paramIndex++, fromDate);
//            pstmt.setDate(paramIndex++, fromDate);
//            pstmt.setDate(paramIndex++, endDate);
//            pstmt.setDate(paramIndex++, endDate);
            pstmt.setInt(paramIndex++, pagination.getOffset());
            pstmt.setInt(paramIndex, pagination.getSize());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getLong("order_id"));
                order.setUserId(rs.getLong("user_id"));
                order.setStatus(rs.getString("status"));
                order.setOrderDate(rs.getDate("order_date"));
                order.setTotalPrice(rs.getDouble("total_price"));
                order.setShippingAddress(rs.getString("shipping_address"));
                order.setReceiverName(rs.getString("receiver_name"));
                order.setReceiverPhone(rs.getString("receiver_phone"));

                orderList.add(order);
            }

            paramIndex = 1;
            countPstmt.setInt(paramIndex++, userId);
            countPstmt.setString(paramIndex++, status);
            countPstmt.setString(paramIndex++, status != null ? "%" + status.toLowerCase() + "%" : null);
            countPstmt.setDate(paramIndex++, fromDate);
            countPstmt.setDate(paramIndex++, fromDate);
            countPstmt.setDate(paramIndex++, endDate);
            countPstmt.setDate(paramIndex, endDate);

            ResultSet countRs = countPstmt.executeQuery();
            if (countRs.next()) {
                long totalElements = countRs.getLong(1);
                pagination.setTotalElements(totalElements);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderList;
    }
}
