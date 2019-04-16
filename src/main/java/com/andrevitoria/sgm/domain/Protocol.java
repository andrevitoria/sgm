package com.andrevitoria.sgm.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.andrevitoria.sgm.domain.enums.ProtocolStatus;
@Entity
public class Protocol implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	private String id;
	private Integer servicePeriod;
	private Integer status;
	@OneToMany(mappedBy="protocol")
	private List<Attachment> attachments = new ArrayList<>();
	
	public Protocol() {}
	public Protocol(String id, Integer servicePeriod, ProtocolStatus status) {
		super();
		this.id = id;
		this.servicePeriod = servicePeriod;
		this.status = status.getId();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getServicePeriod() {
		return servicePeriod;
	}

	public void setServicePeriod(Integer servicePeriod) {
		this.servicePeriod = servicePeriod;
	}

	public ProtocolStatus getStatus() {
		return ProtocolStatus.toEnum(status);
	}

	public void setStatus(ProtocolStatus status) {
		this.status = status.getId();
	}
	public List<Attachment> getAttachments() {
		return attachments;
	}
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}
}
