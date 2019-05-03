package com.andrevitoria.sgm.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Document implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique=true)
	private String description;
	private Boolean activated;
	private Date created;
	private Date modified;

	@ManyToOne
	@JoinColumn(name = "classification_id")
	private Classification classification;
	
	public Classification getClassification() {
		return classification;
	}
	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	@JsonIgnore
	@ManyToMany(mappedBy = "documents")
	private List<Contract> contracts = new ArrayList<>();

	public Document() {
	}
	public Document(Integer id, String description, Boolean activated, Date created, Date modified) {
		this.id = id;
		this.description = description;
		this.activated = activated;
		this.created = created;
		this.modified = modified;
	}
	public Document(Integer id, String description, Boolean activated, Date created, Date modified,
			Classification classification) {
		this.id = id;
		this.description = description;
		this.activated = activated;
		this.created = created;
		this.modified = modified;
		this.classification = classification;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

}
