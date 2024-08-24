package com.vn.fpt.g1.shop.entity;

import java.sql.Timestamp;

public class Order {
    private int order_id;
    private int user_id;
    public String user_firstname;
    public String user_lastname;
    private String user_email;
    private String status;
    private String product_name;
    private Timestamp order_date;
    private String total_price;
    private String receiver_name;
    private String receiver_phone;
    private String shipping_address;

    public Order() {
    }



    public Order(int order_id, String user_email, String status, Timestamp order_date, String total_price, String receiver_name, String receiver_phone, String shipping_address) {
        this.order_id = order_id;
        this.user_email = user_email;
        this.status = status;
        this.order_date = order_date;
        this.total_price = total_price;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.shipping_address = shipping_address;
    }

    public Order(int order_id, int user_id, String user_email, String status, String product_name, Timestamp order_date, String total_price, String receiver_name, String receiver_phone, String shipping_address) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.user_email = user_email;
        this.status = status;
        this.order_date = order_date;
        this.product_name = product_name;
        this.total_price = total_price;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.shipping_address = shipping_address;
    }

    public Order(int order_id, int user_id, String user_firstname, String user_lastname, String user_email, String status, String product_name, Timestamp order_date, String total_price, String receiver_name, String receiver_phone, String shipping_address) {
        this.order_id = order_id;
        this.user_id = user_id;
        this.user_firstname = user_firstname;
        this.user_lastname = user_lastname;
        this.user_email = user_email;
        this.status = status;
        this.product_name = product_name;
        this.order_date = order_date;
        this.total_price = total_price;
        this.receiver_name = receiver_name;
        this.receiver_phone = receiver_phone;
        this.shipping_address = shipping_address;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_firstname() {
        return user_firstname;
    }

    public void setUser_firstname(String user_firstname) {
        this.user_firstname = user_firstname;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Timestamp getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Timestamp order_date) {
        this.order_date = order_date;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiver_phone() {
        return receiver_phone;
    }

    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public void setShipping_address(String shipping_address) {
        this.shipping_address = shipping_address;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", user_id=" + user_id +
                ", user_firstname='" + user_firstname + '\'' +
                ", user_lastname='" + user_lastname + '\'' +
                ", user_email='" + user_email + '\'' +
                ", status='" + status + '\'' +
                ", product_name='" + product_name + '\'' +
                ", order_date=" + order_date +
                ", total_price='" + total_price + '\'' +
                ", receiver_name='" + receiver_name + '\'' +
                ", receiver_phone='" + receiver_phone + '\'' +
                ", shipping_address='" + shipping_address + '\'' +
                '}';
    }
}
