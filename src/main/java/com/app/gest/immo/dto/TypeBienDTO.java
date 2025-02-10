package com.app.gest.immo.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TypeBienDTO {
	@JsonProperty("code")
	private String code;

	@JsonProperty("nom")
	private String nom;

	@JsonProperty("description")
	private String description;

	@JsonProperty("dateCreation")
	private LocalDate dateCreation;

	@JsonProperty("dateModif")
	private LocalDate dateModif;

	@JsonProperty("utiCreation")
	private String utiCreation;

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

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDate getDateModif() {
		return dateModif;
	}

	public void setDateModif(LocalDate dateModif) {
		this.dateModif = dateModif;
	}

	public String getUtiCreation() {
		return utiCreation;
	}

	public void setUtiCreation(String utiCreation) {
		this.utiCreation = utiCreation;
	}

	@Override
	public String toString() {
		return "TypeBienDTO [code=" + code + ", nom=" + nom + ", description=" + description + ", dateCreation="
				+ dateCreation + "]";
	}

	public TypeBienDTO(String code, String nom, String description, LocalDate dateCreation, LocalDate dateModif,
			String utiCreation) {
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateModif = dateModif;
		this.utiCreation = utiCreation;
	}

	public TypeBienDTO() {}

}
