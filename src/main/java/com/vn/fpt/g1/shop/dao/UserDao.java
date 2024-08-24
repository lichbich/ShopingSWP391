package com.vn.fpt.g1.shop.dao;

import com.oracle.wls.shaded.org.apache.xpath.operations.Or;
import com.vn.fpt.g1.shop.dbcontext.DbContext;
import com.vn.fpt.g1.shop.entity.Cart;
import com.vn.fpt.g1.shop.entity.Order;
import com.vn.fpt.g1.shop.entity.OrderDetail;
import com.vn.fpt.g1.shop.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDao extends DbContext {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Cart> getCartByEmail(String email) {
        List<Cart> list = new ArrayList<>();
        String query = "SELECT \n" +
                "    c.cart_id,\n" +
                "    u.[user_id],\n" +
                "    u.email,\n" +
                "    pd.product_detail_id, \n" +
                "    p.product_id,\n" +
                "    p.product_name,    \n" +
                "    pd.size,\n" +
                "    col.color_id,\n" +
                "    col.color_name,\n" +
                "    pd.price,\n" +
                "    c.quantity,\n" +
                "    i.image_url\n" +
                "FROM \n" +
                "    cart AS c\n" +
                "JOIN \n" +
                "    product_detail AS pd ON c.product_detail_id = pd.product_detail_id\n" +
                "JOIN\n" +
                "    product AS p ON pd.product_id = p.product_id\n" +
                "JOIN\n" +
                "    color AS col ON pd.color_code = col.color_id\n" +
                "JOIN\n" +
                "    [image] AS i ON p.product_id = i.product_id AND pd.color_code = i.color_id\n" +
                "JOIN\n" +
                "    [users] AS u ON c.[user_id] = u.[user_id]\n" +
                "WHERE \n" +
                "    u.email = ?;";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Cart(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getInt(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getInt(11),
                        rs.getString(12)));
            }
            conn.close();
        } catch (Exception e) {

        }

        return list;
    }

    public User checkAccountExist(String email) {
        String query = "select [user_id],[first_name], [last_name], [email], [password] from [users]\n" +
                "where [email] = ?\n";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5));
            }
            conn.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        return null;

    }

    public void register(String firstname, String lastname, String address, Date dob, String phonenumber, String email, String password, String gender, Timestamp createtime, Timestamp updatetime) {


        String query = "INSERT INTO [dbo].[users]\n" +
                "           ([first_name],[last_name],[address],[dob],[phone],[email],[is_active],[role_id],[password],[gender],[create_date],[update_date])\n" +
                "     VALUES\n" +
                "           (?,?,?,?,?,?,1,4,? ,?, ?, ?)\n";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, firstname);
            ps.setString(2, lastname);
            ps.setString(3, address);
            ps.setDate(4, dob);
            ps.setString(5, phonenumber);
            ps.setString(6, email);
            ps.setString(7, password);
            ps.setString(8, gender);
            ps.setTimestamp(9, createtime);
            ps.setTimestamp(10, updatetime);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
        }
    }

    public void deleteCart(int cid) {
        String query = "DELETE FROM [dbo].[cart]\n" +
                "      WHERE cart_id = ?";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, cid);
            ps.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void updateQuantity(int cid, int quantity) {
        if (quantity <= 0) {
            deleteCart(cid);

        } else {
            String query = "UPDATE cart \n" +
                    "SET quantity = ? \n" +
                    "WHERE cart_id = ?";

            try {
                conn = DbContext.getConnection();
                ps = conn.prepareStatement(query);
                ps.setInt(1, quantity);
                ps.setInt(2, cid);
                ps.executeUpdate();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    }

    public User getCustomerByEmail(String email) {
        User user = null;
        String query = "SELECT [user_id],[first_name],[last_name],[address],[phone],[email]\n" +
                "  FROM [dbo].[users]\n" +
                "  where email = ?";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
            conn.close();
        } catch (Exception e) {
        }
        return user;
    }

    public int getQuantityOfProductDetail(String productName, String colorName, String size) {
        int quantity = 0;
        String query = "SELECT pd.quantity\n" +
                "FROM product_detail pd\n" +
                "JOIN product p ON pd.product_id = p.product_id\n" +
                "JOIN color c ON pd.color_code = c.color_id\n" +
                "WHERE p.product_name = ? AND c.color_name = ? AND pd.size = ?";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, productName);
            ps.setString(2, colorName);
            ps.setString(3, size);
            rs = ps.executeQuery();

            if (rs.next()) {
                quantity = rs.getInt(1);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return quantity;
    }

    public void order(int user_id, Timestamp orderDate, String price, String shippingAddress, String receiverName, String receiverPhone) {
        String query = "INSERT INTO [dbo].[order]\n" +
                "           ([user_id],[status],[order_date],[total_price],[shipping_address],[receiver_name],[receiver_phone])\n" +
                "     VALUES\n" +
                "           (\n" +
                "           ?,'Shop Processing',?,?,?,?,?)";

        try {

            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, user_id);
            ps.setTimestamp(2, orderDate);
            ps.setString(3, price);
            ps.setString(4, shippingAddress);
            ps.setString(5, receiverName);
            ps.setString(6, receiverPhone);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {

        }
    }

    public int getOrderId() {
        int orderId = 0;
        String query = "SELECT TOP 1 [order_id]\n" +
                "FROM [order]\n" +
                "ORDER BY order_id DESC;";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            if (rs.next()) {
                orderId = rs.getInt(1);
            }
            conn.close();

        } catch (Exception e) {

        }
        return orderId;
    }

    public void insertOrderDetailByOrderId(List<Cart> cartList, int orderId) {
        String query = "INSERT INTO [dbo].[order_detail]\n" +
                "           ([order_id],[product_detail_id],[quantity],[price])\n" +
                "     VALUES\n" +
                "           (?, ?, ?, ?)";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            for (Cart item : cartList) {
                ps.setInt(1, orderId);
                ps.setInt(2, item.getProduct_detail_id());
                ps.setInt(3, item.getQuantity());
                ps.setString(4, item.getPrice());
                ps.executeUpdate();

            }
            conn.close();

        } catch (Exception e) {

        }
    }

    public List<Order> customerListOrder(String email, String status) {
        List<Order> orders = new ArrayList<>();
        String query = "\n" +
                "WITH OrderWithProductCount AS (\n" +
                "    SELECT \n" +
                "        o.[order_id],o.[user_id], u.email AS user_email,o.[status],p.product_name, o.order_date, o.total_price, o.receiver_name,o.receiver_phone,o.shipping_address, COUNT(od.product_detail_id) OVER (PARTITION BY o.order_id) AS total_products,\n" +
                "        ROW_NUMBER() OVER (PARTITION BY o.order_id ORDER BY od.product_detail_id) AS row_num\n" +
                "    FROM \n" +
                "        [order] o\n" +
                "    JOIN \n" +
                "        [users] u ON o.[user_id] = u.[user_id]\n" +
                "    JOIN \n" +
                "        [order_detail] od ON o.order_id = od.order_id\n" +
                "    JOIN \n" +
                "        [product_detail] pd ON od.product_detail_id = pd.product_detail_id\n" +
                "    JOIN \n" +
                "        [product] p ON pd.product_id = p.product_id\n" +
                "    WHERE \n" +
                "        u.email = ? \n" +
                "        AND o.status = ?\n" +
                ")\n" +
                "SELECT \n" +
                "    [order_id],[user_id],user_email,[status], CONCAT(product_name, ' + ', (total_products - 1)) AS product_name,order_date,total_price,receiver_name,receiver_phone,shipping_address\n" +
                "FROM \n" +
                "    OrderWithProductCount\n" +
                "WHERE \n" +
                "    row_num = 1\n" +
                "ORDER BY \n" +
                "    order_date DESC;\n";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getTimestamp(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
            conn.close();

        } catch (Exception e) {

        }
        return orders;
    }

    public List<Order> getOrderbyStatus(String status) {
        List<Order> orders = new ArrayList<>();
        String query = "WITH OrderWithProductCount AS (\n" +
                "    SELECT \n" +
                "        o.order_id,o.[user_id],u.first_name, u.last_name, u.email AS user_email,o.[status],p.product_name, o.order_date, o.total_price, o.receiver_name,o.receiver_phone,o.shipping_address, COUNT(od.product_detail_id) OVER (PARTITION BY o.order_id) AS total_products,\n" +
                "        ROW_NUMBER() OVER (PARTITION BY o.order_id ORDER BY od.product_detail_id) AS row_num\n" +
                "    FROM \n" +
                "        [order] o\n" +
                "    JOIN \n" +
                "        [users] u ON o.[user_id] = u.[user_id]\n" +
                "    JOIN \n" +
                "        [order_detail] od ON o.order_id = od.order_id\n" +
                "    JOIN \n" +
                "        [product_detail] pd ON od.product_detail_id = pd.product_detail_id\n" +
                "    JOIN \n" +
                "        [product] p ON pd.product_id = p.product_id\n" +
                "    WHERE \n" +
                "        o.[status] = ?\n" +
                ")\n" +
                "SELECT \n" +
                "    [order_id],[user_id],first_name, last_name, user_email,[status], CONCAT(product_name, ' + ', (total_products - 1)) AS product_name,order_date,total_price,receiver_name,receiver_phone,shipping_address\n" +
                "FROM \n" +
                "    OrderWithProductCount\n" +
                "WHERE \n" +
                "    row_num = 1\n" +
                "ORDER BY \n" +
                "    order_date DESC;";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                orders.add(new Order(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getTimestamp(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11),
                        rs.getString(12)));
            }
            conn.close();

        } catch (Exception e) {

        }
        return orders;
    }

    public Order getOrderById(int order_id) {
        Order order = null;
        String query = "SELECT \n" +
                "o.order_id, u.email, o.[status], o.order_date, o.total_price, o.receiver_name, o.receiver_phone, o.shipping_address \n" +
                "FROM \n" +
                "    [order] o\n" +
                "JOIN \n" +
                "    [users] u ON o.[user_id] = u.[user_id]\n" +
                "WHERE \n" +
                "    o.order_id = ?";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, order_id);
            rs = ps.executeQuery();
            if (rs.next()) {
                order = new Order(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getTimestamp(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            conn.close();
        } catch (Exception e) {
        }
        return order;
    }

    public List<OrderDetail> getOrderDetailById(int order_id) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        String query = "SELECT\n" +
                "    od.order_detail_id, od.order_id, pd.product_detail_id, p.product_name, c.color_name,  pd.size, od.quantity, od.price, img.image_url\n" +
                "FROM \n" +
                "    order_detail od\n" +
                "JOIN \n" +
                "    product_detail pd ON od.product_detail_id = pd.product_detail_id\n" +
                "JOIN \n" +
                "    product p ON pd.product_id = p.product_id\n" +
                "JOIN \n" +
                "    color c ON pd.color_code = c.color_id\n" +
                "JOIN \n" +
                "    image img ON pd.product_id = img.product_id AND pd.color_code = img.color_id\n" +
                "WHERE \n" +
                "    od.order_id = ?";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, order_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                orderDetails.add(new OrderDetail(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getString(9)));
            }
            conn.close();
        } catch (Exception e) {

        }


        return orderDetails;
    }

    public void rebuyProduct(String email, int productDetailId) {
        String checkExistQuery = "SELECT c.quantity FROM cart c \n" +
                "\tJOIN users u ON c.[user_id] = u.[user_id]\n" +
                "    WHERE u.email = ? AND c.product_detail_id = ?";
        try {

            conn = DbContext.getConnection();
            ps = conn.prepareStatement(checkExistQuery);
            ps.setString(1, email);
            ps.setInt(2, productDetailId);
            rs = ps.executeQuery();
            if (rs.next()) {
                // Nếu sản phẩm đã tồn tại trong giỏ hàng, cập nhật số lượng
                int currentQuantity = rs.getInt("quantity");
                String updateQuery = "UPDATE cart SET quantity = ? \n" +
                        "\tWHERE [user_id] = (SELECT [user_id] FROM users WHERE email = ?) \n" +
                        "\tAND product_detail_id = ?";
                ps = conn.prepareStatement(updateQuery);
                ps.setInt(1, currentQuantity + 1);
                ps.setString(2, email);
                ps.setInt(3, productDetailId);
                ps.executeUpdate();
            } else {
                // Nếu sản phẩm chưa tồn tại trong giỏ hàng, thêm mới sản phẩm với số lượng = 1
                String insertQuery = "INSERT INTO cart ([user_id], product_detail_id, quantity, create_time) \n" +
                        "    VALUES ((SELECT [user_id] FROM users WHERE email = ?), ?, 1, CURRENT_TIMESTAMP)";
                ps = conn.prepareStatement(insertQuery);
                ps.setString(1, email);
                ps.setInt(2, productDetailId);
                ps.executeUpdate();
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStatusOrder(int orderId, String status){
        String query = "UPDATE [order] SET [status] = ? WHERE order_id = ?";
        try{
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, orderId);
            ps.executeUpdate();
            conn.close();

        }catch (Exception e){

        }


    }

    public void updateReceiverInfo(int orderId, String receiverName, String shippingAddress, String receiverPhone) {
        String query = "UPDATE [order] SET receiver_name = ?, shipping_address = ?, receiver_phone = ? WHERE order_id = ?";

        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, receiverName);
            ps.setString(2, shippingAddress);
            ps.setString(3, receiverPhone);
            ps.setInt(4, orderId);
            ps.executeUpdate();
            conn.close();

        }catch(Exception e) {

        }
    }

    public void updateOrderStatus(int orderId, String newStatus) {
        String query = "UPDATE [order] SET [status] = ? WHERE order_id = ?";
        try {
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newStatus);
            ps.setInt(2, orderId);
            ps.executeUpdate();
            conn.close();

        } catch (Exception e) {
        }
//        return false;
    }

    public void updateStockQuantity(int productDetailId, int orderQuantity){
        String query = "UPDATE product_detail SET quantity = quantity - ? WHERE product_detail_id = ?";

        try{
            conn = DbContext.getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, orderQuantity);
            ps.setInt(2, productDetailId);
            ps.executeUpdate();
            conn.close();

        }catch (Exception e){

        }
    }

}
