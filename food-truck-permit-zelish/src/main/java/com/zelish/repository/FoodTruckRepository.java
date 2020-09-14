package com.zelish.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zelish.model.FoodTruck;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {

	@Query("select f from FoodTruck f where applicant like %?1%")
	List<FoodTruck> findByApplicant(String applicant);
	@Query("select f from FoodTruck f where facilityType like %?1%")
	List<FoodTruck> findByFacilityType(String facilityType);
	@Query("select f from FoodTruck f where status like %?1%")
	List<FoodTruck> findByStatus(String status);

}
