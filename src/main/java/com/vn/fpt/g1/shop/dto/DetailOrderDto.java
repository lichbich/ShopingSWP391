package com.vn.fpt.g1.shop.dto;

public class DetailOrderDto {
    private long productId;
    private String productName;
    private long colorCode;
    private double size;
    private long quantity;
    private double price;
    private Long totalQuantityOfProduct;
    private Double totalPriceOfProduct;
    public DetailOrderDto() {
    }

    public DetailOrderDto(long productId, String productName, long colorCode, double size, long quantity, double price, Long totalQuantityOfProduct, Double totalPriceOfProduct) {
        this.productId = productId;
        this.productName = productName;
        this.colorCode = colorCode;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.totalQuantityOfProduct = totalQuantityOfProduct;
        this.totalPriceOfProduct = totalPriceOfProduct;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }


    public long getColorCode() {
        return colorCode;
    }

    public void setColorCode(long colorCode) {
        this.colorCode = colorCode;
    }


    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }


    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getTotalQuantityOfProduct() {
        return totalQuantityOfProduct;
    }

    public void setTotalQuantityOfProduct(Long totalQuantityOfProduct) {
        this.totalQuantityOfProduct = totalQuantityOfProduct;
    }

    public Double getTotalPriceOfProduct() {
        return totalPriceOfProduct;
    }

    public void setTotalPriceOfProduct(Double totalPriceOfProduct) {
        this.totalPriceOfProduct = totalPriceOfProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
