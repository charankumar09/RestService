package com.vehicle.inventory.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehicle.inventory.dao.GenericDao;
import com.vehicle.inventory.dto.Vehicle;
import com.vehicle.inventory.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private GenericDao vehicleDao;

	@Override
	public void addVehicle(Vehicle vehicle) {

		vehicleDao.persist(vehicle);

	}

	@Override
	public Vehicle readVehicle(int id) {

		return (Vehicle) vehicleDao.read(Vehicle.class, id);
	}

	@Override
	public void updateVehicle(Vehicle v) {

		vehicleDao.merge(v);

	}

	@Override
	public void removeVehicle(Vehicle vehicle) {

		vehicleDao.remove(vehicle);

	}

	@Override
	public List<Vehicle> findAllVehicles() {

		return vehicleDao.customSelect("From Vehicle");

	}

	@Override
	public Vehicle findLastAddedVehicle() {

		List<Vehicle> vehicles = vehicleDao.customSelect("From Vehicle order by id desc");

		if (vehicles.size() > 0)
			return vehicles.get(0);
		else
			return null;
	}



}