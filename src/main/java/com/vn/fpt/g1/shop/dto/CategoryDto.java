package com.vn.fpt.g1.shop.dto;

public class CategoryDto {
    private int id;
    private String description;
    private int status;

    // Constructor không tham số
    public CategoryDto() {}

    // Constructor có tham số cho khi thêm mới
    public CategoryDto(String description, int status) {
        this.description = description;
        this.status = status;
    }

    // Constructor có tham số cho khi chỉnh sửa
    public CategoryDto(int id, String description, int status) {
        this.id = id;
        this.description = description;
        this.status = status;
    }

    // Getters và Setters
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
}
