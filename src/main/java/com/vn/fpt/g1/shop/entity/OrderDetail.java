package com.vn.fpt.g1.shop.entity;


public class OrderDetail {

  private long orderDetailId;
  private long orderId;
  private long productDetailId;
  private long quantity;
  private double price;


  public long getOrderDetailId() {
    return orderDetailId;
  }

  public void setOrderDetailId(long orderDetailId) {
    this.orderDetailId = orderDetailId;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
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


  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
