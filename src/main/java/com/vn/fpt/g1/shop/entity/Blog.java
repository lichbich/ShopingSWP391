package com.vn.fpt.g1.shop.entity;


import java.sql.Date;

public class Blog {

  private long blogId;
  private String title;
  private String content;
  private long userId;
  private Date createDate;


  public long getBlogId() {
    return blogId;
  }

  public void setBlogId(long blogId) {
    this.blogId = blogId;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

}
