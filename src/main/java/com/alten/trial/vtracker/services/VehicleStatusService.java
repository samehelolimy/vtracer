package com.alten.trial.vtracker.services;

import org.springframework.stereotype.Service;
import com.alten.trial.vtracker.entities.enums.Status;
import com.alten.trial.vtracker.external.VehicleSimulator;

@Service
public class VehicleStatusService {

  private VehicleSimulator vehicleSimulator = VehicleSimulator.getInstance();

  public Status getVehicleStatus(String vehicleId) {
    return this.vehicleSimulator.getVehicleStatus();
  }
}
