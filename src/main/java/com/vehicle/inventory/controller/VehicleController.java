package com.vehicle.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.vehicle.inventory.dto.Vehicle;
import com.vehicle.inventory.exception.VehicleNotFoundException;
import com.vehicle.inventory.service.VehicleService;

@RestController("/vehicle")

public class VehicleController {

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public ResponseEntity<Void> newVehicle(@RequestBody Vehicle vehicle, UriComponentsBuilder ucb) {

		vehicleService.addVehicle(vehicle);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vehicle> getVehicle(@PathVariable("id") int id) {

		Vehicle vehicle = vehicleService.readVehicle(id);
		if (vehicle == null) {
			throw new VehicleNotFoundException("Not found");
		}
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Vehicle> updateVehicle(@PathVariable("id") int id, @RequestBody Vehicle v) {

		Vehicle vehicle = vehicleService.readVehicle(id);

		if (vehicle == null) {
			throw new VehicleNotFoundException("Not found");
		}

		vehicleService.updateVehicle(vehicle);
		return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Vehicle>> listAllVehicles() {
		List<Vehicle> vehicles = vehicleService.findAllVehicles();
		if (vehicles.isEmpty()) {
			return new ResponseEntity<List<Vehicle>>(HttpStatus.OK);
		}
		return new ResponseEntity<List<Vehicle>>(vehicles, HttpStatus.OK);
	}

	@RequestMapping(value = "/last", method = RequestMethod.DELETE)
	public ResponseEntity<Vehicle> deleteLastVehicle() {

		Vehicle vehicle = vehicleService.findLastAddedVehicle();
		if (vehicle == null) {
			throw new VehicleNotFoundException("Not found");
		}

		vehicleService.removeVehicle(vehicle);
		return new ResponseEntity<Vehicle>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Vehicle> deleteVehicle(@PathVariable("id") int id) {

		Vehicle vehicle = vehicleService.readVehicle(id);
		if (vehicle == null) {
			throw new VehicleNotFoundException("Not found");
		}

		vehicleService.removeVehicle(vehicle);
		return new ResponseEntity<Vehicle>(HttpStatus.OK);
	}


}
