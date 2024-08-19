package com.vn.fpt.g1.shop.entity;


import java.sql.Date;

public class Cart {

  private long cartId;
  private long userId;
  private long productDetailId;
  private long quantity;
  private Date createTime;
  private Date updateDate;


  public long getCartId() {
    return cartId;
  }

  public void setCartId(long cartId) {
    this.cartId = cartId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public long getProductDetailId() {
    return productDetailId;
  }

  public void setProductDetailId(long productDetailId) {
    this.productDetailId = productDetailId;
  }


  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }


  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(Date updateDate) {
    this.updateDate = updateDate;
  }
}
