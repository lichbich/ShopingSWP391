package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Users> getListCustomer() {
        List<Users> list = new ArrayList<>();
        String sql = "select * from users\n" +
                "where users.role_id = '1'";
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

}
