package com.andrevitoria.sgm.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.andrevitoria.sgm.domain.DBFile;
import com.andrevitoria.sgm.repositories.DBFileRepository;
import com.andrevitoria.sgm.services.exceptions.ObjectNotFoundException;

@Service
public class DBFileStorageService {
	@Autowired
	private DBFileRepository dbFileRepository;

	public DBFile storeFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());

		try {
			// Check if the file's name contains invalid characters
			if (fileName.contains("..")) {
				throw new ObjectNotFoundException("Sorry! Filename contains invalid path sequence " + fileName);
			}

			DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

			return dbFileRepository.save(dbFile);
		} catch (Exception e) {
			throw new ObjectNotFoundException("Could not store file " + fileName + ". Please try again!");
		}
	}

	public DBFile getFile(String fileId) {
		return dbFileRepository.findById(fileId)
				.orElseThrow(() -> new ObjectNotFoundException("File not found with id " + fileId));
	}
}
