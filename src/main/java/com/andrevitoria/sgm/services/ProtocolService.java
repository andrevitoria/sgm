package com.andrevitoria.sgm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrevitoria.sgm.domain.Protocol;
import com.andrevitoria.sgm.repositories.ProtocolRepository;
import com.andrevitoria.sgm.services.exceptions.ObjectNotFoundException;

@Service
public class ProtocolService {
	@Autowired
	private ProtocolRepository repo;

	public Protocol find(String id) {
		Optional<Protocol> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrato! Id:" + id + ", Tipo: " + Protocol.class.getName()));
	}
}
