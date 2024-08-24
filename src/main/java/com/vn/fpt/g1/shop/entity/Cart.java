package com.vn.fpt.g1.shop.entity;

public class Cart {
    private int cart_id;
    private int user_id;
    private String user_email;
    private int product_detail_id;
    private int product_id;
    private String product_name;
    private String size;
    private int color_id;
    private String color_name;
    private String price;
    private int quantity;
    private String img_url;


    public Cart() {
    }

    public Cart(int cart_id, int user_id, String user_email, int product_detail_id, int product_id, String product_name, String size, int color_id, String color_name, String price, int quantity, String img_url) {
        this.cart_id = cart_id;
        this.user_id = user_id;
        this.user_email = user_email;
        this.product_detail_id = product_detail_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.size = size;
        this.color_id = color_id;
        this.color_name = color_name;
        this.price = price;
        this.quantity = quantity;
        this.img_url = img_url;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProduct_detail_id() {
        return product_detail_id;
    }

    public void setProduct_detail_id(int product_detail_id) {
        this.product_detail_id = product_detail_id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", user_id=" + user_id +
                ", user_email='" + user_email + '\'' +
                ", product_detail_id=" + product_detail_id +
                ", product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", size='" + size + '\'' +
                ", color_id=" + color_id +
                ", color_name='" + color_name + '\'' +
                ", price='" + price + '\'' +
                ", quantity=" + quantity +
                ", img_url='" + img_url + '\'' +
                '}';
    }
}
