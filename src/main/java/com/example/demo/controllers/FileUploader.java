package com.example.demo.controllers;

import javax.servlet.Servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class FileUploader {
	 
	@Autowired
	private FileUploadHelper fileUploadHelper;

	@PostMapping("/uploadFile")
	public ResponseEntity<String> uploadFile(@RequestParam("file")MultipartFile multipartFile){
		

		try {
			
		Boolean f =		fileUploadHelper.uploadFile(multipartFile);
		
		if(f) {
			//return ResponseEntity.ok("fiLE SUCCESFULLY UPLOADED");
			
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image").path(multipartFile.getOriginalFilename()).toUriString());
		}
									//gives us contecxt 							path
			
		} catch (Exception e) {
			
				
			// TODO: handle exception
		}
		
		
		
		
		return ResponseEntity.ok("working");
		
		
		
		
	}
}
