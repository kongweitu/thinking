package com.boot.thinking.entity;


public class KdmLog {

  private long id;
  private String logtype;
  private long relateid;
  private long userid;
  private String username;
  private String operatedesc;
  private java.sql.Date operatetype;
  private String memo;
  private java.sql.Timestamp addtime;
  private long recordid;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getLogtype() {
    return logtype;
  }

  public void setLogtype(String logtype) {
    this.logtype = logtype;
  }


  public long getRelateid() {
    return relateid;
  }

  public void setRelateid(long relateid) {
    this.relateid = relateid;
  }


  public long getUserid() {
    return userid;
  }

  public void setUserid(long userid) {
    this.userid = userid;
  }


  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }


  public String getOperatedesc() {
    return operatedesc;
  }

  public void setOperatedesc(String operatedesc) {
    this.operatedesc = operatedesc;
  }


  public java.sql.Date getOperatetype() {
    return operatetype;
  }

  public void setOperatetype(java.sql.Date operatetype) {
    this.operatetype = operatetype;
  }


  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }


  public java.sql.Timestamp getAddtime() {
    return addtime;
  }

  public void setAddtime(java.sql.Timestamp addtime) {
    this.addtime = addtime;
  }


  public long getRecordid() {
    return recordid;
  }

  public void setRecordid(long recordid) {
    this.recordid = recordid;
  }

}
