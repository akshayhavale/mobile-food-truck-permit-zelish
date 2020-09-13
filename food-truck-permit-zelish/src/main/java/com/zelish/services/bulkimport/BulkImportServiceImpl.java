package com.zelish.services.bulkimport;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.zelish.services.FileAdapter;

@Service
public class BulkImportServiceImpl implements BulkImportService, ServletContextAware {

	private ServletContext servletContext;

	@Override
	public void importFile(MultipartFile file) {
		FileAdapter adaptor = new FileAdapter();
		try {
			adaptor.importFile(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void saveFile(MultipartFile file) {

		try {

			byte[] bytes = file.getBytes();
			System.out.println(bytes);
			Path path = Paths.get(this.servletContext.getRealPath("/files/" + file.getOriginalFilename()));
			String p = path.toString();
			System.out.println(p);
			
			
			Files.write(path, bytes);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

}
