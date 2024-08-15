package com.vn.fpt.g1.shop.entity;

import java.sql.Timestamp;

public class Category {
    private int CategoryId;
    private String description;
    private int status;
    private Timestamp createDate;
    private Timestamp updateDate;

    // Constructors
    public Category() {}

    public Category(int categoryId, String description, int status, Timestamp createDate, Timestamp updateDate) {
        this.CategoryId = categoryId;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    // Getters and Setters
    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int categoryId) {
        this.CategoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }
}
