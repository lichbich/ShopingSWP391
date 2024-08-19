package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.Users;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public Users checkLogin(String email, String plainPassword){
        try{
            String query = "SELECT user_id, email, password, role_id FROM users WHERE email = ?";
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
//            ps.setString(2, plainPassword);
            rs = ps.executeQuery();
            if(rs.next()){
                String storedPassword = rs.getString("password");
                if (BCrypt.checkpw(plainPassword, storedPassword)) {
                    Users user = new Users();
                    user.setUser_id(rs.getInt("user_id"));
                    user.setEmail(rs.getString("email"));
                    user.setPassword(storedPassword);
                    user.setRole_id(rs.getString("role_id"));
                    return user;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}