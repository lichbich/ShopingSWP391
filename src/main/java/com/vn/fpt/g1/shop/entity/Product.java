package com.vn.fpt.g1.shop.entity;

import java.sql.Timestamp;

public class Product {
    private int productId;
    private String name;
    private String description;
    private double price;
    private int categoryId;
    private int status;
    private Timestamp createDate;
    private Timestamp updateDate;

    // Constructors, getters, and setters

    public Product() {}

    public Product(int productId, String name, String description, double price, int categoryId, int status, Timestamp createDate, Timestamp updateDate) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.categoryId = categoryId;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getCategoryId() { return categoryId; }
    public void setCategoryId(int categoryId) { this.categoryId = categoryId; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public Timestamp getCreateDate() { return createDate; }
    public void setCreateDate(Timestamp createDate) { this.createDate = createDate; }

    public Timestamp getUpdateDate() { return updateDate; }
    public void setUpdateDate(Timestamp updateDate) { this.updateDate = updateDate; }
}
