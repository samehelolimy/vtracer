package com.alten.trial.vtracker.services;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.alten.trial.vtracker.entities.VehicleOwner;
import com.alten.trial.vtracker.repositories.VehicleOwnersRepository;

@Service
public class VehicleOwnersService {

  private VehicleOwnersRepository vehicleOwnersRepository;

  public VehicleOwnersService(VehicleOwnersRepository vehicleOwnersRepository) {

    this.vehicleOwnersRepository = vehicleOwnersRepository;
  }

  public VehicleOwner createNewOwner(VehicleOwner vehicleOwner) {

    return this.vehicleOwnersRepository.save(vehicleOwner);
  }

  public Optional<VehicleOwner> getOwnerById(Long ownerId) {
    return this.vehicleOwnersRepository.findById(ownerId);
  }

}
