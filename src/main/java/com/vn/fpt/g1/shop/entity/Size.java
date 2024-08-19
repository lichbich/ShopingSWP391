package com.vn.fpt.g1.shop.entity;

import java.sql.Date;

public class Size {

  private long productId;
  private long sizeId;
  private long size;
  private Date createDate;
  private Date updateDate;

  public Size() {
  }

  public Size(long productId, long sizeId, long size, Date createDate, Date updateDate) {
    this.productId = productId;
    this.sizeId = sizeId;
    this.size = size;
    this.createDate = createDate;
    this.updateDate = updateDate;
  }

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
