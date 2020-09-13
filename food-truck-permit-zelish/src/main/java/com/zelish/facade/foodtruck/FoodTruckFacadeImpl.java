package com.zelish.facade.foodtruck;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zelish.model.FoodTruck;
import com.zelish.populator.PersistableFoodTruck;
import com.zelish.populator.PersistableFoodTruckPopulator;
import com.zelish.populator.ReadableFoodTruck;
import com.zelish.populator.ReadableFoodTruckPopulator;
import com.zelish.services.foodtruck.FoodTruckService;
import com.zelish.util.FoodTruckMapper;

@Service
public class FoodTruckFacadeImpl implements FoodTruckFacade {

	@Autowired
	private FoodTruckService service;

	@Override
	public ReadableFoodTruck create(PersistableFoodTruck source) {
		FoodTruck target = new FoodTruck();
		PersistableFoodTruckPopulator populator = new PersistableFoodTruckPopulator();
		target = populator.populate(source, target);
		FoodTruck foodTruck = service.create(target);
		ReadableFoodTruckPopulator rePopulator = new ReadableFoodTruckPopulator();
		ReadableFoodTruck readableFoodTruck = new ReadableFoodTruck();
		return rePopulator.populate(foodTruck, readableFoodTruck);
	}

	@Override
	public ReadableFoodTruck update(PersistableFoodTruck source, long id) {

		FoodTruck target = new FoodTruck();
		PersistableFoodTruckPopulator populator = new PersistableFoodTruckPopulator();
		target = populator.populate(source, target);
		FoodTruck foodTruck = service.update(target, id);
		ReadableFoodTruck readableFoodTruck = new ReadableFoodTruck();
		ReadableFoodTruckPopulator rePopulator = new ReadableFoodTruckPopulator();
		return rePopulator.populate(foodTruck, readableFoodTruck);
	}

	@Override
	public ReadableFoodTruck getOne(long id) {

		FoodTruck source = service.getById(id);
		ReadableFoodTruck target = new ReadableFoodTruck();
		ReadableFoodTruckPopulator populator = new ReadableFoodTruckPopulator();
		return populator.populate(source, target);
	}

	@Override
	public List<ReadableFoodTruck> getAll() {

		List<FoodTruck> source = service.getAll();
		List<ReadableFoodTruck> target = new ArrayList<ReadableFoodTruck>();

		FoodTruckMapper mapper = new FoodTruckMapper();
		return mapper.listMap(source, target);
	}

	@Override
	public void deleteByid(long id) {

		try {
			service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<ReadableFoodTruck> getByApplicant(String applicant) {

		List<FoodTruck> source = service.getByApplicant(applicant);

		List<ReadableFoodTruck> target = new ArrayList<ReadableFoodTruck>();

		FoodTruckMapper mapper = new FoodTruckMapper();
		return mapper.listMap(source, target);

	}

	@Override
	public List<ReadableFoodTruck> getByFacilityType(String facilityType) {
		
		List<FoodTruck> source = service.getByApplicant(facilityType);

		List<ReadableFoodTruck> target = new ArrayList<ReadableFoodTruck>();

		FoodTruckMapper mapper = new FoodTruckMapper();
		return mapper.listMap(source, target);

	}

	@Override
	public List<ReadableFoodTruck> getByStatus(String status) {
		List<FoodTruck> source = service.getByApplicant(status);

		List<ReadableFoodTruck> target = new ArrayList<ReadableFoodTruck>();

		FoodTruckMapper mapper = new FoodTruckMapper();
		return mapper.listMap(source, target);

	}

	@Override
	public List<ReadableFoodTruck> getExpiredLicence(String expired) {
		
		List<FoodTruck> source = service.getByApplicant("EXPIRED");

		List<ReadableFoodTruck> target = new ArrayList<ReadableFoodTruck>();

		FoodTruckMapper mapper = new FoodTruckMapper();
		return mapper.listMap(source, target);
		
	}

}
