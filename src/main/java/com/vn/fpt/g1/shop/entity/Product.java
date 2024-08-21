package com.vn.fpt.g1.shop.entity;

import java.text.DecimalFormat;

public class Product {
    private int product_id;
    private String product_name;
    private String description;
    private double minPrice;
    private double maxPrice;
    private String imageUrl;

    private static final DecimalFormat formatter = new DecimalFormat("#,###");

    public String getPriceDisplay() {
        if (minPrice == maxPrice) {
            return formatter.format(minPrice);
        } else {
            return formatter.format(minPrice) + " - " + formatter.format(maxPrice);
        }
    }

    public Product() {
    }

    public Product(int product_id, String product_name, String description, double minPrice, double maxPrice, String imageUrl) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.imageUrl = imageUrl;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
