package com.alten.trial.vtracker.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class VehicleOwner implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private Long id;
  private String name;
  private Address address;

  public Long getOwnerId() {
    return id;
  }

  public void setOwnerId(Long ownerId) {
    this.id = ownerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

}
