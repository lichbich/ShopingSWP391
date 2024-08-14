package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.dto.CategoryDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private Connection connection;

    public CategoryDAO() {
        connection = DbContext.getConnection();
    }

    public List<CategoryDto> getAllCategories() throws SQLException {
        List<CategoryDto> categories = new ArrayList<>();
        String query = "SELECT category_id, description, status FROM category";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("category_id");
                String description = rs.getString("description");
                int status = rs.getInt("status");

                categories.add(new CategoryDto(id, description, status));
            }
        }

        return categories;
    }

    public void addCategory(CategoryDto category) throws SQLException {
        String query = "INSERT INTO category (description, status, create_date, update_date) VALUES (?, ?, GETDATE(), GETDATE())";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, category.getDescription());
            pstmt.setInt(2, category.getStatus());
            pstmt.executeUpdate();
        }
    }

    public void updateCategory(CategoryDto category) throws SQLException {
        String query = "UPDATE category SET description = ?, status = ?, update_date = GETDATE() WHERE category_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, category.getDescription());
            pstmt.setInt(2, category.getStatus());
            pstmt.setInt(3, category.getId());
            pstmt.executeUpdate();
        }
    }

    public void changeStatus(int id, int status) throws SQLException {
        String query = "UPDATE category SET status = ?, update_date = GETDATE() WHERE category_id = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setInt(1, status);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
        }
    }
}
