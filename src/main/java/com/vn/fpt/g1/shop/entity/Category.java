package com.vn.fpt.g1.shop.entity;

public class Category {
    private int id;
    private String description;
    private int status; // Changed from boolean to int
    private java.util.Date createDate;
    private java.util.Date updateDate;

    // Constructors, getters, and setters
    public Category() {}

    public Category(int id, String description, int status, java.util.Date createDate, java.util.Date updateDate) {
        this.id = id;
        this.description = description;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public java.util.Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }
}
