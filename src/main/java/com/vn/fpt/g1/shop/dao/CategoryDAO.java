package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM Category";
        try (Connection connection = DbContext.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                categories.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
