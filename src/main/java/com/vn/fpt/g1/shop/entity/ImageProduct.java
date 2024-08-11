package com.vn.fpt.g1.shop.entity;


public class ImageProduct {

  private long productId;
  private long imageId;
  private String imageUrl;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp updateDate;


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public long getImageId() {
    return imageId;
  }

  public void setImageId(long imageId) {
    this.imageId = imageId;
  }


  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
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
