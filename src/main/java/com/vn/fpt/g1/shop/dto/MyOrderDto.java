package com.vn.fpt.g1.shop.dto;

import java.sql.Date;

public class MyOrderDto {
    private long orderId;
    private String status;
    private Date orderDate;
    private double totalPrice;
    private String shippingAddress;
    private String receiverName;
    private String receiverPhone;

    private DetailOrderDto detailOrder;

    public MyOrderDto(long orderId, String status, Date orderDate, double totalPrice, String shippingAddress, String receiverName, String receiverPhone, DetailOrderDto detailOrder) {
        this.orderId = orderId;
        this.status = status;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.shippingAddress = shippingAddress;
        this.receiverName = receiverName;
        this.receiverPhone = receiverPhone;
        this.detailOrder = detailOrder;
    }

    public MyOrderDto() {
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

    public DetailOrderDto getDetailOrder() {
        return detailOrder;
    }

    public void setDetailOrder(DetailOrderDto detailOrder) {
        this.detailOrder = detailOrder;
    }
}
