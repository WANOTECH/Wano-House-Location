package com.app.gest.immo.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.app.gest.immo.enumeration.ETypeParam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "TypeParam")
public class TypeParametre implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name ="TYPEPARAM_CODE", nullable = false)
	private String code;
	private String libelle;
	private String description;
	private ETypeParam typeParam;
	@Column(name="DATE_CREATION")
	private LocalDate dateCreation;
	@Column(name="DATE_MODIIF")
	private LocalDate dateModif;
	@Column(name="USER_CREATION")
	private String utiCreation;
	public String getCode() {
		return code;
	}
	public String getLibelle() {
		return libelle;
	}
	public String getDescription() {
		return description;
	}
	public ETypeParam getTypeParam() {
		return typeParam;
	}
	public LocalDate getDateCreation() {
		return dateCreation;
	}
	public LocalDate getDateModif() {
		return dateModif;
	}
	public String getUtiCreation() {
		return utiCreation;
	}
	public TypeParametre(String code, String libelle, String description, ETypeParam typeParam, LocalDate dateCreation,
						 LocalDate dateModif, String utiCreation) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.description = description;
		this.typeParam = typeParam;
		this.dateCreation = dateCreation;
		this.dateModif = dateModif;
		this.utiCreation = utiCreation;
	}
	public TypeParametre() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TypeParametre [code=" + code + ", libelle=" + libelle + ", description=" + description + ", typeParam="
				+ typeParam + ", dateCreation=" + dateCreation + ", dateModif=" + dateModif + ", utiCreation="
				+ utiCreation + ", getCode()=" + getCode() + ", getLibelle()=" + getLibelle() + ", getDescription()="
				+ getDescription() + ", getTypeParam()=" + getTypeParam() + ", getDateCreation()=" + getDateCreation()
				+ ", getDateModif()=" + getDateModif() + ", getUtiCreation()=" + getUtiCreation() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setTypeParam(ETypeParam typeParam) {
		this.typeParam = typeParam;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public void setDateModif(LocalDate dateModif) {
		this.dateModif = dateModif;
	}

	public void setUtiCreation(String utiCreation) {
		this.utiCreation = utiCreation;
	}
}
