package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.ProductDetail;
import com.vn.fpt.g1.shop.entity.Color;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailDAO {
    public ProductDetail getProductDetailByIdAndColorCode(int product_id, int color_code) {
        ProductDetail productDetail = null;
        try (Connection conn = DbContext.getConnection()) {
            String query = "SELECT p.product_name, p.description, pd.price, pd.color, pd.size, pd.quantity, pd.product_detail_id " +
                    "FROM product p " +
                    "JOIN product_detail pd ON p.product_id = pd.product_id " +
                    "JOIN color c ON pd.color_code = c.color_code " +
                    "WHERE p.product_id = ? AND c.color_code = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, product_id);
                ps.setInt(2, color_code);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        productDetail = new ProductDetail();
                        productDetail.setProduct_name(rs.getString("product_name"));
                        productDetail.setDescription(rs.getString("description"));
                        productDetail.setPrice(rs.getDouble("price"));
                        productDetail.setColor_code(rs.getInt("color_code"));
                        productDetail.setSize(rs.getString("size"));
                        productDetail.setQuantity(rs.getInt("quantity"));
                        productDetail.setProduct_detail_id(rs.getInt("product_detail_id"));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDetail;
    }

    public List<Color> getColorsByProductId(int productId) {
        List<Color> colors = new ArrayList<>();
        try (Connection conn = DbContext.getConnection()) {
            String query = "SELECT c.color_id, c.color_name, c.color_code " +
                    "FROM color c " +
                    "JOIN product_detail pd ON c.color_code = pd.color_code " +
                    "WHERE pd.product_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, productId);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Color color = new Color();
                        color.setColor_id(rs.getInt("color_id"));
                        color.setColor_name(rs.getString("color_name"));
                        color.setColor_code(rs.getInt("color_code"));
                        colors.add(color);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return colors;
    }
}