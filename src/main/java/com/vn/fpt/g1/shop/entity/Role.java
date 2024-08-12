package com.vn.fpt.g1.shop.entity;

public class Role {
    private int role_id;
    private String role_name;
    private int priority;
    private String feature;

    public Role() {
    }

    public Role(int role_id, String role_name) {
        this.role_id = role_id;
        this.role_name = role_name;
    }

    public Role(int role_id, String role_name, int priority, String feature) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.priority = priority;
        this.feature = feature;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_name='" + role_name + '\'' +
                ", priority=" + priority +
                ", feature='" + feature + '\'' +
                '}';
    }
}
