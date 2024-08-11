package com.vn.fpt.g1.shop.entity;


public class Size {

  private long productId;
  private long sizeId;
  private long size;
  private java.sql.Timestamp createDate;
  private java.sql.Timestamp updateDate;


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public long getSizeId() {
    return sizeId;
  }

  public void setSizeId(long sizeId) {
    this.sizeId = sizeId;
  }


  public long getSize() {
    return size;
  }

  public void setSize(long size) {
    this.size = size;
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
