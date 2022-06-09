package com.alten.trial.vtracker.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.alten.trial.vtracker.entities.Address;
import com.alten.trial.vtracker.entities.Vehicle;
import com.alten.trial.vtracker.entities.VehicleOwner;
import com.alten.trial.vtracker.entities.enums.Status;
import com.alten.trial.vtracker.repositories.VehiclesRepository;

public class VehiclesServiceTest {
  private Vehicle vehicleToBeSaved;
  private Vehicle vehicleToBeRetrieved;
  private String vehicleId = "YS2R4X20005387949";
  private VehiclesService service;
  private VehiclesRepository repository;

  @BeforeEach
  public void setUp() throws Exception {
    vehicleToBeSaved = new Vehicle();
    vehicleToBeSaved.setRegNr("QWE009");
    vehicleToBeSaved.setVehicleId("987654321AZXCVB99");
    vehicleToBeSaved.setStatus(Status.OFLINE.getStatusValue());
    Address address1 = new Address();
    address1.setAddressLine1("Cementvägen 8, 111 11 Södertälje");
    VehicleOwner owner1 = new VehicleOwner();
    owner1.setName("test owner");
    owner1.setAddress(address1);
    vehicleToBeSaved.setVehicleOwner(owner1);

    vehicleToBeRetrieved = new Vehicle();
    vehicleToBeRetrieved.setVehicleId("YS2R4X20005387949");
    vehicleToBeRetrieved.setRegNr("PO9909");
    vehicleToBeRetrieved.setStatus("offline");
    Address address2 = new Address();
    address2.setAddressLine1("Balkvägen 12, 222 22 Stockholm");
    VehicleOwner owner2 = new VehicleOwner();
    owner2.setName("test owner 2");
    owner2.setAddress(address2);
    vehicleToBeRetrieved.setVehicleOwner(owner2);

    repository = mock(VehiclesRepository.class);
    service = new VehiclesService(repository);
  }

  @Test
  public void testCreateNewVehicle() {
    doReturn(vehicleToBeSaved).when(repository).save(vehicleToBeSaved);
    Vehicle saved = service.createNewVehicle(vehicleToBeSaved);
    assertNotNull(saved);
    assertNotNull(saved.getId());
    assertEquals(saved.getRegNr(), "QWE009");
    assertEquals(saved.getStatus(), "offline");
    assertEquals(saved.getVehicleId(), "987654321AZXCVB99");
    assertNotNull(saved.getVehicleOwner());
    assertEquals(saved.getVehicleOwner().getName(), "test owner");
  }

  @Test
  public void testGetVehicle() {
    doReturn(Optional.of(vehicleToBeRetrieved)).when(repository).findById(vehicleId);
    Optional<Vehicle> found = service.getVehicle(vehicleId);
    assertNotNull(found);
    assertEquals(found.get().getRegNr(), "PO9909");
    assertEquals(found.get().getStatus(), "offline");
    assertEquals(found.get().getVehicleId(), "YS2R4X20005387949");
    assertNotNull(found.get().getVehicleOwner());
    assertEquals(found.get().getVehicleOwner().getName(), "test owner 2");
  }

  @Test
  public void testGetVehiclesByStatus() {
    doReturn(Arrays.asList(new Vehicle())).when(repository)
        .findAllByStatus(Status.ONLINE.getStatusValue());
    List<Vehicle> vehicles = service.getVehiclesByStatus(Status.ONLINE.getStatusValue());
    assertNotNull(vehicles);
    assertEquals(vehicles.size(), 1);
  }

  @Test
  public void testGetVehiclesByOwner() {
    Long ownerId = 10L;
    doReturn(Arrays.asList(new Vehicle())).when(repository).findAllByVehicleOwnerId(ownerId);
    List<Vehicle> vehicles = service.getVehiclesByOwner(ownerId);
    assertNotNull(vehicles);
    assertEquals(vehicles.size(), 1);
  }

}
