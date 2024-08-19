package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.OrderTracking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrackingDao extends DbContext {
    private final Connection connection = DbContext.getConnection();

    public List<OrderTracking> getListTrackingByOrderId(Long orderId) {
        String sql = "SELECT * FROM order_tracking ot " +
                "WHERE ot.order_id = ?";
        List<OrderTracking> trackingList = new ArrayList<>();
        try {
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setLong(1, orderId);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                OrderTracking orderTracking = new OrderTracking();
                orderTracking.setOrderTrackingId(rs.getLong("order_tracking_id"));
                orderTracking.setOrderId(rs.getLong("order_id"));
                orderTracking.setStatus(rs.getString("status"));
                orderTracking.setBeginShipping(rs.getDate("begin_shipping"));
                orderTracking.setReceiveDate(rs.getDate("receive_date"));
                trackingList.add(orderTracking);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return trackingList;
    }
}
