package com.example.project.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import com.example.project.domain.Product;
import com.example.project.service.ProductService;
import com.example.project.service.UploadService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private UploadService uploadService;

	private final String fileBasePath = "C:/src/realSpringBoot/img/";

	@GetMapping(value = "/list")
	public ResponseEntity<List<Product>> list() {
		return ResponseEntity.ok(productService.list());
	}

	@PutMapping("/upload/db/{id}")
	public ResponseEntity<Product> uploadToDB(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			

		Product p = productService.uploadImage(id, uploadService.upload(file, fileName, fileBasePath));
		// String fileDownloadUri =
		// ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/download/")
		// .path(fileName).path("/db").toUriString();
		return ResponseEntity.ok(p);
	}

	@GetMapping("/download/{id}")
	public ResponseEntity<Resource> downloadFileFromLocal(@PathVariable Integer id) {
		Product p = productService.findById(id);


		Path path = Paths.get(fileBasePath + p.getImagemName());
		Resource resource = null;
		try {
			resource = new UrlResource(path.toUri());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}

	@PostMapping("/update")
	public ResponseEntity<List<Product>> updateFromXLS(@RequestParam("file") MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			
		// String fileDownloadUri =
		// ServletUriComponentsBuilder.fromCurrentContextPath().path("/files/download/")
		// .path(fileName).path("/db").toUriString();
		return ResponseEntity.ok(productService.postFromXLS());
	}

}