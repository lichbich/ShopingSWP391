package com.vn.fpt.g1.shop.entity;


import java.sql.Date;

public class Wishlist {

  private long wishId;
  private long userId;
  private long productId;
  private Date createDate;
  private Date updateDate;


  public long getWishId() {
    return wishId;
  }

  public void setWishId(long wishId) {
    this.wishId = wishId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }

  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
}
