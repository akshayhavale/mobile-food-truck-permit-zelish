package com.zelish.populator;

import java.util.List;

public class ReadableFoodTruckList {
	
	private long count;
	
	private List<ReadableFoodTruck> foodTrucks;

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<ReadableFoodTruck> getFoodTrucks() {
		return foodTrucks;
	}

	public void setFoodTrucks(List<ReadableFoodTruck> readableFoodTrucks) {
		this.foodTrucks = readableFoodTrucks;
	}
	
	
}
