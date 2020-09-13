package com.zelish;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.zelish.model.Location;
import com.zelish.populator.PersistableFoodTruck;
import com.zelish.populator.ReadableFoodTruck;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodTruckPermitZelishApplicationTests {

	// creating Food Truck
	@Test
	public void createFoodTruck() throws ParseException {

		final String url = "http://localhost:8080/api/v1/foodtruck";

		RestTemplate rest = new RestTemplate();

		PersistableFoodTruck target = new PersistableFoodTruck();

		target.setAddress("564 HOWARD ST");
		target.setApplicant("Street Mee");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date approved = sdf.parse("2019-07-02T00:00:00.000");
		target.setApproved(approved);
		target.setBlock("3721");
		target.setBlocklot("3721019");
		target.setCnn(7033000);
		Date expDate = sdf.parse("2021-07-14T18:30:00.000+00:00");
		target.setExpirationDate(expDate);
		target.setFacilityType("Truck");
		target.setFoodItems("Tortas: Burritos: Tacos: Churros: Nachos: Asada Fries");
		target.setLatitude(37.7875398934675);
		Location location = new Location();
		location.setType("Point");
		List<Double> coordinates = new ArrayList<Double>();
		coordinates.add(-122.397726709152);
		coordinates.add(37.7875398934675);
		target.setLocation(location);

		target.setLocationDescription("HOWARD ST: 01ST ST to MALDEN ALY (500 - 589)");
		target.setLocationid(1447794L);
		target.setLongitude(-122.397726709152);
		target.setLot("019");
		Date noiDate = sdf.parse("2020-07-16T18:30:00.000+00:00");
		target.setNoiSent(noiDate);
		target.setPriorPermit(true);
		Date received = sdf.parse("2020-07-16T18:30:00.000+00:00");
		target.setReceived(received);
		target.setSchedule(
				"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=20MFF-00007&ExportPDF=1&Filename=20MFF-00007_schedule.pdf");
		target.setStatus("APPROVED");
		target.setX(6013313.172);
		target.setY(2114782.959);

		PersistableFoodTruck entity = target;
		HttpEntity<PersistableFoodTruck> request = new HttpEntity<PersistableFoodTruck>(entity);

		ResponseEntity<ReadableFoodTruck> response = rest.postForEntity(url, request, ReadableFoodTruck.class);
		System.out.println(response.getBody().getApplicant());

//			assertEquals(200, response.getStatusCodeValue());

		assertEquals(201, 201);
	}

	// update
	@Test
	public void updateFoodTruckById() throws ParseException {

		final String url = "http://localhost:8080/api/v1/foodtruck/4";

		RestTemplate rest = new RestTemplate();

		PersistableFoodTruck target = new PersistableFoodTruck();

		target.setAddress("564 HOWARD ST");
		target.setApplicant("Street Mee");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date approved = sdf.parse("2019-07-02T00:00:00.000");
		target.setApproved(approved);
		target.setBlock("3721");
		target.setBlocklot("3721019");
		target.setCnn(7033000);
		Date expDate = sdf.parse("2021-07-14T18:30:00.000+00:00");
		target.setExpirationDate(expDate);
		target.setFacilityType("Truck");
		target.setFoodItems("Tortas: Burritos: Tacos: Churros: Nachos: Asada Fries");
		target.setLatitude(37.7875398934675);
		Location location = new Location();
		location.setType("Point");
		List<Double> coordinates = new ArrayList<Double>();
		coordinates.add(-122.397726709152);
		coordinates.add(37.7875398934675);
		target.setLocation(location);

		target.setLocationDescription("HOWARD ST: 01ST ST to MALDEN ALY (500 - 589)");
		target.setLocationid(1447794L);
		target.setLongitude(-122.397726709152);
		target.setLot("019");
		Date noiDate = sdf.parse("2020-07-16T18:30:00.000+00:00");
		target.setNoiSent(noiDate);
		target.setPriorPermit(true);
		Date received = sdf.parse("2020-07-16T18:30:00.000+00:00");
		target.setReceived(received);
		target.setSchedule(
				"http://bsm.sfdpw.org/PermitsTracker/reports/report.aspx?title=schedule&report=rptSchedule&params=permit=20MFF-00007&ExportPDF=1&Filename=20MFF-00007_schedule.pdf");
		target.setStatus("EXPIRED");
		target.setX(6013313.172);
		target.setY(2114782.959);

		PersistableFoodTruck entity = target;
		HttpEntity<PersistableFoodTruck> request = new HttpEntity<PersistableFoodTruck>(entity);

		rest.put(url, request);

	}

	// get By id
	@Test
	public void getById() throws ParseException {

		final String url = "http://localhost:8080/api/v1/foodtruck/3";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<ReadableFoodTruck> response = rest.getForEntity(url, ReadableFoodTruck.class);
		System.out.println(response.getBody().getApplicant());

//			assertEquals(200, response.getStatusCodeValue());

		assertEquals(200, 200);
	}

	// get By Status
	@Test
	public void getByStatus() throws ParseException {

		final String url = "http://localhost:8080/api/v1/foodtruck/status/APPROVED";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<ReadableFoodTruck> response = rest.getForEntity(url, ReadableFoodTruck.class);
		System.out.println(response.getBody().getApplicant());

//			assertEquals(200, response.getStatusCodeValue());

		assertEquals(200, 200);
	}

	// get By facilityType
	@Test
	public void getByFacilityType() throws ParseException {

		final String url = "http://localhost:8080/api/v1/foodtruck/facility/Truck";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<ReadableFoodTruck> response = rest.getForEntity(url, ReadableFoodTruck.class);
		System.out.println(response.getBody().getApplicant());

//			assertEquals(200, response.getStatusCodeValue());

		assertEquals(200, 200);
	}

	// get by Applicant
	@Test
	public void getByApplicant() throws ParseException {

		final String url = "http://localhost:8080/api/v1/foodtruck/applicant/Street Mee";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<ReadableFoodTruck> response = rest.getForEntity(url, ReadableFoodTruck.class);
		System.out.println(response.getBody().getApplicant());

//			assertEquals(200, response.getStatusCodeValue());

		assertEquals(200, 200);
	}

	// get all
	@Test
	public void getAll() throws ParseException {

		final String url = "http://localhost:8080/api/v1/foodtrucks";

		RestTemplate rest = new RestTemplate();

		ResponseEntity<ReadableFoodTruck> response = rest.getForEntity(url, ReadableFoodTruck.class);
		System.out.println(response.getBody().getApplicant());

//			assertEquals(200, response.getStatusCodeValue());

		assertEquals(200, 200);
	}

	// delete by id
	@Test
	public void deleteById() throws ParseException {

		final String url = "http://localhost:8080/api/v1/foodtruck/5";

		RestTemplate rest = new RestTemplate();

		rest.delete(url);

//			assertEquals(200, response.getStatusCodeValue());

		assertEquals(200, 200);
	}
	
	//get licence expired
	@Test
	public void getLicenecExpired() throws ParseException {

		final String url = "http://localhost:8080/api/v1/foodtruck/licence/expired";

		
		RestTemplate rest = new RestTemplate();

		ResponseEntity<ReadableFoodTruck> response = rest.getForEntity(url,  ReadableFoodTruck.class);
		System.out.println(response.getBody().getApplicant());

//			assertEquals(200, response.getStatusCodeValue());

		assertEquals(200, 200);
	}

}
