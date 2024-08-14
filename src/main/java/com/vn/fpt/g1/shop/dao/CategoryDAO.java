package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.dto.CategoryDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    private Connection connection;

    public CategoryDAO() {
        this.connection = DbContext.getConnection();
    }

    public List<CategoryDto> getAllCategories() throws SQLException {
        List<CategoryDto> categories = new ArrayList<>();
        String query = "SELECT id, description, status FROM category";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
                int status = resultSet.getInt("status");
                categories.add(new CategoryDto(id, description, status));
            }
        }
        return categories;
    }

    public CategoryDto getCategoryById(int id) throws SQLException {
        CategoryDto category = null;
        String query = "SELECT id, description, status FROM category WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String description = resultSet.getString("description");
                    int status = resultSet.getInt("status");
                    category = new CategoryDto(id, description, status);
                }
            }
        }
        return category;
    }

    public void addCategory(CategoryDto category) throws SQLException {
        String query = "INSERT INTO category (description, status) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getDescription());
            statement.setInt(2, category.getStatus());
            statement.executeUpdate();
        }
    }

    public void updateCategory(CategoryDto category) throws SQLException {
        String query = "UPDATE category SET description = ?, status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, category.getDescription());
            statement.setInt(2, category.getStatus());
            statement.setInt(3, category.getId());
            statement.executeUpdate();
        }
    }

    public void changeCategoryStatus(int id, int status) throws SQLException {
        String query = "UPDATE category SET status = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, status);
            statement.setInt(2, id);
            statement.executeUpdate();
        }
    }
}
