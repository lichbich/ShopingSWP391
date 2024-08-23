package com.vn.fpt.g1.shop.dao;

import com.cloudinary.utils.StringUtils;
import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.Category;
import com.vn.fpt.g1.shop.entity.Product;
import com.vn.fpt.g1.shop.entity.ProductDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDAO {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String query = "SELECT p.product_id, p.product_name, p.description, MIN(pd.price) AS minPrice, MAX(pd.price) AS maxPrice, i.image_url " +
                    "FROM product p " +
                    "JOIN product_detail pd ON p.product_id = pd.product_id " +
                    "JOIN image i ON p.product_id = i.product_id " +
                    "GROUP BY p.product_id, p.product_name, p.description, i.image_url";
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setMinPrice(rs.getDouble("minPrice"));
                product.setMaxPrice(rs.getDouble("maxPrice"));
                product.setImageUrl(rs.getString("image_url"));
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

    public List<ProductDetail> getAllProductDetail() {
        List<ProductDetail> productDetails = new ArrayList<>();
        String query = "SELECT p.product_id, p.product_name, p.description, pd.price, pd.size, i.image_url, pd.color_code " +
                "FROM product p " +
                "JOIN product_detail pd ON p.product_id = pd.product_id " +
                "JOIN image i ON p.product_id = i.product_id";
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ProductDetail productDetail = new ProductDetail();
                productDetail.setProduct_id(rs.getInt("product_id"));
                productDetail.setProduct_name(rs.getString("product_name"));
                productDetail.setDescription(rs.getString("description"));
                productDetail.setPrice(rs.getDouble("price"));
                productDetail.setSize(rs.getFloat("size"));
                productDetail.setImageUrl(rs.getString("image_url"));
                productDetail.setColor_code(rs.getInt("color_code"));
                productDetails.add(productDetail);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productDetails;
    }

    public List<Product> searchProducts(String query) {
        List<Product> products = new ArrayList<>();
        try {
            String sql = "SELECT p.product_id, p.product_name, p.description, MIN(pd.price) AS minPrice, MAX(pd.price) AS maxPrice, i.image_url " +
                    "FROM product p " +
                    "JOIN product_detail pd ON p.product_id = pd.product_id " +
                    "JOIN image i ON p.product_id = i.product_id " +
                    "WHERE p.product_name LIKE ? " +
                    "GROUP BY p.product_id, p.product_name, p.description, i.image_url";
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + query + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setMinPrice(rs.getDouble("minPrice"));
                product.setMaxPrice(rs.getDouble("maxPrice"));
                product.setImageUrl(rs.getString("image_url"));
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

    public List<Product> getLatestProducts() {
        List<Product> products = new ArrayList<>();
        try {
            String query = "SELECT TOP 3 p.product_id, p.product_name, p.description, MIN(pd.price) AS minPrice, MAX(pd.price) AS maxPrice, i.image_url " +
                    "FROM product p " +
                    "JOIN product_detail pd ON p.product_id = pd.product_id " +
                    "JOIN image i ON p.product_id = i.product_id " +
                    "GROUP BY p.product_id, p.product_name, p.description, i.image_url " +
                    "ORDER BY p.product_id DESC";
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setMinPrice(rs.getDouble("minPrice"));
                product.setMaxPrice(rs.getDouble("maxPrice"));
                product.setImageUrl(rs.getString("image_url"));
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

    public static List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String query = "SELECT * FROM Category";
        try (Connection connection = DbContext.getConnection();
             PreparedStatement ps = connection.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                categories.add(new Category(
                        rs.getInt("category_id"),
                        rs.getString("name")
                        )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }

    public List<Product> getProductsByCategory( String categoryId) {
        List<Product> products = new ArrayList<>();
        try {
            String query = "\tSELECT \n" +
                    "    p.product_id, \n" +
                    "    p.product_name, \n" +
                    "    p.description, \n" +
                    "    MIN(pd.price) AS minPrice, \n" +
                    "    MAX(pd.price) AS maxPrice, \n" +
                    "    i.image_url\n" +
                    "FROM \n" +
                    "    product p\n" +
                    "JOIN \n" +
                    "    product_detail pd ON p.product_id = pd.product_id\n" +
                    "JOIN \n" +
                    "    image i ON p.product_id = i.product_id\n" +
                    "WHERE \n" +
                    "    p.category_id = ?\n" +
                    "GROUP BY \n" +
                    "    p.product_id, \n" +
                    "    p.product_name, \n" +
                    "    p.description, \n" +
                    "    i.image_url;\n";
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, categoryId);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setMinPrice(rs.getDouble("minPrice"));
                product.setMaxPrice(rs.getDouble("maxPrice"));
                product.setImageUrl(rs.getString("image_url"));
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
    public void addProduct(String productName, String description, int CategoryID) {

        String query = "INSERT INTO [dbo].[product]\n" +
                "           ([product_name],[description], [category_id])\n" +
                "     VALUES\n" +
                "           (?,? ,?)\n";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productName);
            ps.setString(2, description);
            ps.setInt(3, CategoryID);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void editProduct(int productId, String productName, String description, double minPrice, double maxPrice, String imageUrl) {
        Product product = getProductById(productId);
        if(Objects.nonNull(product)) {
            String query = "INSERT INTO [dbo].[product]\n" +
                    "           ([product_name],[description],[minPrice],[maxPrice],[imageUrl])\n" +
                    "     VALUES\n" +
                    "           (?,? ,?, ?, ?)\n";
            try {
                conn = DbContext.getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, StringUtils.isEmpty(productName)?product.getProduct_name():productName);
                ps.setString(2, StringUtils.isEmpty(description)?product.getDescription():description);
                ps.setDouble(3, Objects.nonNull(minPrice)?minPrice:product.getMinPrice());
                ps.setDouble(4, Objects.nonNull(maxPrice)?maxPrice:product.getMaxPrice());
                ps.setString(5, StringUtils.isEmpty(imageUrl)?product.getImageUrl():imageUrl);
                ps.executeUpdate();
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteProductById(int productId) {

        String query = "delete from [product] where product_id = ?";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
        }
    }

    public Product getProductById(int productId) {
        String query = "select * from [product] where product_id = ?";
        try{
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            Product product = null;
            while (rs.next()) {
                product = new Product();
                product.setProduct_id(rs.getInt("product_id"));
                product.setProduct_name(rs.getString("product_name"));
                product.setDescription(rs.getString("description"));
                product.setMinPrice(rs.getDouble("minPrice"));
                product.setMaxPrice(rs.getDouble("maxPrice"));
                product.setImageUrl(rs.getString("image_url"));
            }
        return product;

    } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


//    public static void main(String[] args) {
//        ProductDAO productDAO = new ProductDAO();
//        List<Product> productList = productDAO.getAllProducts();
//        for (Product product : productList) {
//            System.out.println(product);
//        }
//    }
}
