package com.app.gest.immo.dto;

import java.util.Date;

import com.app.gest.immo.enumeration.ETypeParam;


public class TypeParametreDTO {

	private String code;
	private String libelle;
	private String description;
	private ETypeParam typeParam;
	private String utiCreation;
	private String utiModification;
	private Date dateCreation;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ETypeParam getTypeParam() {
		return typeParam;
	}
	public void setTypeParam(ETypeParam typeParam) {
		this.typeParam = typeParam;
	}
	public String getUtiCreation() {
		return utiCreation;
	}
	public void setUtiCreation(String utiCreation) {
		this.utiCreation = utiCreation;
	}
	public String getUtiModification() {
		return utiModification;
	}
	public void setUtiModification(String utiModification) {
		this.utiModification = utiModification;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public TypeParametreDTO(String code, String libelle, String description, ETypeParam typeParam, String utiCreation,
			String utiModification, Date dateCreation) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.description = description;
		this.typeParam = typeParam;
		this.utiCreation = utiCreation;
		this.utiModification = utiModification;
		this.dateCreation = dateCreation;
	}
	public TypeParametreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
