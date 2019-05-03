package com.andrevitoria.sgm.domain.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.andrevitoria.sgm.services.validation.DocumentInsert;
@DocumentInsert
public class DocumentDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "preenchimento obrigatório!")
	@Length(min = 3, max = 255, message = "o tamanho deve ser entre 5 a 255 caracteres!")
	private String description;
	@NotNull(message="preenchimento obrigatório!")
	private Boolean activated;
	private Date created;
	private Date modified;
	private Integer classification_id;

	public DocumentDto() {	}

	public DocumentDto(String description, Boolean activated, Date created, Date modified, Integer classification_id) {
		super();
		this.description = description;
		this.activated = activated;
		this.created = created;
		this.modified = modified;
		this.classification_id = classification_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getActivated() {
		return activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public Integer getClassification_id() {
		return classification_id;
	}

	public void setClassification_id(Integer classification_id) {
		this.classification_id = classification_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
