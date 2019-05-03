package com.andrevitoria.sgm.domain.dto;

import java.io.Serializable;
import java.util.Date;

import com.andrevitoria.sgm.domain.enums.AttachmentStatus;

public class AttachmentNewDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String fileName;
	private byte[] data;
	private AttachmentStatus status;
	private Date uploadDate;
	private String fileType;
	private String id_protocol;
	private Integer id_document;
	private String id_contract;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
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

	public String getId_protocol() {
		return id_protocol;
	}

	public void setId_protocol(String id_protocol) {
		this.id_protocol = id_protocol;
	}

	public Integer getId_document() {
		return id_document;
	}

	public void setId_document(Integer id_document) {
		this.id_document = id_document;
	}

	public String getId_contract() {
		return id_contract;
	}

	public void setId_contract(String id_contract) {
		this.id_contract = id_contract;
	}

	public AttachmentNewDto() {
	};

	public AttachmentNewDto(String fileName, byte[] data, String fileType, AttachmentStatus status, Date uploadDate, String id_protocol,
			Integer id_document, String id_contract) {
		super();
		this.fileName = fileName;
		this.data = data;
		this.status = status;
		this.fileType = fileType;
		this.uploadDate = uploadDate;
		this.id_protocol = id_protocol;
		this.id_document = id_document;
		this.id_contract = id_contract;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
