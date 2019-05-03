package com.andrevitoria.sgm.resources;

import java.io.IOException;
import java.net.URI;
import java.util.Optional;

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

import com.andrevitoria.sgm.domain.Attachment;
import com.andrevitoria.sgm.domain.dto.AttachmentNewDto;
import com.andrevitoria.sgm.services.AttachmentService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/attachments")
public class AttachmentResource {
	@Autowired
	private AttachmentService service;

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "insere anexos")
	public ResponseEntity<Void> insert(@RequestParam("attachment") String attachmentObj,
			@RequestParam("file") MultipartFile file) throws JsonParseException, JsonMappingException, IOException {
		AttachmentNewDto objDTO = new ObjectMapper().readValue(attachmentObj, AttachmentNewDto.class);

		Attachment objAttachment = service.insert(service.fromDTO(objDTO, file));
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objAttachment.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{AttachmentId}", method = RequestMethod.GET)
	@ApiOperation(value = "download de anexo por Id")
	public ResponseEntity<Resource> download(@PathVariable Integer AttachmentId) {
		Optional<Attachment> objAttachment = service.find(AttachmentId);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(objAttachment.get().getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + objAttachment.get().getFileName() + "\"")
				.body(new ByteArrayResource(objAttachment.get().getData()));
	}

}
