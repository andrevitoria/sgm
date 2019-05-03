package com.andrevitoria.sgm.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.andrevitoria.sgm.domain.Document;
import com.andrevitoria.sgm.domain.dto.DocumentDto;
import com.andrevitoria.sgm.repositories.DocumentRepository;
import com.andrevitoria.sgm.resources.exceptions.FieldMessage;

public class DocumentInsertValidator implements ConstraintValidator<DocumentInsert, DocumentDto> {

	@Autowired
	private DocumentRepository repo;

	@Override
	public void initialize(DocumentInsert ann) {
	}

	@Override
	public boolean isValid(DocumentDto objDto, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		Document doc;
		doc = repo.findByDescription(objDto.getDescription());
		if (doc != null) {
			list.add(new FieldMessage("description", "Descrição já existente"));
		}

		/*
		 * if (objDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod()) &&
		 * !BR.isValidCPF(objDto.getCpfOuCnpj())) { list.add(new
		 * FieldMessage("cpfOuCnpj", "CPF inválido")); }
		 * 
		 * if (objDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod()) &&
		 * !BR.isValidCNPJ(objDto.getCpfOuCnpj())) { list.add(new
		 * FieldMessage("cpfOuCnpj", "CNPJ inválido")); }
		 * 
		 * Cliente aux = repo.findByEmail(objDto.getEmail()); if (aux != null) {
		 * list.add(new FieldMessage("email", "Email já existente")); }
		 */

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}