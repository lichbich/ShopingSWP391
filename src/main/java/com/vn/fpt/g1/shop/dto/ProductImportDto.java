package com.vn.fpt.g1.shop.dto;

import java.util.List;

public class ProductImportDto {
    private long productId;
    private String productCode;
    private String productName;
    private String description;
    private String colorCode;
    private double price;
    private int isActive;
    private int size;
    private String imageUrl;
    private long quantity;
    private ColorDto colorDto;
    private SizeDto sizeDto;
    public ProductImportDto() {
    }

    public ProductImportDto(long productId, String productCode, String productName, String description, String colorCode, double price, int isActive, int size, String imageUrl, long quantity) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.description = description;
        this.colorCode = colorCode;
        this.price = price;
        this.isActive = isActive;
        this.size = size;
        this.imageUrl = imageUrl;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ColorDto getColorDto() {
        return colorDto;
    }

    public void setColorDto(ColorDto colorDto) {
        this.colorDto = colorDto;
    }

    public SizeDto getSizeDto() {
        return sizeDto;
    }

    public void setSizeDto(SizeDto sizeDto) {
        this.sizeDto = sizeDto;
    }
}
