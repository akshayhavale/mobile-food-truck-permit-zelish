package com.zelish.services.bulkimport;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface BulkImportService {
	
	void importFile(MultipartFile file);

	void saveFile(MultipartFile file);

}
