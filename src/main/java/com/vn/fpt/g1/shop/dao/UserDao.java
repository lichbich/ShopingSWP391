package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class UserDao extends DbContext {

    // Kiểm tra xem tài khoản có tồn tại không
    public User checkAccountExist(String email) {
        String query = "SELECT [user_id], [first_name], [last_name], [email], [password] FROM [users] WHERE [email] = ?";
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getInt("user_id"),
                            rs.getString("first_name"),
                            rs.getString("last_name"),
                            rs.getString("email"),
                            rs.getString("password")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error checking account existence", e);
        }
        return null;
    }

    // Đăng ký người dùng mới
    public void register(String firstname, String lastname, String address, Date dob, String phonenumber, String email, String password, String gender, Timestamp createtime, Timestamp updatetime) {
        String query = "INSERT INTO [dbo].[users] ([first_name], [last_name], [address], [dob], [phone_number], [email], [isActive], [role_id], [password], [gender], [create_date], [update_date]) VALUES (?, ?, ?, ?, ?, ?, 1, 4, ?, ?, ?, ?)";
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, address);
            ps.setDate(4, new java.sql.Date(dob.getTime()));
            ps.setString(5, phonenumber);
            ps.setString(6, email);
            ps.setString(7, password);
            ps.setString(8, gender);
            ps.setTimestamp(9, createtime);
            ps.setTimestamp(10, updatetime);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error registering user", e);
        }
    }

    // Thay đổi mật khẩu
    public void changePassword(String email, String newPassword) {
        String query = "UPDATE [dbo].[users] SET [password] = ? WHERE [email] = ?";
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, newPassword);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error changing password", e);
        }
    }

    // Xác thực mật khẩu hiện tại
    public boolean authenticate(String email, String password) {
        String query = "SELECT [password] FROM [users] WHERE [email] = ?";
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, email);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String storedPassword = rs.getString("password");
                    return storedPassword.equals(password);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error authenticating user", e);
        }
        return false;
    }
}
