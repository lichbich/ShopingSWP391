package com.vn.fpt.g1.shop.entity;


import java.sql.Date;

public class OrderTracking {

  private long orderTrackingId;
  private long orderId;
  private String status;
  private Date beginShipping;
  private Date receiveDate;


  public long getOrderTrackingId() {
    return orderTrackingId;
  }

  public void setOrderTrackingId(long orderTrackingId) {
    this.orderTrackingId = orderTrackingId;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public Date getBeginShipping() {
    return beginShipping;
  }

  public void setBeginShipping(Date beginShipping) {
    this.beginShipping = beginShipping;
  }

  public Date getReceiveDate() {
    return receiveDate;
  }

  public void setReceiveDate(Date receiveDate) {
    this.receiveDate = receiveDate;
  }
}
