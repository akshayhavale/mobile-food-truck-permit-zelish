package com.zelish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zelish.services.bulkimport.BulkImportService;

import io.swagger.annotations.Api;
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

	@PostMapping(value = "/upload/file")
	public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) {
		try {

			bulkImportService.saveFile(file);

			bulkImportService.importFile(file);

			return new ResponseEntity<Void>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		}

	}

}
