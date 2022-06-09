package com.alten.trial.vtracker.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.alten.trial.vtracker.entities.Vehicle;
import com.alten.trial.vtracker.entities.VehicleOwner;
import com.alten.trial.vtracker.services.VehicleOwnersService;
import com.alten.trial.vtracker.services.VehiclesService;

public class VehiclesControllerTest {

  private VehiclesController controller;
  private VehiclesService service;
  private VehicleOwnersService ownerService;

  @BeforeEach
  public void setUp() throws Exception {
    service = mock(VehiclesService.class);
    ownerService = mock(VehicleOwnersService.class);
    controller = new VehiclesController(service, ownerService);

  }

  @Test
  public void testCreateNewVehicle() {
    Vehicle newVehicle = new Vehicle();
    VehicleOwner owner = new VehicleOwner();
    owner.setName("test owner");
    Long ownerId = 13L;
    owner.setOwnerId(ownerId);
    newVehicle.setVehicleOwner(owner);
    newVehicle.setRegNr("ABC123");
    newVehicle.setStatus("offline");
    newVehicle.setVehicleId("YS2R4X20005399401");
    when(ownerService.getOwnerById(13L)).thenReturn(Optional.of(owner));
    doReturn(newVehicle).when(service).createNewVehicle(newVehicle);
    Vehicle result = controller.createNewVehicle(newVehicle);

    assertNotNull(result);
    assertThat(result.getRegNr().equals("ABC123"));
    assertThat(result.getVehicleId().equals("YS2R4X20005399401"));
    assertThat(result.getStatus().equals("offline"));
    assertNotNull(result.getVehicleOwner());

  }

  @Test
  public void testGetVehicleById() {
    String vehicleId = "YS2R4X20005399401";
    doReturn(Optional.of(new Vehicle())).when(service).getVehicle(vehicleId);
    Vehicle result = controller.getVehicleById(vehicleId);
    assertNotNull(result);
  }

  @Test
  public void testGetVehiclesByStatus() {
    String vehicleStatus = "online";
    doReturn(Arrays.asList(new Vehicle())).when(service).getVehiclesByStatus(vehicleStatus);
    List<Vehicle> result = controller.getVehiclesByStatus(vehicleStatus);
    assertNotNull(result);
    assertTrue(result.size() == 1);
  }

  @Test
  public void testGetVehiclesByOwner() {
    Long ownerId = 16l;
    doReturn(Arrays.asList(new Vehicle())).when(service).getVehiclesByOwner(ownerId);
    doReturn(Optional.of(new VehicleOwner())).when(ownerService).getOwnerById(ownerId);
    List<Vehicle> result = controller.getVehiclesByOwner(ownerId);
    assertNotNull(result);
    assertTrue(result.size() == 1);
  }

}
