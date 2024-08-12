package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.*;



public class UserDao extends DbContext {
    private Connection conn = null ;
    private PreparedStatement ps = null;
    private ResultSet rs = null;






    public User checkAccountExist(String email) {
        String query = "select [user_id],[first_name], [last_name], [email], [password] from [users]\n" +
                "where [email] = ?\n";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while(rs.next()){
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
            conn.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;

    }

    public void register(String firstname, String lastname, String address, Date dob, String phonenumber, String email, String password, String gender, Timestamp createtime, Timestamp updatetime ){


        String query = "INSERT INTO [dbo].[users]\n" +
                "           ([first_name],[last_name],[address],[dob],[phone_number],[email],[isActive],[role_id],[password],[gender],[create_date],[update_date])\n" +
                "     VALUES\n" +
                "           (?,?,?,?,?,?,1,4,? ,?, ?, ?)\n";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,firstname);
            ps.setString(2, lastname);
            ps.setString(3, address);
            ps.setDate(4,dob);
            ps.setString(5, phonenumber);
            ps.setString(6, email);
            ps.setString(7, gender);
            ps.setString(8, password);
            ps.setTimestamp(9,createtime);
            ps.setTimestamp(10, updatetime);
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
        }
    }


}
