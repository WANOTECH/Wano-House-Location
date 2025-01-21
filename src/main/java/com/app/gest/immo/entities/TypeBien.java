package com.app.gest.immo.entities;


import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TYEPE_BIEN")
public class TypeBien implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TYPE-ID")
	private Long id;
	@Column(name ="CODE", unique =true, nullable = false)
	private String code;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name="DATE_CREATION")
	private LocalDate dateCreation;
	@Column(name="DATE_MODIIF")
	private LocalDate dateModif;
	@Column(name="USER_CREATION")
	private String utiCreation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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

	public TypeBien(String code, String nom, String description, LocalDate dateCreation, LocalDate dateModif,
			String utiCreation) {
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateModif = dateModif;
		this.utiCreation = utiCreation;
	}
	public TypeBien() {
	}
	
}
