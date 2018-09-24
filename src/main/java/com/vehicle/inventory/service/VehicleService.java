package com.vehicle.inventory.service;

import java.util.List;

import com.vehicle.inventory.dto.Vehicle;

public interface VehicleService {

	void addVehicle(Vehicle v);

	Vehicle readVehicle(int id);

	void updateVehicle(Vehicle v);

	void removeVehicle(Vehicle v);

	List<Vehicle> findAllVehicles();

	public Vehicle findLastAddedVehicle();

}
