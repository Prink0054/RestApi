package com.example.demo.controllers;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component

public class FileUploadHelper {

	public final String UPLOAD_DIR = "/Users/mac/Pictures/WorkSpace demo/RestApi/src/main/resources/static/image";
	
	//public final String UPLOAD_DIR = new ClassPathResource("static/image").getFile().getAbsolutePath();
			
	//public final String UPLOAD_DIR = new ClassPathResource("/static/image").getPath().getAbsolutePath();
	
	FileUploadHelper() throws IOException {
		
	}
	
	
	
	public boolean uploadFile(MultipartFile multipartFile) {
		
		boolean f = false;
		
		try {
//	InputStream is =		multipartFile.getInputStream();
//	byte data[] = new byte[is.available()];
//	is.read(data);
//	
	
	//write
	
//	FileOutputStream fos = new FileOutputStream(UPLOAD_DIR + "/" + multipartFile.getOriginalFilename());
//	fos.write(data);
//	fos.flush();
//	fos.close();
			
			System.out.println(UPLOAD_DIR);
			
	Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR + "/" + multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);		
			
	f = true;
	return f;
	
		} 
		
		catch (Exception e) {

		System.out.println(e);
		f = false;
		return f;
		}
	
	}
	
}
