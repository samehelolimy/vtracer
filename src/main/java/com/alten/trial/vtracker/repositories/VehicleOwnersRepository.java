package com.alten.trial.vtracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alten.trial.vtracker.entities.VehicleOwner;

public interface VehicleOwnersRepository extends JpaRepository<VehicleOwner, Long>{

}
