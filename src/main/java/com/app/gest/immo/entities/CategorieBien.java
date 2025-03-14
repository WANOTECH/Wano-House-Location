package com.app.gest.immo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIE_BIEN")
public class CategorieBien implements Serializable {
	
	@Column(name ="TYEPE_ID")
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "CODE", unique = true)
	private String code;
	@Column(name = "NOM")
	private String nom;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "DATE_CREATION")
	private Date dateCreation;
	@Column(name ="DATE_MODIF")
	private Date dateModif;
	@Column(name="UTI_CREATION" )
	private String utiCreation;
	@ManyToOne
	@JoinColumn(name = "TYPE_ID")
	private TypeBien typeBien;
	@OneToMany(fetch = FetchType.LAZY)
	Set<Bien> listBiens = new HashSet<>();
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
	public TypeBien getTypeBien() {
		return typeBien;
	}
	public void setTypeBien(TypeBien typeBien) {
		this.typeBien = typeBien;
	}
	public Set<Bien> getListBiens() {
		return listBiens;
	}
	public void setListBiens(Set<Bien> listBiens) {
		this.listBiens = listBiens;
	}
	@Override
	public String toString() {
		return "CategorieBien [code=" + code + ", nom=" + nom + "]";
	}
	public CategorieBien() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategorieBien(String code, String nom, String description, Date dateCreation, Date dateModif,
			String utiCreation, TypeBien typeBien, Set<Bien> listBiens) {
		super();
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.dateCreation = dateCreation;
		this.dateModif = dateModif;
		this.utiCreation = utiCreation;
		this.typeBien = typeBien;
		this.listBiens = listBiens;
	}
	

}
