package com.andrevitoria.sgm.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.andrevitoria.sgm.domain.enums.CharacteristicType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Characteristic implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String description;
	private Integer type;
	private Boolean mandatory;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "classification_id")
	private Classification classification;

	public Classification getClassification() {
		return classification;
	}

	public void setClassification(Classification classification) {
		this.classification = classification;
	}

	public Characteristic() {
	}

	public Characteristic(Integer id, String description, CharacteristicType type, Boolean mandatory,
			Classification classification) {
		super();
		this.id = id;
		this.description = description;
		this.type = type.getId();
		this.mandatory = mandatory;
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

	public CharacteristicType getType() {
		return CharacteristicType.toEnum(type);
	}

	public void setType(CharacteristicType type) {
		this.type = type.getId();
	}

	public Boolean getMandatory() {
		return mandatory;
	}

	public void setMandatory(Boolean mandatory) {
		this.mandatory = mandatory;
	}
}
