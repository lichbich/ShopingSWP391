package com.vn.fpt.g1.shop.entity;


public class Image {

  private long imageId;
  private long productId;
  private long colorId;
  private String type;
  private String imageUrl;


  public long getImageId() {
    return imageId;
  }

  public void setImageId(long imageId) {
    this.imageId = imageId;
  }


  public long getProductId() {
    return productId;
  }

  public void setProductId(long productId) {
    this.productId = productId;
  }


  public long getColorId() {
    return colorId;
  }

  public void setColorId(long colorId) {
    this.colorId = colorId;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
  }

}
