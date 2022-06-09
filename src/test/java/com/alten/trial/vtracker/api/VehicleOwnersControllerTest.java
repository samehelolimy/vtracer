package com.alten.trial.vtracker.api;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.alten.trial.vtracker.entities.VehicleOwner;
import com.alten.trial.vtracker.services.VehicleOwnersService;

public class VehicleOwnersControllerTest {

  private VehicleOwnersController controller;
  private VehicleOwnersService service;

  @BeforeEach
  public void setUp() throws Exception {
    service = mock(VehicleOwnersService.class);
    controller = new VehicleOwnersController(service);
  }

  @Test
  public void testCreateNewVehicleOwner() {
    VehicleOwner owner = new VehicleOwner();
    owner.setName("test owner");
    owner.setOwnerId(22L);
    doReturn(owner).when(service).createNewOwner(owner);
    when(service.getOwnerById(owner.getOwnerId())).thenReturn(null);
    VehicleOwner result = controller.createNewVehicleOwner(owner);
    assertNotNull(result);
  }

  @Test
  public void testGetVehicleOwner() {
    VehicleOwner owner = new VehicleOwner();
    owner.setName("test owner");
    Long ownerId = 17L;
    doReturn(Optional.of(owner)).when(service).getOwnerById(ownerId);
    VehicleOwner result = controller.getVehicleOwner(ownerId);
    assertNotNull(result);
  }

}
