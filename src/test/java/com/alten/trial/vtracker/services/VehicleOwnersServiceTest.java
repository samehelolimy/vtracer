package com.alten.trial.vtracker.services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.alten.trial.vtracker.entities.Address;
import com.alten.trial.vtracker.entities.VehicleOwner;
import com.alten.trial.vtracker.repositories.VehicleOwnersRepository;

public class VehicleOwnersServiceTest {
  private VehicleOwner ownerToBeSaved;
  private VehicleOwner ownerToBeRetrieved;
  private Long ownerId;
  private VehicleOwnersService service;
  private VehicleOwnersRepository repository;

  @BeforeEach
  public void setUp() throws Exception {
    ownerToBeSaved = new VehicleOwner();
    ownerToBeSaved.setName("test owner");
    Address address1 = new Address();
    address1.setAddressLine1("Cementvägen 8, 111 11 Södertälje");
    ownerToBeSaved.setAddress(address1);
    ownerToBeSaved.setOwnerId(23l);

    ownerToBeRetrieved = new VehicleOwner();
    ownerToBeRetrieved.setName("saved owner");
    Address address2 = new Address();
    address2.setAddressLine1("Balkvägen 12, 222 22 Stockholm");
    ownerToBeRetrieved.setAddress(address2);
    ownerId = 12L;
    ownerToBeRetrieved.setOwnerId(ownerId);
    repository = mock(VehicleOwnersRepository.class);
    service = new VehicleOwnersService(repository);
  }

  @Test
  public void testCreateNewOwner() {
    doReturn(ownerToBeSaved).when(repository).save(ownerToBeSaved);
    VehicleOwner createdOwner = service.createNewOwner(ownerToBeSaved);
    assertNotNull(createdOwner);
    assertNotNull(createdOwner.getAddress());
    assertNotNull(createdOwner.getName());
    assertNotNull(createdOwner.getOwnerId());

  }

  @Test
  public void testGetOwnerById() {
    doReturn(Optional.of(ownerToBeRetrieved)).when(repository).findById(ownerId);
    Optional<VehicleOwner> foundOwner = service.getOwnerById(ownerId);
    assertNotNull(foundOwner);
    assertNotNull(foundOwner.get().getAddress());
    assertNotNull(foundOwner.get().getName());
    assertNotNull(foundOwner.get().getOwnerId());
  }

}
