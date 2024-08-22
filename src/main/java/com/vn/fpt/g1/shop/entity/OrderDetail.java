package com.vn.fpt.g1.shop.entity;

public class OrderDetail {
    private int order_detail_id;
    private int order_id;
    private String product_name;
    private String color_name;
    private String size;
    private int quantity;
    private String price;
    private String image_url;

    public OrderDetail() {
    }

    public OrderDetail(int order_detail_id, int order_id, String product_name, String color_name, String size, int quantity, String price, String image_url) {
        this.order_detail_id = order_detail_id;
        this.order_id = order_id;
        this.product_name = product_name;
        this.color_name = color_name;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
        this.image_url = image_url;
    }

    public int getOrder_detail_id() {
        return order_detail_id;
    }

    public void setOrder_detail_id(int order_detail_id) {
        this.order_detail_id = order_detail_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order_detail_id=" + order_detail_id +
                ", order_id=" + order_id +
                ", product_name='" + product_name + '\'' +
                ", color_name='" + color_name + '\'' +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", price='" + price + '\'' +
                ", image_url='" + image_url + '\'' +
                '}';
    }
}
