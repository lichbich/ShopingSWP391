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
        String query = "select [User_ID],[First_name], [Last_name], [Email], [Password] from [User]\n" +
                "where [Email] = ?\n";
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

    public void register(String firstname, String lastname, String address, Date dob, String phonenumber, String email, String password, String gender ){
        // take current time
        LocalDateTime now = LocalDateTime.now();
        // format time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd kk:mm:ss");
        String formatedDateTime = now.format(formatter);

        String query = "INSERT INTO [dbo].[User]\n" +
                "           ([First_name],[Last_name],[Adresss],[Dob],[PhoneNumber],[Email],[isActive],[Role_ID],[Password],[Gender],[Create_date],[Update_date])\n" +
                "     VALUES\n" +
                "           (?,?,?,?,?,?,1,4,? ,?," + formatedDateTime +","+ formatedDateTime +")\n";
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
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
        }
    }


}
