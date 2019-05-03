package com.andrevitoria.sgm.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.andrevitoria.sgm.domain.Document;
import com.andrevitoria.sgm.domain.dto.DocumentDto;
import com.andrevitoria.sgm.services.DocumentService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/documents")
public class DocumentResource {
	@Autowired
	private DocumentService documentService;

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "retorna documentos")
	public ResponseEntity<List<Document>> listAll() {
		// List<CategoriaDTO> listDto = list.stream().map(obj -> new
		// CategoriaDTO(obj)).collect(Collectors.toList());
		// https://github.com/acenelio/springboot2-ionic-backend/blob/master/src/main/java/com/nelioalves/cursomc/resources/CategoriaResource.java
		List<Document> list = documentService.findAll();
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "retorna documento por id")
	public ResponseEntity<Document> find(@PathVariable Integer id) {
		Document obj = documentService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "insere documento")
	public ResponseEntity<Void> insert(@Valid @RequestBody DocumentDto document) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(documentService.insert(document).getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "atualiza documento")
	public ResponseEntity<Void> update(@RequestBody DocumentDto document, @PathVariable Integer id) {
		document.setId(id);
		documentService.update(document);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "deleta documento")
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Não é possível excluir documento"),
			@ApiResponse(code = 404, message = "Código inexistente") })
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		documentService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
