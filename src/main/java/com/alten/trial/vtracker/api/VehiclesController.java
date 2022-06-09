package com.alten.trial.vtracker.api;

import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alten.trial.vtracker.entities.Vehicle;
import com.alten.trial.vtracker.entities.VehicleOwner;
import com.alten.trial.vtracker.entities.enums.Status;
import com.alten.trial.vtracker.exceptions.InvalidOwnerException;
import com.alten.trial.vtracker.exceptions.InvalidStatusException;
import com.alten.trial.vtracker.exceptions.ResourceNotFoundException;
import com.alten.trial.vtracker.services.VehicleOwnersService;
import com.alten.trial.vtracker.services.VehiclesService;

@RestController
@RequestMapping("/vehicles")
public class VehiclesController {

  private final VehiclesService vehiclesService;
  private final VehicleOwnersService vehicleOwnersService;

  public VehiclesController(VehiclesService vehiclesService,
      VehicleOwnersService vehicleOwnersService) {
    this.vehiclesService = vehiclesService;
    this.vehicleOwnersService = vehicleOwnersService;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody Vehicle createNewVehicle(@RequestBody Vehicle vehicle) {

    // validating owner
    if (vehicle.getVehicleOwner() == null) {
      throw new InvalidOwnerException("Vehicle owner is required");
    }
    Optional<VehicleOwner> owner =
        vehicleOwnersService.getOwnerById(vehicle.getVehicleOwner().getOwnerId());
    if (!owner.isPresent()) {
      throw new ResourceNotFoundException("Owner not registered");
    }

    return this.vehiclesService.createNewVehicle(vehicle);
  }

  @GetMapping(path = "/{vehicleId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody Vehicle getVehicleById(@PathVariable("vehicleId") String vehicleId) {
    Optional<Vehicle> vehicle = this.vehiclesService.getVehicle(vehicleId);
    if (!vehicle.isPresent()) {
      throw new ResourceNotFoundException("vehicle not found");
    }
    return vehicle.get();

  }

  @GetMapping(path = "/{status}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody List<Vehicle> getVehiclesByStatus(@PathVariable("status") String status) {

    // validate status
    if (!Status.values()[0].getStatusValue().equals(status)
        && !Status.values()[0].getStatusValue().equals(status)) {
      throw new InvalidStatusException("invalid status was provided");

    }

    List<Vehicle> vehicles = this.vehiclesService.getVehiclesByStatus(status);
    return vehicles;
  }

  @GetMapping(path = "/{ownerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody List<Vehicle> getVehiclesByOwner(@PathVariable("ownerId") Long ownerId) {

    // validate owner
    Optional<VehicleOwner> owner = vehicleOwnersService.getOwnerById(ownerId);

    if (!owner.isPresent()) {
      throw new ResourceNotFoundException("owner not found");
    }

    List<Vehicle> vehicles = this.vehiclesService.getVehiclesByOwner(ownerId);
    return vehicles;
  }

}
