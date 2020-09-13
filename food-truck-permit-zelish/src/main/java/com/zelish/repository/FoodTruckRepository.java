package com.zelish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zelish.model.FoodTruck;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {

	List<FoodTruck> findByApplicant(String applicant);

	List<FoodTruck> findByFacilityType(String facilityType);

	List<FoodTruck> findByStatus(String status);

}
