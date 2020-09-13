package com.zelish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zelish.exceptions.ExceptionHandling;
import com.zelish.model.FoodTruck;
import com.zelish.repository.FoodTruckRepository;
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
	private BulkImportService bulkImportService;

	@Autowired
	private FoodTruckRepository repo;

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

	@PostMapping("/create")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(httpMethod = "POST", value = "Add Details, This will create new Food Truck Permit Detail", produces = "application/json", response = FoodTruck.class)
	public @ResponseBody FoodTruck createEmployee(@RequestBody FoodTruck foodTruck) throws ExceptionHandling {
		try {
			FoodTruck ft = repo.save(foodTruck);
			if (ft == null) {
				throw new Exception("Wrong Input");
			} else {
				return ft;
			}
		} catch (Exception e) {
			throw new ExceptionHandling("Wrong Datas Input");
		}
	}

}
