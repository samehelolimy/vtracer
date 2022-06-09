package com.alten.trial.vtracker.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.alten.trial.vtracker.entities.Vehicle;

public interface VehiclesRepository extends JpaRepository<Vehicle, String> {
  List<Vehicle> findAllByStatus(String status);
  List<Vehicle> findAllByVehicleOwnerId(Long ownerId);

}
