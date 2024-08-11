package com.vn.fpt.g1.shop.dto;

import java.util.List;

public class ProductStockDto {
    private long productId;
    private String productCode;
    private String productName;
    private List<ColorDto> colorDtos;
    private double price;
    private int isActive;
    private List<SizeDto> sizeDtos;
    private String imageUrl;
    private long quantity;

    public ProductStockDto() {
    }

    public ProductStockDto(long productId, String productCode, String productName, List<ColorDto> colorDtos, double price, int isActive, List<SizeDto> sizeDtos, String imageUrl, long quantity) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.colorDtos = colorDtos;
        this.price = price;
        this.isActive = isActive;
        this.sizeDtos = sizeDtos;
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

    public List<ColorDto> getColorDtos() {
        return colorDtos;
    }

    public void setColorDtos(List<ColorDto> colorDtos) {
        this.colorDtos = colorDtos;
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

    public List<SizeDto> getSizeDtos() {
        return sizeDtos;
    }

    public void setSizeDtos(List<SizeDto> sizeDtos) {
        this.sizeDtos = sizeDtos;
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
}
