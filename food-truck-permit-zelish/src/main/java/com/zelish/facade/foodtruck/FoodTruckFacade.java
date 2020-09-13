package com.zelish.facade.foodtruck;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zelish.populator.PersistableFoodTruck;
import com.zelish.populator.ReadableFoodTruck;

@Service
public interface FoodTruckFacade {
	
	public ReadableFoodTruck create(PersistableFoodTruck persistableFoodTruck);
	
	public ReadableFoodTruck update(PersistableFoodTruck persistableFoodTruck, long id);
	
	public ReadableFoodTruck getOne(long id);
	
	public List<ReadableFoodTruck> getAll();
	
	public void deleteByid(long id);
	
	public List<ReadableFoodTruck> getByApplicant(String applicant);
	
	public List<ReadableFoodTruck> getByFacilityType(String facilityType);
	
	public List<ReadableFoodTruck> getByStatus(String status);
	
	public List<ReadableFoodTruck> getExpiredLicence(String expired);

}
