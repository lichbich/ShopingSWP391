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
            String query = "WITH ProductImage AS (\n" +
                    "SELECT  p.product_id,   p.product_name,  p.description,  MIN(pd.price) AS minPrice,   MAX(pd.price) AS maxPrice, \n" +
                    "i.image_url, pd.color_code,\n" +
                    "ROW_NUMBER() OVER (PARTITION BY p.product_id ORDER BY i.image_url) AS row_num\n" +
                    "FROM  product p\n" +
                    "JOIN   product_detail pd ON p.product_id = pd.product_id\n" +
                    "JOIN  image i ON p.product_id = i.product_id\n" +
                    "GROUP BY  p.product_id, p.product_name, p.description, i.image_url, pd.color_code)\n" +
                    "SELECT * FROM ProductImage \n" +
                    "WHERE row_num = 1;";
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
                product.setColor_code(rs.getInt("color_code"));
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
        String query = "SELECT p.product_id, pd.product_detail_id, p.product_name, p.description, pd.price, pd.size, i.image_url, pd.color_code, pd.quantity \n" +
                "FROM product p \n" +
                "JOIN product_detail pd ON p.product_id = pd.product_id \n" +
                "JOIN image i ON p.product_id = i.product_id";
        try (Connection conn = DbContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                ProductDetail productDetail = new ProductDetail();
                productDetail.setProduct_id(rs.getInt("product_id"));
                productDetail.setProduct_detail_id(rs.getInt("product_detail_id"));
                productDetail.setProduct_name(rs.getString("product_name"));
                productDetail.setDescription(rs.getString("description"));
                productDetail.setPrice(rs.getDouble("price"));
                productDetail.setSize(rs.getFloat("size"));
                productDetail.setImageUrl(rs.getString("image_url"));
                productDetail.setColor_code(rs.getInt("color_code"));
                productDetail.setQuantity(rs.getInt("quantity"));
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
            String query = "\tWITH LatestProduct AS ( SELECT p.product_id, \n" +
                    "\tp.product_name, \n" +
                    "\tp.description, \n" +
                    "\tMIN(pd.price) AS minPrice, \n" +
                    "\tMAX(pd.price) AS maxPrice, \n" +
                    "\ti.image_url, pd.color_code,\n" +
                    "\tROW_NUMBER() OVER (PARTITION BY p.product_id ORDER BY p.product_id DESC) AS row_num\n" +
                    "\tFROM  product p\n" +
                    "\tJOIN \n" +
                    "\tproduct_detail pd ON p.product_id = pd.product_id\n" +
                    "\tJOIN  image i ON p.product_id = i.product_id\n" +
                    "\tGROUP BY  p.product_id, p.product_name, p.description, i.image_url, pd.color_code)\n" +
                    "\tSELECT TOP 3 product_id, product_name, description, minPrice, maxPrice, image_url, color_code\n" +
                    "\tFROM   LatestProduct\n" +
                    "\tWHERE   row_num = 1\n" +
                    "\tORDER BY  product_id DESC;";
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
                product.setColor_code(rs.getInt("color_code"));
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
            String query = "WITH ProductImage AS (\n" +
                    "    SELECT \n" +
                    "        p.product_id, \n" +
                    "        p.product_name, \n" +
                    "        p.description, \n" +
                    "        MIN(pd.price) AS minPrice, \n" +
                    "        MAX(pd.price) AS maxPrice, \n" +
                    "        i.image_url,\n" +
                    "        ROW_NUMBER() OVER (PARTITION BY p.product_id ORDER BY i.image_url) AS row_num\n" +
                    "    FROM \n" +
                    "        product p\n" +
                    "    JOIN \n" +
                    "        product_detail pd ON p.product_id = pd.product_id\n" +
                    "    JOIN \n" +
                    "        image i ON p.product_id = i.product_id\n" +
                    "    WHERE\n" +
                    "        p.category_id = ? \n" +
                    "    GROUP BY \n" +
                    "        p.product_id, p.product_name, p.description, i.image_url\n" +
                    ")\n" +
                    "SELECT * \n" +
                    "FROM ProductImage \n" +
                    "WHERE row_num = 1;\n";
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

    public void editProduct(int productId, String productName, String description, int CategoryID) {
        Product product = getProductById(productId);
        if(Objects.nonNull(product)) {
            String query = "UPDATE product SET product_name = ?, description = ?, category_id = ? WHERE product_id = ?";
            try {
                conn = DbContext.getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, StringUtils.isEmpty(productName)?product.getProduct_name():productName);
                ps.setString(2, StringUtils.isEmpty(description)?product.getDescription():description);
                ps.setInt(3, CategoryID);
                ps.setInt(4, productId);
                ps.executeUpdate();
                conn.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteProductById(int productDetailId) {

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
                product.setCategory_id(rs.getInt("category_id"));
//                product.setMinPrice(rs.getDouble("minPrice"));
//                product.setMaxPrice(rs.getDouble("maxPrice"));
//                product.setImageUrl(rs.getString("image_url"));
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
