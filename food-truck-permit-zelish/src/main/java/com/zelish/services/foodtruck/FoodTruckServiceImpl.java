package com.zelish.services.foodtruck;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zelish.model.FoodTruck;
import com.zelish.repository.FoodTruckRepository;
import com.zelish.util.FoodTruckMapper;

@Service
public class FoodTruckServiceImpl implements FoodTruckService {

	@Autowired
	private FoodTruckRepository repository;

	@Override
	public FoodTruck create(FoodTruck foodTruck) {
		return repository.save(foodTruck);
	}

	@Override
	public FoodTruck update(FoodTruck source, long id) {

		FoodTruck target = repository.findById(id).get();
		FoodTruckMapper mapper = new FoodTruckMapper();

		FoodTruck saveEntity = mapper.map(source, target);
		return repository.save(saveEntity);
	}

	@Override
	public FoodTruck getById(long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<FoodTruck> getAll() {
		return repository.findAll();
	}

	@Override
	public void delete(long id) {

		repository.deleteById(id);

	}

	@Override
	public List<FoodTruck> getByApplicant(String applicant) {

		return repository.findByApplicant(applicant);
	}

	@Override
	public List<FoodTruck> getByFacilityType(String facilityType) {
		return repository.findByFacilityType(facilityType);
	}

	@Override
	public List<FoodTruck> getByStatus(String status) {
		return repository.findByStatus(status);
	}

}
