package com.vn.fpt.g1.shop.entity;

public class Product {
    private int product_id;
    private String product_name;
    private String description;


    public Product() {
    }

    public Product(int product_id, String product_name, String description) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.description = description;
    }


    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
