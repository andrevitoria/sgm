package com.andrevitoria.sgm.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Contract implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;

	@ManyToMany
	@JoinTable(name = "CONTRACT_DOCUMENT", joinColumns = @JoinColumn(name = "contract_id"), inverseJoinColumns = @JoinColumn(name = "document_id"))
	private List<Document> documents = new ArrayList<>();

	public Contract() {
	}

	public Contract(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
}
