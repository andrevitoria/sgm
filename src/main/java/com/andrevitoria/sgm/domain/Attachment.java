package com.andrevitoria.sgm.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.andrevitoria.sgm.domain.enums.AttachmentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fileName;
	private Integer data;
	private AttachmentStatus status;
	private Date uploadDate;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "protocol_id")
	private Protocol protocol;
	@ManyToOne
	@JoinColumn(name = "document_id")
	private Document document;
	@ManyToOne
	@JoinColumn(name = "contract_id")
	private Contract contract;

	public Attachment() {
	}

	public Attachment(Integer id, String fileName, Integer data, AttachmentStatus status, Date uploadDate,
			Protocol protocol, Document document, Contract contract) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.data = data;
		this.status = status;
		this.uploadDate = uploadDate;
		this.protocol = protocol;
		this.document = document;
		this.contract = contract;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public AttachmentStatus getStatus() {
		return status;
	}

	public void setStatus(AttachmentStatus status) {
		this.status = status;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Protocol getProtocol() {
		return protocol;
	}

	public void setProtocol(Protocol protocol) {
		this.protocol = protocol;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}
}
