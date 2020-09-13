package com.zelish.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileAdapter {

	private String baseUrl = "http://localhost:8080";

	public void importFile(MultipartFile file) throws IOException {

		String file_name = "src/main/webapp/files/" + file.getOriginalFilename();

		System.out.println(file_name);

		CSVFormat format = CSVFormat.EXCEL.withHeader().withDelimiter(',');

		BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(file_name), StandardCharsets.ISO_8859_1));
		
		CSVParser parser = new CSVParser(in, format);
		
		int i =0;
		
		for (CSVRecord record : parser) {
			
			System.out.println(record.get("locationid"));
			i++;
		}


	}

}
