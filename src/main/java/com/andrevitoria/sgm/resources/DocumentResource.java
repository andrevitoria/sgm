package com.andrevitoria.sgm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andrevitoria.sgm.domain.Document;
import com.andrevitoria.sgm.services.DocumentService;

@RestController
@RequestMapping(value = "/documents")
public class DocumentResource {
	@Autowired
	private DocumentService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Document> find(@PathVariable Integer id) {
		Document obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
