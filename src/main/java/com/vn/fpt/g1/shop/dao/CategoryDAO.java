package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.dto.CategoryDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {

    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categories = new ArrayList<>();
        String sql = "SELECT id, description, status, createDate, updateDate FROM category";

        try (Connection connection = DbContext.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                CategoryDto category = new CategoryDto();
                category.setId(resultSet.getInt("id"));
                category.setDescription(resultSet.getString("description"));
                category.setStatus(resultSet.getInt("status"));
                category.setCreateDate(resultSet.getTimestamp("createDate"));
                category.setUpdateDate(resultSet.getTimestamp("updateDate"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
