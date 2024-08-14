package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Users> getListCustomer() {
        List<Users> list = new ArrayList<>();
        String sql = "select * from users\n" +
                "where users.role_id = '3'";
        try {
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setUser_id(rs.getInt("user_id"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setDob(rs.getDate("dob"));
                user.setPhone_number(rs.getString("phone_number"));
                user.setEmail(rs.getString("email"));
                user.setIsActive(rs.getInt("isActive"));
                user.setRole_id(rs.getString("role_id"));
                list.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Users> getListCustomerByID(String user_id) {
        List<Users> list = new ArrayList<>();
        String sql = "select * from users\n" +
                "where users.user_id = ?";
        try {
            conn = new DbContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                Users user = new Users();
                user.setUser_id(rs.getInt("user_id"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setGender(rs.getString("gender"));
                user.setAddress(rs.getString("address"));
                user.setDob(rs.getDate("dob"));
                user.setPhone_number(rs.getString("phone_number"));
                user.setEmail(rs.getString("email"));
                user.setIsActive(rs.getInt("isActive"));
                user.setRole_id(rs.getString("role_id"));
                list.add(user);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Users> getFilteredCustomers(String name, String status) {
        List<Users> customers = new ArrayList<>();

        String query = "SELECT * FROM users WHERE 1=1";

        if (name != null && !name.isEmpty()) {
            query += " AND (first_name LIKE ? OR last_name LIKE ?)";
        }

        if (status != null && !status.isEmpty()) {
            query += " AND isActive = ?";
        }
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            int paramIndex = 1; // Chỉ số của tham số trong câu lệnh PreparedStatement


            if (name != null && !name.isEmpty()) {
                ps.setString(paramIndex++, "%" + name + "%");
                ps.setString(paramIndex++, "%" + name + "%");
            }


            if (status != null && !status.isEmpty()) {
                ps.setInt(paramIndex++, "active".equals(status) ? 1 : 0);
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Users users = new Users();
                    users.setUser_id(rs.getInt("user_id"));
                    users.setFirst_name(rs.getString("first_name"));
                    users.setLast_name(rs.getString("last_name"));
                    users.setGender(rs.getString("gender"));
                    users.setAddress(rs.getString("address"));
                    users.setDob(rs.getDate("dob"));
                    users.setPhone_number(rs.getString("phone_number"));
                    users.setEmail(rs.getString("email"));
                    users.setIsActive(rs.getInt("isActive"));

                    // Thêm đối tượng Customer vào danh sách
                    customers.add(users);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public void updateCustomerStatus(String userId, int newStatus) {
        String sql = "UPDATE users SET isActive = ? WHERE user_id = ?";

        try (Connection conn = new DbContext().getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, newStatus);
            ps.setString(2, userId);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
