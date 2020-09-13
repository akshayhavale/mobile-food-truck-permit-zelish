package com.zelish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zelish.model.FoodTruck;

@Repository
public interface FoodTruckRepository extends JpaRepository<FoodTruck, Long> {

}
