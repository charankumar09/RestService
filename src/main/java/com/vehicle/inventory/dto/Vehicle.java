package com.vehicle.inventory.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Vehicle")
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;

	@Column
	private String vehicleType;

	@Column
	private String fuelType;

	@Column
	private int manufacturedYear;

	@Column
	private int registratoinNumber;

	@Column
	private double mileage;

	@Column
	private double engineCapacity;

	@Column
	private double price;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public int getManufacturedYear() {
		return manufacturedYear;
	}

	public void setManufacturedYear(int manufacturedYear) {
		this.manufacturedYear = manufacturedYear;
	}

	public int getRegistratoinNumber() {
		return registratoinNumber;
	}

	public void setRegistratoinNumber(int registratoinNumber) {
		this.registratoinNumber = registratoinNumber;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public double getEngineCapacity() {
		return engineCapacity;
	}

	public void setEngineCapacity(double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
