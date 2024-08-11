package com.vn.fpt.g1.shop.entity;

import java.sql.Timestamp;
import java.util.Date;

public class User {
    private int user_id;
    private String firstname;
    private String lastname;
    private String address;
    private Date dob;
    private String phone_number;
    private String email;
    private boolean isAvtive;
    private String password;
    private String gender;
    private Timestamp createdate;
    private Timestamp updatedate;

    public User() {
    }

    public User(int user_id, String firstname, String lastname, String email, String password) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public User(int user_id, String firstname, String lastname, String address, Date dob, String phone_number, String email, boolean isAvtive, String password, String gender, Timestamp createdate, Timestamp updatedate) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.dob = dob;
        this.phone_number = phone_number;
        this.email = email;
        this.isAvtive = isAvtive;
        this.password = password;
        this.gender = gender;
        this.createdate = createdate;
        this.updatedate = updatedate;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAvtive() {
        return isAvtive;
    }

    public void setAvtive(boolean avtive) {
        isAvtive = avtive;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Timestamp createdate) {
        this.createdate = createdate;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }

    public void setUpdatedate(Timestamp updatedate) {
        this.updatedate = updatedate;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", isAvtive=" + isAvtive +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", createdate=" + createdate +
                ", updatedate=" + updatedate +
                '}';
    }
}
