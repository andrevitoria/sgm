package com.andrevitoria.sgm.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.andrevitoria.sgm.domain.Contract;
import com.andrevitoria.sgm.services.ContractService;

@RestController
@RequestMapping(value = "/contracts")
public class ContractResource {
	@Autowired
	private ContractService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contract> find(@PathVariable String id) {
		Contract obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
}
