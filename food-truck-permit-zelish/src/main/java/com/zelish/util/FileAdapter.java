package com.zelish.util;

import static java.util.Objects.nonNull;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.zelish.model.FoodTruck;
import com.zelish.model.Location;
import com.zelish.populator.PersistableFoodTruck;
import com.zelish.populator.ReadableFoodTruck;
import com.zelish.services.foodtruck.FoodTruckServiceImpl;

@Component
public class FileAdapter {

	private FoodTruckServiceImpl foodTruckService = new FoodTruckServiceImpl();

	private String baseUrl = "http://localhost:8080";

	public void importFile(MultipartFile file) throws IOException, ParseException {

		String file_name = "src/main/webapp/files/" + file.getOriginalFilename();

		System.out.println(file_name);

		CSVFormat format = CSVFormat.EXCEL.withHeader().withDelimiter(',');

		BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(file_name), StandardCharsets.ISO_8859_1));

		CSVParser parser = new CSVParser(in, format);

		int i = 0;

		for (CSVRecord record : parser) {
			System.out.println(record.get("locationid"));
			System.out.println(record.get("Applicant"));
			System.out.println(record.get("FacilityType"));
			System.out.println(record.get("cnn"));
			System.out.println(record.get("LocationDescription"));
			System.out.println(record.get("Address"));
			System.out.println(record.get("blocklot"));
			System.out.println(record.get("block"));
			System.out.println(record.get("lot"));
			System.out.println(record.get("permit"));
			System.out.println(record.get("Status"));
			System.out.println(record.get("FoodItems"));
			System.out.println(record.get("X"));
			System.out.println(record.get("Y"));
			System.out.println(record.get("Latitude"));
			System.out.println(record.get("Longitude"));
			System.out.println(record.get("Schedule"));
			System.out.println(record.get("NOISent"));
			System.out.println(record.get("Approved"));
			System.out.println(record.get("Received"));
			System.out.println(record.get("PriorPermit"));
			System.out.println(record.get("ExpirationDate"));
			System.out.println(record.get("Location"));

			FoodTruck foodTruck = new FoodTruck();
			if (nonNull(record.get("Address")) && !record.get("Address").isEmpty()) {
				foodTruck.setAddress(record.get("Address"));
			} else {
				foodTruck.setAddress("");
			}
			if (nonNull(record.get("Applicant")) && !record.get("Applicant").isEmpty()) {
				foodTruck.setApplicant(record.get("Applicant"));
			} else {
				foodTruck.setApplicant("");
			}
			if (nonNull(record.get("Approved")) && !record.get("Approved").isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date approved = sdf.parse(record.get("Approved"));
				foodTruck.setApproved(approved);
			}
			if (nonNull(record.get("block")) && !record.get("block").isEmpty()) {
				foodTruck.setBlock(record.get("block"));
			} else {
				foodTruck.setBlock("");
			}
			if (nonNull(record.get("blocklot")) && !record.get("blocklot").isEmpty()) {
				foodTruck.setBlocklot(record.get("blocklot"));
			} else {
				foodTruck.setBlocklot("");
			}
			if (nonNull(record.get("cnn")) && !record.get("cnn").isEmpty()) {
				foodTruck.setCnn(Integer.valueOf(record.get("cnn")));
			} else {
				foodTruck.setCnn(0);
			}

			if (nonNull(record.get("ExpirationDate")) && !record.get("ExpirationDate").isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date expirationDate = sdf.parse(record.get("ExpirationDate"));

				foodTruck.setExpirationDate(expirationDate);
			}
			if (nonNull(record.get("FacilityType")) && !record.get("FacilityType").isEmpty()) {
				foodTruck.setFacilityType(record.get("FacilityType"));
			} else {
				foodTruck.setFacilityType("");
			}
			if (nonNull(record.get("FoodItems")) && !record.get("FoodItems").isEmpty()) {
				foodTruck.setFoodItems(record.get("FoodItems"));
			} else {
				foodTruck.setFoodItems("");
			}
			if (nonNull(record.get("Latitude")) && !record.get("Latitude").isEmpty()) {
				foodTruck.setLatitude(Double.valueOf(record.get("Latitude")));
			} else {
				foodTruck.setLatitude(0);
			}
			if (nonNull(record.get("Longitude")) && !record.get("Longitude").isEmpty()) {
				foodTruck.setLongitude(Double.valueOf(record.get("Longitude")));
			} else {
				foodTruck.setLongitude(0);
			}
			if (nonNull(record.get("locationid")) && !record.get("locationid").isEmpty()) {
				foodTruck.setLocationid(Long.valueOf(record.get("locationid")));
			} else {
				foodTruck.setLocationid(0L);
			}
			Location location = new Location();
			location.setType("Point");
			List<Double> coordinates = new ArrayList<Double>();
			coordinates.add(foodTruck.getLongitude());
			coordinates.add(foodTruck.getLatitude());
			location.setCoordinates(coordinates);
			if (nonNull(location)) {
				foodTruck.setLocation(location);
			}
			foodTruck.setLocationDescription(record.get("LocationDescription"));

			foodTruck.setLot(record.get("lot"));
			if (nonNull(record.get("NOISent")) && !record.get("NOISent").isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date noiSent = sdf.parse(record.get("NOISent"));
				foodTruck.setNoiSent(noiSent);
			}
			if (Integer.valueOf(record.get("PriorPermit")) == 0) {
				foodTruck.setPriorPermit(false);
			} else {
				foodTruck.setPriorPermit(true);
			}
			if (nonNull(record.get("Received")) && !record.get("Received").isEmpty()) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date received = sdf.parse(record.get("Received"));
				foodTruck.setReceived(received);
			}
			if (nonNull(record.get("Schedule")) && !record.get("Schedule").isEmpty()) {
				foodTruck.setSchedule(record.get("Schedule"));
			} else {
				foodTruck.setSchedule("");
			}
			if (nonNull(record.get("Status")) && !record.get("Status").isEmpty()) {
				foodTruck.setStatus(record.get("Status"));
			}else {
				foodTruck.setStatus("");
			}
			if (nonNull(record.get("X"))&&!record.get("X").isEmpty()) {
				foodTruck.setX(Double.valueOf(record.get("X")));
			}
			if (nonNull(record.get("Y"))&&!record.get("Y").isEmpty()) {
				foodTruck.setX(Double.valueOf(record.get("Y")));
			}
			foodTruck.setId(0L);
			
			RestTemplate template = new RestTemplate();
			FoodTruck source = foodTruck;
			PersistableFoodTruck target = new PersistableFoodTruck();
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
			
			PersistableFoodTruck entity = target;
			HttpEntity<PersistableFoodTruck> request = new HttpEntity<PersistableFoodTruck>(entity);

			ResponseEntity<ReadableFoodTruck> response = template.postForEntity("http://localhost:8080/api/v1/foodtruck", request, ReadableFoodTruck.class);
			System.out.println(response.getBody().getAddress());


			i++;
		}

	}

}
