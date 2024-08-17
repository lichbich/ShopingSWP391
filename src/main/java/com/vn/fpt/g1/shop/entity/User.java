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
    private int isActive;
    private String password;
    private String gender;
    private Timestamp createdate;
    private Timestamp updatedate;
    private int role_id;
    private String rolename;

    public User() {
    }

    public User(int user_id, String firstname, String lastname, String email, String password) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public User(int user_id, String firstname, String lastname, String address, String phone_number, String email, String rolename) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.rolename = rolename;
    }

    public User(String firstname, String lastname, String address, String phone_number, String email, String rolename) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.rolename = rolename;
    }

    public User(int user_id, String firstname, String lastname, String address, Date dob, String phone_number, String email, int isActive, String password, String gender, Timestamp createdate, Timestamp updatedate, int role_id, String rolename) {
        this.user_id = user_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.dob = dob;
        this.phone_number = phone_number;
        this.email = email;
        this.isActive = isActive;
        this.password = password;
        this.gender = gender;
        this.createdate = createdate;
        this.updatedate = updatedate;
        this.role_id = role_id;
        this.rolename = rolename;
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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
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

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
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
                ", isActive=" + isActive +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", createdate=" + createdate +
                ", updatedate=" + updatedate +
                ", role_id=" + role_id +
                ", rolename='" + rolename + '\'' +
                '}';
    }
}
