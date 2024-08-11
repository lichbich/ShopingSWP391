package com.vn.fpt.g1.shop.entity;


public class Role {

  private long roleId;
  private String roleName;
  private long priority;
  private String feature;


  public long getRoleId() {
    return roleId;
  }

  public void setRoleId(long roleId) {
    this.roleId = roleId;
  }


  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }


  public long getPriority() {
    return priority;
  }

  public void setPriority(long priority) {
    this.priority = priority;
  }


  public String getFeature() {
    return feature;
  }

  public void setFeature(String feature) {
    this.feature = feature;
  }

}
