package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.Cart;
import com.vn.fpt.g1.shop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends DbContext {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Cart> getCartByEmail(String email) {
        List<Cart> list = new ArrayList<>();
        String query = "SELECT \n" +
                "    c.cart_id,u.[user_id],u.email,p.product_id,p.product_name,pd.size ,col.color_id,col.color_name, pd.price,c.quantity,i.image_url\n" +
                "    \n" +
                "FROM \n" +
                "    cart AS c\n" +
                "JOIN \n" +
                "    product_detail AS pd ON c.product_detail_id = pd.product_detail_id\n" +
                "JOIN \n" +
                "    product AS p ON pd.product_id = p.product_id\n" +
                "JOIN \n" +
                "    color AS col ON pd.color_code = col.color_id\n" +
                "JOIN \n" +
                "    [image] AS i ON p.product_id = i.product_id AND pd.color_code = i.color_id\n" +
                "JOIN \n" +
                "    [user] AS u ON c.[user_id] = u.[user_id]\n" +
                "WHERE \n" +
                "    u.email = ?";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getInt(10),
                        rs.getString(11)));
            }
            conn.close();
        } catch (Exception e) {

        }

        return list;
    }


    public User checkAccountExist(String email) {
        String query = "select [user_id],[first_name], [last_name], [email], [password] from [user]\n" +
                "where [email] = ?\n";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
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

    public void register(String firstname, String lastname, String address, Date dob, String phonenumber, String email, String password, String gender, Timestamp createtime, Timestamp updatetime) {


        String query = "INSERT INTO [dbo].[user]\n" +
                "           ([first_name],[last_name],[address],[dob],[phone],[email],[is_active],[role_id],[password],[gender],[create_date],[update_date])\n" +
                "     VALUES\n" +
                "           (?,?,?,?,?,?,1,4,? ,?, ?, ?)\n";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, address);
            ps.setDate(4, dob);
            ps.setString(5, phonenumber);
            ps.setString(6, email);
            ps.setString(7, password);
            ps.setString(8, gender);
            ps.setTimestamp(9, createtime);
            ps.setTimestamp(10, updatetime);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void deleteCart(int cid) {
        String query = "DELETE FROM [dbo].[cart]\n" +
                "      WHERE cart_id = ?";
        try{
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cid);
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){

        }
    }

    public void updateQuantity(int cid, int quantity){
        if (quantity <= 0) {
            deleteCart(cid);

        }else{
            String query = "UPDATE cart \n" +
                    "SET quantity = ? \n" +
                    "WHERE cart_id = ?";

            try{
                conn = DbContext.getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, quantity);
                ps.setInt(2,cid);
                ps.executeUpdate();
                conn.close();
            }catch (Exception e){

            }
        }
    }

    public User getCustomerByEmail(String email){
        User user = null;
        String query = "SELECT [user_id],[first_name],[last_name],[address],[phone],[email]\n" +
                "  FROM [dbo].[user]\n" +
                "  where email = ?";
        try{
            conn = DbContext.getConnection();
            ps= conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if(rs.next()){
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
            conn.close();
        }catch(Exception e){
        }
        return user;
    }


}
