package com.vn.fpt.g1.shop.entity;


import java.sql.Date;

public class Color {

  private long colorId;
  private String colorName;
  private String colorCode;

  public Color() {
  }

  public Color(long colorId, String colorName, String colorCode) {
    this.colorId = colorId;
    this.colorName = colorName;
    this.colorCode = colorCode;
  }

  public long getColorId() {
    return colorId;
  }

  public void setColorId(long colorId) {
    this.colorId = colorId;
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

}
