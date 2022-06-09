package com.alten.trial.vtracker.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.alten.trial.vtracker.entities.Vehicle;
import com.alten.trial.vtracker.repositories.VehiclesRepository;

@Service
public class VehiclesService {

  private VehiclesRepository vehiclesRepository;

  public VehiclesService(VehiclesRepository vehiclesRepository) {

    this.vehiclesRepository = vehiclesRepository;
  }

  public Vehicle createNewVehicle(Vehicle vehicle) {
    return this.vehiclesRepository.save(vehicle);
  }

  public Optional<Vehicle> getVehicle(String vehicleId) {
    return this.vehiclesRepository.findById(vehicleId);
  }

  public List<Vehicle> getVehiclesByStatus(String status) {
    return this.vehiclesRepository.findAllByStatus(status);

  }

  public List<Vehicle> getVehiclesByOwner(Long ownerId) {
    return this.vehiclesRepository.findAllByVehicleOwnerId(ownerId);
  }

  public List<Vehicle> getAllVehicles() {

    return this.vehiclesRepository.findAll();
  }

}
