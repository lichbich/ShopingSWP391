package com.vn.fpt.g1.shop.entity;

public class Color {
    public int color_id;
    public String color_name;
    public int color_code;

    public Color() {
    }

    public Color(int color_id, String color_name, int color_code) {
        this.color_id = color_id;
        this.color_name = color_name;
        this.color_code = color_code;
    }

    public int getColor_id() {
        return color_id;
    }

    public void setColor_id(int color_id) {
        this.color_id = color_id;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public int getColor_code() {
        return color_code;
    }

    public void setColor_code(int color_code) {
        this.color_code = color_code;
    }

}
