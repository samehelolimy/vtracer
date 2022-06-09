package com.alten.trial.vtracker.entities.enums;

public enum Status {

  ONLINE("online", "online"), 
  OFLINE("offline", "offline");

  private String statusName;
  private String statusValue;

  private Status(String statusName, String statusValue) {
    this.statusName = statusName;
    this.statusValue = statusValue;
  }

  public String getStatusName() {
    return statusName;
  }

  public void setStatusName(String statusName) {
    this.statusName = statusName;
  }

  public String getStatusValue() {
    return statusValue;
  }

  public void setStatusValue(String statusValue) {
    this.statusValue = statusValue;
  }

}
