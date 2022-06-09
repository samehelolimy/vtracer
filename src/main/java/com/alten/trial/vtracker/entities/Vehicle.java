package com.alten.trial.vtracker.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Vehicle implements Serializable {

  private final static int V_ID_MIN = 17;
  private final static int V_ID_MAX = 17;
  private final static int V_RG_MIN = 6;
  private final static int V_RG_MAX = 6;

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue
  @JsonIgnore
  private long id;

  @NotNull
  @Size(min = V_ID_MIN, max = V_ID_MAX)
  private String vehicleId;
  @NotNull
  @Size(min = V_RG_MIN, max = V_RG_MAX)
  private String regNr;

  private String status;

  @NotNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "owner_id")
  private VehicleOwner vehicleOwner;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getVehicleId() {
    return vehicleId;
  }

  public void setVehicleId(String vehicleId) {
    this.vehicleId = vehicleId;
  }

  public String getRegNr() {
    return regNr;
  }

  public void setRegNr(String regNr) {
    this.regNr = regNr;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public VehicleOwner getVehicleOwner() {
    return vehicleOwner;
  }

  public void setVehicleOwner(VehicleOwner vehicleOwner) {
    this.vehicleOwner = vehicleOwner;
  }

}
