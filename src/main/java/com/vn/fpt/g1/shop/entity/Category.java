package com.vn.fpt.g1.shop.entity;

public class Category {
    private int category_id;
    private String name;
    private boolean status;
    private String description;

    // Constructors, getters, and setters
    public Category() {}

    public Category(int category_id, String name) {
        this.category_id = category_id;
        this.name = name;
    }

    public Category(int category_id, String name, boolean status, String description) {
        this.category_id = category_id;
        this.name = name;
        this.status = status;
        this.description = description;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
