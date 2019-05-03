package com.andrevitoria.sgm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrevitoria.sgm.domain.Contract;
import com.andrevitoria.sgm.repositories.ContractRepository;
import com.andrevitoria.sgm.services.exceptions.ObjectNotFoundException;

@Service
public class ContractService {
	@Autowired
	private ContractRepository repo;

	public Contract buscar(String id) {
		Optional<Contract> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrato! Id:" + id + ", Tipo: " + Contract.class.getName()));
	}
	
	public Contract find(String id) {
		Optional<Contract> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrato! Id:" + id + ", Tipo: " + Contract.class.getName()));
	}
}
