package com.vn.fpt.g1.shop.dao;


import com.vn.fpt.g1.shop.dto.ProductDto;
import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.Product;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private Connection connection;

    // Constructor nhận Connection
    public ProductDAO(Connection connection) {
        this.connection = connection;
    }
    // Method để thêm sản phẩm
    public void addProduct(ProductDto product) throws SQLException {
        String sql = "INSERT INTO product (name, description, price, categoryId, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getCategoryId());
            pstmt.setInt(5, product.getStatus());
            pstmt.executeUpdate();
        }
    }

    // Method để cập nhật sản phẩm
    public void updateProduct(ProductDto product) throws SQLException {
        String sql = "UPDATE product SET name = ?, description = ?, price = ?, categoryId = ?, status = ? WHERE productId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, product.getName());
            pstmt.setString(2, product.getDescription());
            pstmt.setDouble(3, product.getPrice());
            pstmt.setInt(4, product.getCategoryId());
            pstmt.setInt(5, product.getStatus());
            pstmt.setInt(6, product.getProductId());
            pstmt.executeUpdate();
        }
    }

    // Method để lấy tất cả sản phẩm
    public List<ProductDto> getAllProducts() throws SQLException {
        List<ProductDto> products = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ProductDto product = new ProductDto(
                        rs.getInt("productId"),
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getInt("categoryId"),
                        rs.getInt("status"),
                        rs.getTimestamp("createDate"),
                        rs.getTimestamp("updateDate")
                );
                products.add(product);
            }
        }
        return products;
    }

    // Method để lấy sản phẩm theo ID
    public ProductDto getProductById(int productId) throws SQLException {
        ProductDto product = null;
        String sql = "SELECT * FROM product WHERE productId = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, productId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    product = new ProductDto(
                            rs.getInt("productId"),
                            rs.getString("name"),
                            rs.getString("description"),
                            rs.getDouble("price"),
                            rs.getInt("categoryId"),
                            rs.getInt("status"),
                            rs.getTimestamp("createDate"),
                            rs.getTimestamp("updateDate")
                    );
                }
            }
        }
        return product;

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String query = "SELECT * FROM product";
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                products.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return products;
    }

    }
}
