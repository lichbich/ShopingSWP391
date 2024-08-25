package com.vn.fpt.g1.shop.entity;

public class ProductDetail {
    private int product_detail_id;
    private int product_id;
    private float size;
    private int color_code;
    private double price;
    private int quantity;
    private String product_name;
    private String description;
    private String imageUrl;


    public ProductDetail(int product_id, int color_code) {
        this.product_id = product_id;
        this.color_code = color_code;
    }

    public ProductDetail() {
    }

    public ProductDetail(int product_detail_id, int product_id, float size, int color_code, double price, int quantity, String product_name, String description, String imageUrl) {
        this.product_detail_id = product_detail_id;
        this.product_id = product_id;
        this.size = size;
        this.color_code = color_code;
        this.price = price;
        this.quantity = quantity;
        this.product_name = product_name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getProduct_detail_id() {
        return product_detail_id;
    }

    public void setProduct_detail_id(int product_detail_id) {
        this.product_detail_id = product_detail_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public int getColor_code() {
        return color_code;
    }

    public void setColor_code(int color_code) {
        this.color_code = color_code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
