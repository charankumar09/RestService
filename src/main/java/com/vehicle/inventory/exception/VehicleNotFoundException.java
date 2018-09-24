package com.vehicle.inventory.exception;

public class VehicleNotFoundException extends RuntimeException {

	/**
	* 
	*/
	private static final long serialVersionUID = -8933313009368537739L;

	public VehicleNotFoundException(String exception) {
		super(exception);
	}

}