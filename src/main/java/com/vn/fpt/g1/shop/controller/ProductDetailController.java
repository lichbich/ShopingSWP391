// src/main/java/com/vn/fpt/g1/shop/service/ProductService.java
package com.vn.fpt.g1.shop.controller;

//import com.vn.fpt.g1.shop.entity.Product;
//import com.vn.fpt.g1.shop.entity.Color;
//import com.vn.fpt.g1.shop.db.DbContext;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;

public class ProductDetailController {
//    public Product getProductByIdAndColorCode(String productId, String colorCode) {
//        Product product = null;
//        try (Connection conn = DbContext.getConnection()) {
//            String query = "SELECT p.product_id, p.product_name, p.description, p.minPrice, p.maxPrice, pd.image_url, c.color_code " +
//                    "FROM product p " +
//                    "JOIN product_detail pd ON p.product_id = pd.product_id " +
//                    "JOIN color c ON pd.color_id = c.color_id " +
//                    "WHERE p.product_id = ? AND c.color_code = ?";
//            try (PreparedStatement ps = conn.prepareStatement(query)) {
//                ps.setString(1, productId);
//                ps.setString(2, colorCode);
//                try (ResultSet rs = ps.executeQuery()) {
//                    if (rs.next()) {
//                        product = new Product();
//                        product.setProduct_id(rs.getInt("product_id"));
//                        product.setProduct_name(rs.getString("product_name"));
//                        product.setDescription(rs.getString("description"));
//                        product.setMinPrice(rs.getDouble("minPrice"));
//                        product.setMaxPrice(rs.getDouble("maxPrice"));
//                        product.setImageUrl(rs.getString("image_url"));
//                        product.setColorCode(rs.getString("color_code"));
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return product;
//    }

//    public List<Color> getColorsByProductId(String productId) {
//        List<Color> colors = new ArrayList<>();
//        try (Connection conn = DbContext.getConnection()) {
//            String query = "SELECT c.color_id, c.color_name, c.color_code " +
//                    "FROM color c " +
//                    "JOIN product_detail pd ON c.color_id = pd.color_id " +
//                    "WHERE pd.product_id = ?";
//            try (PreparedStatement ps = conn.prepareStatement(query)) {
//                ps.setString(1, productId);
//                try (ResultSet rs = ps.executeQuery()) {
//                    while (rs.next()) {
//                        Color color = new Color();
//                        color.setColor_id(rs.getInt("color_id"));
//                        color.setColor_name(rs.getString("color_name"));
//                        color.setColor_code(rs.getString("color_code"));
//                        colors.add(color);
//                    }
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return colors;
//    }
}