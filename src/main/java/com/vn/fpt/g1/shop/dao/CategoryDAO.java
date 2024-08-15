package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.dto.CategoryDto;
import com.vn.fpt.g1.shop.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private static final String GET_ALL_CATEGORIES = "SELECT * FROM category";
    private static final String GET_CATEGORY_BY_ID = "SELECT * FROM category WHERE category_id = ?";
    private static final String ADD_CATEGORY = "INSERT INTO category (description, status, create_date, update_date) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_CATEGORY = "UPDATE category SET description = ?, status = ?, update_date = ? WHERE category_id = ?";
    private static final String CHANGE_STATUS = "UPDATE category SET status = CASE WHEN status = 1 THEN 0 ELSE 1 END WHERE category_id = ?";

    // Method to get all categories
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryList = new ArrayList<>();
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_ALL_CATEGORIES);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                CategoryDto category = new CategoryDto();
                category.setCategoryId(rs.getInt("category_id"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getInt("status"));
                category.setCreateDate(rs.getTimestamp("create_date"));
                category.setUpdateDate(rs.getTimestamp("update_date"));
                categoryList.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categoryList;
    }

    // Method to get a category by ID
    public CategoryDto getCategoryById(int categoryId) {
        CategoryDto category = null;
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(GET_CATEGORY_BY_ID)) {

            ps.setInt(1, categoryId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    category = new CategoryDto();
                    category.setCategoryId(rs.getInt("category_id"));
                    category.setDescription(rs.getString("description"));
                    category.setStatus(rs.getInt("status"));
                    category.setCreateDate(rs.getTimestamp("create_date"));
                    category.setUpdateDate(rs.getTimestamp("update_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    // Method to add a new category
    public void addCategory(CategoryDto categoryDto) throws SQLException {
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(ADD_CATEGORY)) {
            ps.setString(1, categoryDto.getDescription());
            ps.setInt(2, categoryDto.getStatus());
            ps.setTimestamp(3, categoryDto.getCreateDate());
            ps.setTimestamp(4, categoryDto.getUpdateDate());
            ps.executeUpdate();
        }
    }

    // Method to update an existing category
    public void updateCategory(CategoryDto category) {
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_CATEGORY)) {

            ps.setString(1, category.getDescription());
            ps.setInt(2, category.getStatus());
            ps.setTimestamp(3, category.getUpdateDate());
            ps.setInt(4, category.getCategoryId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to change category status
    public void changeCategoryStatus(int categoryId) {
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(CHANGE_STATUS)) {

            ps.setInt(1, categoryId);
            int affectedRows = ps.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("No rows affected");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
