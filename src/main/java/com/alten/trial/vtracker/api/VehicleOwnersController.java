package com.alten.trial.vtracker.api;

import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.alten.trial.vtracker.entities.VehicleOwner;
import com.alten.trial.vtracker.exceptions.InvalidOwnerException;
import com.alten.trial.vtracker.services.VehicleOwnersService;

@RestController
@RequestMapping("/vehicle-owner")
public class VehicleOwnersController {

  private VehicleOwnersService vehicleOwnersService;

  public VehicleOwnersController(VehicleOwnersService vehicleOwnersService) {

    this.vehicleOwnersService = vehicleOwnersService;
  }

  @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody VehicleOwner createNewVehicleOwner(@RequestBody VehicleOwner vehicleOwner) {

    if (vehicleOwner.getOwnerId() == null) {
      throw new InvalidOwnerException("owner id is missing or invalid");
    }
    if (vehicleOwnersService.getOwnerById(vehicleOwner.getOwnerId()) != null) {
      throw new InvalidOwnerException("owner id already registered");
    }

    return this.vehicleOwnersService.createNewOwner(vehicleOwner);
  }

  @GetMapping(path = "/{ownerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public @ResponseBody VehicleOwner getVehicleOwner(@PathVariable("ownerId") Long ownerId) {
    Optional<VehicleOwner> vehicleOwner = this.vehicleOwnersService.getOwnerById(ownerId);
    return vehicleOwner.get();
  }

}
