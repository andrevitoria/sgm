package com.andrevitoria.sgm.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrevitoria.sgm.domain.Document;
import com.andrevitoria.sgm.repositories.DocumentRepository;
import com.andrevitoria.sgm.services.exceptions.ObjectNotFoundException;

@Service
public class DocumentService {
	@Autowired
	private DocumentRepository repo;

	public Document buscar(Integer id) {
		Optional<Document> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrato! Id:" + id + ", Tipo: " + Document.class.getName()));
	}
}
