package com.app.gest.immo.dto;

import java.io.Serializable;
import java.util.Date;

public class CategorieBienDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String code;
	private String nom;
	private String description;
	private Date dateCreation;
	private Date dateModif;
	private String utiCreation;

	private String typeBien;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModif() {
		return dateModif;
	}

	public void setDateModif(Date dateModif) {
		this.dateModif = dateModif;
	}

	public String getUtiCreation() {
		return utiCreation;
	}

	public void setUtiCreation(String utiCreation) {
		this.utiCreation = utiCreation;
	}

	public String getTypeBien() {
		return typeBien;
	}

	public void setTypeBien(String typeBien) {
		this.typeBien = typeBien;
	}

	@Override
	public String toString() {
		return "CategorieBien [code=" + code + ", nom=" + nom + "]";
	}

	public CategorieBienDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategorieBienDTO(String code, String nom, String description, Date dateCreation, Date dateModif,
			String utiCreation, String typeBien) {
		super();
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateModif = dateModif;
		this.utiCreation = utiCreation;
		this.typeBien = typeBien;

	}

}
