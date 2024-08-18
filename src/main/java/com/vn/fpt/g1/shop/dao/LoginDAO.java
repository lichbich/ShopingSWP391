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
            String query = "SELECT email, password FROM [user] WHERE email = ?";
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
//            ps.setString(2, plainPassword);
            rs = ps.executeQuery();
            if(rs.next()){
//                // Create a Users object with the retrieved data
//                Users user = new Users(rs.getString("email"), rs.getString("password"));
//                // Compare the provided password with the stored hashed password
//                if (BCrypt.checkpw(plainPassword, user.getPassword())) {
//                    return user; // Password matches
//                }
                String storedPassword = rs.getString("password");
                if (BCrypt.checkpw(plainPassword, storedPassword)) {
                    return new Users(rs.getString("email"), storedPassword);
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