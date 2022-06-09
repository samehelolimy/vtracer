package com.alten.trial.vtracker.entities.enums;

public enum SystemConfig {
  V_ID_LENGTH(17);

  private int length;

  private SystemConfig(int length) {
    this.length = length;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

}
