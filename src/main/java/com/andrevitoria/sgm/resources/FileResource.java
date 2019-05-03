package com.andrevitoria.sgm.resources;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andrevitoria.sgm.domain.DBFile;
import com.andrevitoria.sgm.domain.dto.TesteDto;
import com.andrevitoria.sgm.domain.dto.UploadFileResponseDto;
import com.andrevitoria.sgm.services.DBFileStorageService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class FileResource {
	@Autowired
	private DBFileStorageService DBFileStorageService;

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public UploadFileResponseDto uploadFile(@RequestParam("teste") String obj,
			@RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, IOException {
		DBFile dbFile = DBFileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(dbFile.getId()).toUriString();
		TesteDto teste = new ObjectMapper().readValue(obj, TesteDto.class);
		return new UploadFileResponseDto(teste.getNome(), fileDownloadUri, file.getContentType(), file.getSize());
	}

	@RequestMapping(value = "/downloadFile/{fileId}", method = RequestMethod.GET)
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) {
		// Load file from database
		DBFile dbFile = DBFileStorageService.getFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(dbFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + dbFile.getFileName() + "\"")
				.body(new ByteArrayResource(dbFile.getData()));
	}
}
