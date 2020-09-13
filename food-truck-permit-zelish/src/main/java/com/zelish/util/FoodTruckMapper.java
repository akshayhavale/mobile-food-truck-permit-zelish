package com.zelish.util;

import java.util.List;

import com.zelish.model.FoodTruck;
import com.zelish.populator.ReadableFoodTruck;
import com.zelish.populator.ReadableFoodTruckPopulator;

public class FoodTruckMapper {

	public FoodTruck map(FoodTruck source, FoodTruck target) {
		target.setAddress(source.getAddress());
		target.setApplicant(source.getApplicant());
		target.setApproved(source.getApproved());
		target.setBlock(source.getBlock());
		target.setBlocklot(source.getBlocklot());
		target.setCnn(source.getCnn());
		target.setExpirationDate(source.getExpirationDate());
		target.setFacilityType(source.getFacilityType());
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

	public List<ReadableFoodTruck> listMap(List<FoodTruck> soruceList, List<ReadableFoodTruck> targetList) {

		for (FoodTruck source : soruceList) {
			ReadableFoodTruck target = new ReadableFoodTruck();
			ReadableFoodTruckPopulator populator = new ReadableFoodTruckPopulator();
			target = populator.populate(source, target);

			targetList.add(target);

		}

		return targetList;
	}

}
