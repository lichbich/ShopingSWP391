package com.vn.fpt.g1.shop.entity;


import java.sql.Date;

public class ProductDetail {

  private long productDetailId;
  private long productId;
  private long colorCode;
  private double size;
  private long quantity;
  private double price;
  private Date importUpdateDate;


  public long getProductDetailId() {
    return productDetailId;
  }

  public void setProductDetailId(long productDetailId) {
    this.productDetailId = productDetailId;
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

  public Date getImportUpdateDate() {
    return importUpdateDate;
  }

  public void setImportUpdateDate(Date importUpdateDate) {
    this.importUpdateDate = importUpdateDate;
  }
}
