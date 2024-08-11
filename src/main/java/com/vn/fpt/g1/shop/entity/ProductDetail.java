package com.vn.fpt.g1.shop.entity;


public class ProductDetail {

  private long productId;
  private String productCode;
  private long colorId;
  private double price;
  private long isActive;
  private long sizeId;
  private long imageId;
  private long quantity;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp updateDate;


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


  public long getColorId() {
    return colorId;
  }

  public void setColorId(long colorId) {
    this.colorId = colorId;
  }


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }


  public long getIsActive() {
    return isActive;
  }

  public void setIsActive(long isActive) {
    this.isActive = isActive;
  }


  public long getSizeId() {
    return sizeId;
  }

  public void setSizeId(long sizeId) {
    this.sizeId = sizeId;
  }


  public long getImageId() {
    return imageId;
  }

  public void setImageId(long imageId) {
    this.imageId = imageId;
  }


  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }


  public java.sql.Timestamp getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.sql.Timestamp createDate) {
    this.createDate = createDate;
  }


  public java.sql.Timestamp getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(java.sql.Timestamp updateDate) {
    this.updateDate = updateDate;
  }

}
