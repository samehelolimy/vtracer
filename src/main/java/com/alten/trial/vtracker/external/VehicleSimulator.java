package com.alten.trial.vtracker.external;

import java.util.Random;
import com.alten.trial.vtracker.entities.enums.Status;

/**
 * Simulates the vehicle connectivity checking
 * 
 * @author AbdelghafarAhmed
 *
 */
public final class VehicleSimulator {
  private static final VehicleSimulator INSTANCE = new VehicleSimulator();

  private VehicleSimulator() {}

  public static VehicleSimulator getInstance() {
    return INSTANCE;
  }

  public Status getVehicleStatus() {
    int random = new Random().nextInt(99);
    random += 1;

    if (random % 2 == 0) {
      return Status.OFLINE;
    } else
      return Status.ONLINE;

  }

}
