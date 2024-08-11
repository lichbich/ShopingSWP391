package com.vn.fpt.g1.shop.entity;


import java.sql.Date;

public class ProductColor {

  private long productId;
  private long productColorId;
  private String colorName;
  private String colorCode;
  private Date createDate;
  private Date updateDate;

  public ProductColor(long productId, long productColorId, String colorName, String colorCode, Date createDate, Date updateDate) {
    this.productId = productId;
    this.productColorId = productColorId;
    this.colorName = colorName;
    this.colorCode = colorCode;
    this.createDate = createDate;
    this.updateDate = updateDate;
  }

  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public long getProductColorId() {
    return productColorId;
  }

  public void setProductColorId(long productColorId) {
    this.productColorId = productColorId;
  }


  public String getColorName() {
    return colorName;
  }

  public void setColorName(String colorName) {
    this.colorName = colorName;
  }


  public String getColorCode() {
    return colorCode;
  }

  public void setColorCode(String colorCode) {
    this.colorCode = colorCode;
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
