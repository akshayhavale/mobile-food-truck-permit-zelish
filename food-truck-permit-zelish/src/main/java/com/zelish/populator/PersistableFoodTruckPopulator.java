package com.zelish.populator;

import com.zelish.model.FoodTruck;

public class PersistableFoodTruckPopulator {
	
	
	public FoodTruck populate(PersistableFoodTruck source, FoodTruck target) {
		target.setAddress(source.getAddress());
		target.setApplicant(source.getApplicant());
		target.setApproved(source.getApproved());
		target.setBlock(source.getBlock());
		target.setBlocklot(source.getBlocklot());
		target.setCnn(source.getCnn());
		target.setExpirationDate(source.getExpirationDate());
		target.setFacultyType(source.getFacultyType());
		target.setFoodItems(source.getFoodItems());
		target.setLatitude(source.getLatitude());
		target.setLocation(source.getLocation());
		target.setLocationDescription(source.getLocationDescription());
		target.setLocationid(source.getLocationid());
		target.setLongitude(source.getLongitude());
		target.setLot(source.getLot());
		target.setNoiSent(source.getNoiSent());
		target.setPriorPermit(source.isPriorPermit());
		target.setReceived(source.getReceived());
		target.setSchedule(source.getSchedule());
		target.setStatus(source.getStatus());
		target.setX(source.getX());
		target.setY(source.getY());
		
		return target;
	}

}
