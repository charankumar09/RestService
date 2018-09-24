package com.vehicle.inventory.dao;

import java.util.List;

import com.vehicle.inventory.dto.Vehicle;

public interface GenericDao {

	public Object read(Class<?> cls, int id);

	public void persist(Object enObj);

	public void merge(Object obj);

	public void remove(Object obj);

	public List<Vehicle> customSelect(String query);

	public void deleteByQuery(String query);

}
