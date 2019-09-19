package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TelData {
  @Id
  @GeneratedValue // 主キーのIDを採番する役割
  private Long id;
  private String userName;
  private String telNo;
  private String mailAddr;
  private Long groupId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getTelNo() {
    return telNo;
  }

  public void setTelNo(String telNo) {
    this.telNo = telNo;
  }

  public String getMailAddr() {
    return mailAddr;
  }

  public void setMailAddr(String mailAddr) {
    this.mailAddr = mailAddr;
  }

  public Long getGroupId() {
    return groupId;
  }

  public void setGroupId(Long groupId) {
    this.groupId = groupId;
  }
}