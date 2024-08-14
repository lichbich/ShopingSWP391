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

    private static final String INSERT_CATEGORY_SQL = "INSERT INTO category (description, status) VALUES (?, ?)";
    private static final String SELECT_ALL_CATEGORIES = "SELECT * FROM category";
    private static final String UPDATE_CATEGORY_SQL = "UPDATE category SET description = ?, status = ? WHERE category_id = ?";
    private static final String UPDATE_CATEGORY_STATUS_SQL = "UPDATE category SET status = ? WHERE category_id = ?";

    // Add a new category
    public void addCategory(CategoryDto categoryDto) {
        try (Connection connection = DbContext.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY_SQL)) {
            preparedStatement.setString(1, categoryDto.getDescription());
            preparedStatement.setInt(2, categoryDto.getStatus());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all categories
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DbContext.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORIES)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("category_id");
                String description = resultSet.getString("description");
                int status = resultSet.getInt("status");
                java.sql.Timestamp createDate = resultSet.getTimestamp("create_date");
                java.sql.Timestamp updateDate = resultSet.getTimestamp("update_date");
                categories.add(new Category(id, description, status, createDate, updateDate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    // Get a category by ID
    public Category getCategoryById(int id) {
        Category category = null;
        String query = "SELECT * FROM category WHERE category_id = ?";
        try (Connection connection = DbContext.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String description = resultSet.getString("description");
                int status = resultSet.getInt("status");
                java.sql.Timestamp createDate = resultSet.getTimestamp("create_date");
                java.sql.Timestamp updateDate = resultSet.getTimestamp("update_date");
                category = new Category(id, description, status, createDate, updateDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    // Update a category
    public void updateCategory(CategoryDto categoryDto) {
        try (Connection connection = DbContext.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY_SQL)) {
            preparedStatement.setString(1, categoryDto.getDescription());
            preparedStatement.setInt(2, categoryDto.getStatus());
            preparedStatement.setInt(3, categoryDto.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Change category status
    public void changeStatus(int categoryId, int status) {
        try (Connection connection = DbContext.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY_STATUS_SQL)) {
            preparedStatement.setInt(1, status);
            preparedStatement.setInt(2, categoryId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
