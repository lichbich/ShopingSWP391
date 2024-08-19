package com.vn.fpt.g1.shop.entity;


import java.sql.Date;

public class Order {

  private long orderId;
  private long userId;
  private String status;
  private Date orderDate;
  private double totalPrice;
  private String shippingAddress;
  private String receiverName;
  private String receiverPhone;


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public Date getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Date orderDate) {
    this.orderDate = orderDate;
  }

  public double getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(double totalPrice) {
    this.totalPrice = totalPrice;
  }


  public String getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
  }


  public String getReceiverName() {
    return receiverName;
  }

  public void setReceiverName(String receiverName) {
    this.receiverName = receiverName;
  }


  public String getReceiverPhone() {
    return receiverPhone;
  }

  public void setReceiverPhone(String receiverPhone) {
    this.receiverPhone = receiverPhone;
  }

}
