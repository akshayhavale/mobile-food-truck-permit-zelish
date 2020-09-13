package com.zelish.services.foodtruck;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zelish.model.FoodTruck;

@Service
public interface FoodTruckService {
	// create
	public FoodTruck create(FoodTruck foodTruck);

	// update
	public FoodTruck update(FoodTruck foodTruck, long locationid);

	// get by locationid
	public FoodTruck getOne(long locationid);

	// get all
	public List<FoodTruck> getAll();

	// delete by locationid
	public void delete(long locationid);

	// get by applicant
	public List<FoodTruck> getByApplicant(String applicant);

	// get by facilityType
	public List<FoodTruck> getByFacilityType(String facilityType);

	// get by status
	public List<FoodTruck> getByStatus(String status);
	
	

}
