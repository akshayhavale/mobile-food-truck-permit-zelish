package com.zelish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zelish.exceptions.ExceptionHandling;
import com.zelish.exceptions.ResourceNotFoundException;
import com.zelish.facade.foodtruck.FoodTruckFacade;
import com.zelish.populator.PersistableFoodTruck;
import com.zelish.populator.ReadableFoodTruck;
import com.zelish.populator.ReadableFoodTruckList;
import com.zelish.services.bulkimport.BulkImportService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;

@RestController
@RequestMapping("/api/v1")
@Api(tags = { "Food truck licence permit resource (Food Trck Licence Permit Api)" })
@SwaggerDefinition(tags = {
		@Tag(name = "Food truck licence permit resource", description = "Add, edit, update and delete can perform") })
public class FoodTruckController {

	@Autowired
	private FoodTruckFacade foodTruckFacade;

	@Autowired
	private BulkImportService bulkImportService;

	@PostMapping(value = "/upload/file")
	@ApiOperation(httpMethod = "POST", value = "Upload CSV file", notes = "ADD CSV FILE TO BULK UPLOAD DATA")
	public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) {
		try {

			bulkImportService.saveFile(file);

			bulkImportService.importFile(file);

			return new ResponseEntity<Void>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/foodtruck")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(httpMethod = "POST", value = "Add Details, This will create new Food Truck Entity", produces = "application/json", response = ReadableFoodTruck.class)
	public @ResponseBody ReadableFoodTruck createEmployee(@RequestBody PersistableFoodTruck persistableFoodTruck)
			throws ExceptionHandling {
		try {
			ReadableFoodTruck readableFoodTruck = foodTruckFacade.create(persistableFoodTruck);
			if (readableFoodTruck == null) {
				throw new Exception("WRONG INPUT");
			} else {
				return readableFoodTruck;
			}
		} catch (Exception e) {
			throw new ExceptionHandling("WRONG INPUT");
		}
	}
	
	@GetMapping("/foodtruck/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Get Details By id, This will Get Food Truck Entity By ID", produces = "application/json", response = ReadableFoodTruck.class)
	public @ResponseBody ReadableFoodTruck getById(@PathVariable(name = "id") long id) throws ResourceNotFoundException {
		try {
			ReadableFoodTruck readableFoodTruck = foodTruckFacade.getOne(id);
			if (readableFoodTruck == null) {
				throw new ResourceNotFoundException("NOT PROPER ID");
			} else {
				return readableFoodTruck;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NOT PROPER ID");
		}
	}
	
	@PutMapping("/foodtruck/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(httpMethod = "PUT", value = "Update Food Truck Entity, By Id Update The Food Truck Entity", produces = "application/json", response = ReadableFoodTruck.class)
	public @ResponseBody ReadableFoodTruck update(@PathVariable(name = "id") long id,
			@RequestBody PersistableFoodTruck persistableFoodTruck) throws ResourceNotFoundException {
		try {

			ReadableFoodTruck readableFoodTruck = foodTruckFacade.update(persistableFoodTruck, id);
			if (readableFoodTruck == null) {
				throw new ResourceNotFoundException("NOT PROPERLY UPDATED");
			} else {
				return readableFoodTruck;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NOT PROPERLY UPDATED");
		}

	}
	
	@GetMapping("/foodtrucks")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Get all Food Trucks, Get all Food Truck Entities", produces = "application/json", response = ReadableFoodTruckList.class)
	public @ResponseBody ReadableFoodTruckList getAll() throws ResourceNotFoundException {
		try {

			List<ReadableFoodTruck> list = foodTruckFacade.getAll();
			ReadableFoodTruckList readableFoodTruckList = new ReadableFoodTruckList();
			readableFoodTruckList.setCount(list.size());
			readableFoodTruckList.setFoodTrucks(list);
			if (list == null) {
				throw new ResourceNotFoundException("COULD NOT ABLE TO FETCH PROPERLY");
			} else {
				return readableFoodTruckList;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("COULD NOT ABLE TO FETCH PROPERLY");
		}
	}

	@DeleteMapping("/foodtruck/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(httpMethod = "DELETE", value = "Delete Food Trucks, Delete Food Truck Entity By Id", produces = "application/json")
	public void deleteEmployee(@PathVariable(value = "id") long id) {
		foodTruckFacade.deleteByid(id);
	}
	
	@GetMapping("/foodtruck/applicant/{applicant}")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Get Details By Applicant, This will Get Food Truck Entity By Applicant", produces = "application/json", response = ReadableFoodTruckList.class)
	public @ResponseBody ReadableFoodTruckList getByApplicant(@PathVariable(name = "applicant") String applicant) throws ResourceNotFoundException {
		try {
			List<ReadableFoodTruck> list = foodTruckFacade.getByApplicant(applicant);
			ReadableFoodTruckList readableFoodTruckList = new ReadableFoodTruckList();
			readableFoodTruckList.setCount(list.size());
			readableFoodTruckList.setFoodTrucks(list);
			if (list == null) {
				throw new ResourceNotFoundException("NOT PROPER APPLICANT");
			} else {
				return readableFoodTruckList;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NOT PROPER APPLICANT");
		}
	}
	
	@GetMapping("/foodtruck/facility/{facilityType}")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Get Details By facilityType, This will Get Food Truck Entity By facilityType", produces = "application/json", response = ReadableFoodTruckList.class)
	public @ResponseBody ReadableFoodTruckList getByFacility(@PathVariable(name = "facilityType") String facilityType) throws ResourceNotFoundException {
		try {
			List<ReadableFoodTruck> list = foodTruckFacade.getByFacilityType(facilityType);
			ReadableFoodTruckList readableFoodTruckList = new ReadableFoodTruckList();
			readableFoodTruckList.setCount(list.size());
			readableFoodTruckList.setFoodTrucks(list);
			if (list == null) {
				throw new ResourceNotFoundException("NOT PROPER FACILITY TYPE");
			} else {
				return readableFoodTruckList;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NOT PROPER FACILITY TYPE");
		}
	}
	
	@GetMapping("/foodtruck/status/{status}")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Get Details By status, This will Get Food Truck Entity By status", produces = "application/json", response = ReadableFoodTruckList.class)
	public @ResponseBody ReadableFoodTruckList getByStatus(@PathVariable(name = "status") String status) throws ResourceNotFoundException {
		try {
			List<ReadableFoodTruck> list = foodTruckFacade.getByStatus(status);
			ReadableFoodTruckList readableFoodTruckList = new ReadableFoodTruckList();
			readableFoodTruckList.setCount(list.size());
			readableFoodTruckList.setFoodTrucks(list);
			if (list == null) {
				throw new ResourceNotFoundException("NOT PROPER STATUS");
			} else {
				return readableFoodTruckList;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NOT PROPER STATUS");
		}
	}

	@GetMapping("/foodtruck/licence/expired")
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Get Food Trucks Licence Expired, This will Get Food Truck Entity Licence Expired", produces = "application/json", response = ReadableFoodTruckList.class)
	public @ResponseBody ReadableFoodTruckList getLicenceExpired() throws ResourceNotFoundException {
		try {
			List<ReadableFoodTruck> list = foodTruckFacade.getExpiredLicence();
			ReadableFoodTruckList readableFoodTruckList = new ReadableFoodTruckList();
			readableFoodTruckList.setCount(list.size());
			readableFoodTruckList.setFoodTrucks(list);
			if (list == null) {
				throw new ResourceNotFoundException("NOT PROPERLY FETCHED");
			} else {
				return readableFoodTruckList;
			}
		} catch (Exception e) {
			throw new ResourceNotFoundException("NOT PROPERLY FETCHED");
		}
	}
}
