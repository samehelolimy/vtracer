package com.alten.trial.vtracker.api;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alten.trial.vtracker.entities.Vehicle;
import com.alten.trial.vtracker.exceptions.ResourceNotFoundException;
import com.alten.trial.vtracker.services.VehicleStatusService;
import com.alten.trial.vtracker.services.VehiclesService;

@RestController
@RequestMapping("/status")
public class VehicleStatusController {

  @Autowired
  private VehicleStatusService vehicleStatusService;
  @Autowired
  private VehiclesService vehicleService;

  @GetMapping(path = "/{vehicleId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody String getVehicleStatus(@PathVariable("vehicleId") String vehicleId) {

    Optional<Vehicle> vehicle = vehicleService.getVehicle(vehicleId);

    if (!vehicle.isPresent()) {
      throw new ResourceNotFoundException("vehicle not found");
    }

    return this.vehicleStatusService.getVehicleStatus(vehicleId).getStatusValue();
  }
}
