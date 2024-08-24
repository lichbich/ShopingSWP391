package com.vn.fpt.g1.shop.dao;

import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.ProductDetail;
import com.vn.fpt.g1.shop.entity.Color;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDetailDAO {
    private static final Logger log = LogManager.getLogger(ProductDetailDAO.class);
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<ProductDetail> getProductDetailById(int product_id) {
        List<ProductDetail> productDetails = new ArrayList<>();
        try (Connection conn = DbContext.getConnection()) {
            String query = "SELECT \n" +
                    "    p.product_name, \n" +
                    "    p.description, \n" +
                    "    pd.price, \n" +
                    "    pd.color_code, \n" +
                    "    pd.size, \n" +
                    "    pd.quantity, \n" +
                    "    pd.product_detail_id, \n" +
                    "    i.image_url\n" +
                    "FROM \n" +
                    "    product p\n" +
                    "LEFT JOIN \n" +
                    "    product_detail pd ON p.product_id = pd.product_id\n" +
                    "LEFT JOIN \n" +
                    "    color c ON pd.color_code = c.color_id\n" +
                    "LEFT JOIN \n" +
                    "    image i ON pd.product_detail_id = i.product_id AND c.color_id = i.color_id\n" +
                    "WHERE \n" +
                    "    p.product_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, product_id);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        ProductDetail productDetail = new ProductDetail();
//                        productDetail = new ProductDetail();
                        productDetail.setProduct_name(rs.getString("product_name"));
                        productDetail.setDescription(rs.getString("description"));
                        productDetail.setPrice(rs.getDouble("price"));
                        productDetail.setColor_code(rs.getInt("color_code"));
                        productDetail.setSize(rs.getFloat("size"));
                        productDetail.setQuantity(rs.getInt("quantity"));
                        productDetail.setProduct_detail_id(rs.getInt("product_detail_id"));
                        productDetail.setImageUrl(rs.getString("image_url"));
                        productDetails.add(productDetail);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDetails;
    }

    public ProductDetail getProductDetailByIdAndColorCode(int product_id, int color_code) {
        ProductDetail productDetail = null;
        try (Connection conn = DbContext.getConnection()) {
            String query = "SELECT \n" +
                    "    p.product_name, \n" +
                    "    p.description, \n" +
                    "    pd.price, \n" +
                    "    pd.color_code, \n" +
                    "    pd.size, \n" +
                    "    pd.quantity, \n" +
                    "    pd.product_detail_id, \n" +
                    "    i.image_url\n" +
                    "FROM \n" +
                    "    product p\n" +
                    "LEFT JOIN \n" +
                    "    product_detail pd ON p.product_id = pd.product_id\n" +
                    "LEFT JOIN \n" +
                    "    color c ON pd.color_code = c.color_id\n" +
                    "LEFT JOIN \n" +
                    "    image i ON pd.product_detail_id = i.product_id AND c.color_id = i.color_id\n" +
                    "WHERE \n" +
                    "    p.product_id = ? \n" +
                    "    AND c.color_id = ?;\n";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, product_id);
                ps.setInt(2, color_code);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        productDetail = new ProductDetail();
//                        productDetail.setProduct_name(rs.getString("product_name"));
//                        productDetail.setDescription(rs.getString("description"));
                        productDetail.setPrice(rs.getDouble("price"));
                        productDetail.setColor_code(rs.getInt("color_code"));
                        productDetail.setSize(rs.getFloat("size"));
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
            String query = "SELECT c.color_id, c.color_name, c.color_code \n" +
                    "FROM color c \n" +
                    "JOIN product_detail pd ON c.color_id = pd.color_code \n" +
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

//    private String getColorCode(List<Color> colors) {
//        if (colors == null || colors.isEmpty()) {
//            return null;
//        }
//        return colors.get(0).getColorCode();
//    }

    public void addProductDetail(ProductDetail productDetail) {
        String queryLatestProductId = "SELECT MAX(product_id) AS latest_product_id FROM [dbo].[product]";
        String queryProductDetail = "INSERT INTO [dbo].[product_detail] " +
                "([product_id], [color_code], [size], [quantity], [price]) " +
                "VALUES (?, ?, ?, ?, ?)";
        String queryImage = "INSERT INTO [dbo].[image] " +
                "([product_id], [color_id], [image_url]) " +
                "VALUES (?, ?, ?)";
        try {
            conn = DbContext.getConnection();
            conn.setAutoCommit(false); // Start transaction

            // Get the latest product_id
            ps = conn.prepareStatement(queryLatestProductId);
            rs = ps.executeQuery();
            int latestProductId = 0;
            if (rs.next()) {
                latestProductId = rs.getInt("latest_product_id");
            }

            // Insert into product_detail
            ps = conn.prepareStatement(queryProductDetail, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, latestProductId);
            ps.setInt(2, productDetail.getColor_code());
            ps.setFloat(3, productDetail.getSize());
            ps.setInt(4, productDetail.getQuantity());
            ps.setDouble(5, productDetail.getPrice());
            ps.executeUpdate();
            conn.commit();

            // Get generated product_detail_id
            ResultSet generatedKeys = ps.getGeneratedKeys();
            if (generatedKeys.next()) {
                int productDetailId = generatedKeys.getInt(1);

                // Insert into image
                ps = conn.prepareStatement(queryImage);
                ps.setInt(1, latestProductId);
                ps.setInt(2, productDetail.getColor_code()); // Ensure color_code matches color_id
                ps.setString(3, productDetail.getImageUrl());
                ps.executeUpdate();
            }

            conn.commit(); // Commit transaction
            conn.close();
        } catch (Exception e) {
            log.error(e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback(); // Rollback transaction on error
                }
            } catch (Exception rollbackEx) {
                log.error(rollbackEx.getMessage());
            }
        }
    }

    public void editProductDetail(String productName, String description, double minPrice, double maxPrice, String imageUrl) {

        String query = "INSERT INTO [dbo].[product]\n" +
                "           ([product_id],[product_name],[description],[minPrice],[maxPrice],[imageUrl])\n" +
                "     VALUES\n" +
                "           (?,?,? ,?, ?, ?)\n";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productName);
            ps.setString(2, description);
            ps.setDouble(3, minPrice);
            ps.setDouble(4, maxPrice);
            ps.setString(5, imageUrl);
            ps.executeUpdate();
            conn.close();
        }catch (Exception e) {
        }
    }

    public void deleteProductDetailById(int productDetailId) {

        String query = "delete from [product_detail] where product_detail_id = ?";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productDetailId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void deleteAllProductDetailByProductId(int productId) {
        String query = "delete from [product_detail] where product_id = ?";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
        }
    }
}