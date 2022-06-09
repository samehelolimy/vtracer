package com.alten.trial.vtracker.api;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.alten.trial.vtracker.entities.enums.Status;
import com.alten.trial.vtracker.external.VehicleSimulator;

public class VehicleStatusControllerTest {

  private VehicleSimulator simulator = VehicleSimulator.getInstance();
  private Status status;

  @BeforeEach
  public void setUp() throws Exception {
    status = simulator.getVehicleStatus();
  }

  @Test
  public void testGetVehicleStatus() {
    assertNotNull(status);
    assertTrue(
        status.getStatusValue().equals("online") || status.getStatusValue().equals("offline"));
  }

}
