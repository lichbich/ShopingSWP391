package com.vn.fpt.g1.shop.entity;

import java.util.Date;

public class Users {
    private int user_id;
    private String first_name;
    private String last_name;
    private String email;
    private String password;
    private String phone_number;
    private String address;
    private String role_id;
    private Date dob;
    private String gender;
    private int isActive;

    public Users(String email, String password) {
        this.isActive = isActive;
        this.gender = gender;
        this.dob = dob;
        this.role_id = role_id;
        this.address = address;
        this.phone_number = phone_number;
        this.password = password;
        this.email = email;
        this.last_name = last_name;
        this.first_name = first_name;
        this.user_id = user_id;
    }

    public Users() {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.phone_number = phone_number;
        this.address = address;
        this.role_id = role_id;
        this.dob = dob;
        this.gender = gender;
        this.isActive = isActive;
    }

    public boolean hasRole(String role) {
        return this.role_id.equals(role);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }
}