package com.vn.fpt.g1.shop.entity;

import java.sql.Timestamp;
import java.text.DecimalFormat;

public class Product {
    private int product_id;
    private String product_name;
    private String description;
    private int is_active;
    private int category_id;
    private double minPrice;
    private double maxPrice;
    private String imageUrl;
    private Timestamp createdate;
    private Timestamp updatedate;

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

    public Product(int product_id, String product_name, String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
    }

    public Product(int product_id, String product_name, String description, int is_active, Timestamp createdate) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.is_active = is_active;
        this.createdate = createdate;
    }

    public Product(int product_id, String product_name, String description, int is_active, int category_id, double minPrice, double maxPrice, String imageUrl, Timestamp createdate, Timestamp updatedate) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
        this.is_active = is_active;
        this.category_id = category_id;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.imageUrl = imageUrl;
        this.createdate = createdate;
        this.updatedate = updatedate;
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

    public int getIs_active() {
        return is_active;
    }

    public void setIs_active(int is_active) {
        this.is_active = is_active;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
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

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                ", is_active=" + is_active +
                ", category_id=" + category_id +
                ", minPrice=" + minPrice +
                ", maxPrice=" + maxPrice +
                ", imageUrl='" + imageUrl + '\'' +
                ", createdate=" + createdate +
                ", updatedate=" + updatedate +
                '}';
    }
}
