package com.example.project.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * UploadService
 */
@Service
public class UploadService {

    public String upload(MultipartFile file,String fileName,String fileBasePath){
        
        String fileN = file.getOriginalFilename();
        Path path = Paths.get(fileBasePath + fileN);

		try {
			Files.copy(file.getInputStream(), path);
		} catch (IOException e) {
            throw new RuntimeException();
        }

        return path.getFileName().toString();
        
    }

	public String uploadXls(MultipartFile file, String fileBasePath) {
        String fileN = file.getOriginalFilename();
        Path path = Paths.get(fileBasePath + fileN);

		try {
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
            throw new RuntimeException();
        }

        return path.getFileName().toString();
	}
}