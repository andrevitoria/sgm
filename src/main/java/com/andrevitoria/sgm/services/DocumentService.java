package com.andrevitoria.sgm.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.andrevitoria.sgm.domain.Classification;
import com.andrevitoria.sgm.domain.Document;
import com.andrevitoria.sgm.domain.dto.DocumentDto;
import com.andrevitoria.sgm.repositories.DocumentRepository;
import com.andrevitoria.sgm.services.exceptions.DataIntegrityException;
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

	public Document find(Integer id) {
		Optional<Document> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrato! Id:" + id + ", Tipo: " + Document.class.getName()));
	}

	public List<Document> findAll() {
		return repo.findAll();
	}

	public Document insert(DocumentDto doc) {
		Document docIn = fromDto(doc);
		docIn.setId(null);
		docIn.setCreated(new Date());
		docIn.setModified(new Date());
		return repo.save(docIn);
	}

	public Document update(DocumentDto obj) {
		Document objIn = find(obj.getId());

		objIn.setModified(new Date());
		objIn.setDescription(obj.getDescription());
		if (obj.getActivated() != null) {
			objIn.setActivated(obj.getActivated());
		}
		if (obj.getClassification_id()!=null) {
			Classification cla = new Classification();
			cla.setId(obj.getClassification_id());
			objIn.setClassification(cla);
		}
		return repo.save(objIn);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um documento associado a outros registros!");
		}
	}

	public Document fromDto(DocumentDto dto) {
		Classification cla;
		Document doc;
		if (dto.getClassification_id()!=null) {
			cla = new Classification();
			cla.setId(dto.getClassification_id());
			doc = new Document(dto.getId(), dto.getDescription(), dto.getActivated(), null, null, cla);
		} else {
			doc = new Document(dto.getId(), dto.getDescription(), dto.getActivated(), null, null, null);
		}

		return doc;
	}
}
