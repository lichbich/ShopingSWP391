package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.Role;
import com.vn.fpt.g1.shop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AdminDao extends DbContext {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<User> getAllEmployee() {
        List<User> list = new ArrayList<>();
        String query = "select u.user_id, u.first_name, u.last_name, u.[address], u.phone, u.email, r.role_name\n" +
                "from [users] u\n" +
                "join [role] r on u.role_id = r.role_id\n" +
                "where r.[priority] = 1";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            conn.close();

        } catch (Exception e) {
        }
        return list;
    }

    public User getEmployeeById(int id) {
        User user = null;
        String query = "SELECT u.[user_id],u.[first_name],u.[last_name], u.[address], u.[dob], u.[phone], u.[email], u.[is_active],u.[password],u.[gender],u.[create_date],u.[update_date] ,r.role_id, r.role_name\n" +
                "  FROM [dbo].[users] u\n" +
                "  Join [role] r on u.role_id = r.role_id\n" +
                "  where user_id = ?";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getTimestamp(11),
                        rs.getTimestamp(12),
                        rs.getInt(13),
                        rs.getString(14));
            }
            conn.close();
        } catch (Exception e) {

        }
        return user;
    }

    public void editEmployee(int status, int role_id, String email, Timestamp updatetime) {
        String query = "update dbo.[users]\n" +
                "set is_active = ?, role_id = ?, [update_date] = ?\n" +
                "where [email] = ?";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            ps.setInt(2, role_id);
            ps.setTimestamp(3, updatetime);
            ps.setString(4, email);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {

        }
    }

    public List<User> search(String role, String status, String name) {
        List<User> list = new ArrayList<>();

        String query = "select u.user_id, u.first_name, u.last_name, u.[address], u.phone, u.email, r.role_name\n" +
                "from [users] u join [role] r\n" +
                " on u.role_id = r.role_id\n" +
                "where r.[priority] = 1";
        if (role != null &&!role.equals("all") ){
            query += " AND u.role_id = ?";

        }
        if (status != null && !status.equals("all") ){
            query += " AND u.is_active = ?";

        }
        if (name != null && !name.isEmpty()) {
            query += " AND u.first_name like ?";

        }

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            int index = 1;
            if (role != null && !role.equals("all")) {
                ps.setString(index++, role);
            }
            if (status != null && !status.equals("all")) {
                ps.setString(index++, status);
            }
            if (name != null && !name.isEmpty()) {
                ps.setString(index++, "%" + name + "%");
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            conn.close();


        } catch (Exception e) {

        }


        return list;
    }

    public List<Role> getEmployeeRole() {
        List<Role> list = new ArrayList<>();
        String query = "select role_id, role_name\n" +
                "from [role]\n" +
                "where [priority] = 1";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Role(rs.getInt(1),
                        rs.getString(2)));
            }
            conn.close();
        } catch (Exception e) {

        }
        return list;
    }

    public void addEmployee(String firstname, String lastname, String email, String phone, String password, String roleId, Timestamp createTime) {

        String query = "INSERT INTO [dbo].[users]\n" +
                "([first_name],[last_name],[phone],[email],[is_active],[role_id],[password],[create_date])\n" +
                "VALUES\n" +
                "(?,?,?,?,1,?,?,?)";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, phone);
            ps.setString(4, email);
            ps.setString(5, roleId);
            ps.setString(6, password);
            ps.setTimestamp(7, createTime);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
        }

    }

//    public static void main(String[] args) {
//        AdminDao dao = new AdminDao();
//        List<User> list = dao.getAllEmployee();
//        for(User u: list){
//            System.out.println(u);
//        }
//    }
}
