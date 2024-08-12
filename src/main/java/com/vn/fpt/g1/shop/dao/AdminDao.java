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
        String query = "select u.first_name, u.last_name, u.[address], u.phone_number, u.email, r.role_name\n" +
                "from users u\n" +
                "join [role] r on u.role_id = r.role_id\n" +
                "where r.[priority] = 1";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
            conn.close();

        } catch (Exception e) {
        }
        return list;
    }

    public List<User> search(String role, String active, String name){
        List<User> list = new ArrayList<>();
        StringBuilder query = new StringBuilder("select u.first_name, u.last_name, u.[address], u.phone_number, u.email, r.role_name\n" +
                " from users u join [role] r \n" +
                " on u.role_id = r.role_id\n" +
                " where r.[priority] = 1");
        if (!"all".equalsIgnoreCase(role)) {
            query.append(" AND u.role_id = ?");
        }
        if (!"all".equalsIgnoreCase(active)) {
            query.append(" AND subcategory_id = ?");
        }
        if (name != null) {
            query.append(" AND brand_id like %?%");
        }


        return list;
    }

    public List<Role> getEmployeeRole(){
        List<Role> list= new ArrayList<>();
        String query = "select role_id, role_name\n" +
                "from [role]\n" +
                "where [priority] = 1";
        try{
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Role(rs.getInt(1),
                        rs.getString(2)));
            }
            conn.close();
        }catch (Exception e){

        }
        return list;
    }

    public void addEmployee(String firstname, String lastname, String email, String phone, String password, String roleId, Timestamp createTime){

        String query = "INSERT INTO [dbo].[users]\n" +
                "([first_name],[last_name],[phone_number],[email],[isActive],[role_id],[password],[create_date])\n" +
                "VALUES\n" +
                "(?,?,?,?,1,?,?,?)";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,firstname);
            ps.setString(2, lastname);
            ps.setString(3, phone);
            ps.setString(4,email);
            ps.setString(5, roleId);
            ps.setString(6, password);
            ps.setTimestamp(7, createTime);
            ps.executeUpdate();
            conn.close();
        }catch (Exception e){
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
