package com.zelish.services.foodtruck;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zelish.model.FoodTruck;

@Service
public class FoodTruckServiceImpl implements FoodTruckService{
	

	@Override
	public FoodTruck create(FoodTruck foodTruck) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodTruck update(FoodTruck foodTruck, long locationid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodTruck getOne(long locationid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodTruck> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long locationid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FoodTruck> getByApplicant(String applicant) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodTruck> getByFacilityType(String facilityType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodTruck> getByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

}
