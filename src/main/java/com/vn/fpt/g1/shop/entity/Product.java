package com.vn.fpt.g1.shop.entity;


public class Product {

  private long productId;
  private String productName;
  private String description;
  private String productCode;
  private double price;
  private String image;
  private java.sql.Date importDate;
  private java.sql.Date exportDate;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp updateDate;


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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


  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }


  public java.sql.Date getImportDate() {
    return importDate;
  }

  public void setImportDate(java.sql.Date importDate) {
    this.importDate = importDate;
  }


  public java.sql.Date getExportDate() {
    return exportDate;
  }

  public void setExportDate(java.sql.Date exportDate) {
    this.exportDate = exportDate;
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
