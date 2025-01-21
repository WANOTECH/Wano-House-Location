package com.app.gest.immo.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "Parametre")
public class Parametre implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(name ="CODE", unique = true)
	private String code;
	private String libelle;
	private String champLibre1;
	private String champLibre2;
	private String champLibre3;
	private String champLibre4;
	@ManyToOne
	@JoinColumn(name ="Code_TypeParam", referencedColumnName = "TYPEPARAM_CODE")
	private TypeParametre typeParam;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
	public String getChampLibre1() {
		return champLibre1;
	}
	public void setChampLibre1(String champLibre1) {
		this.champLibre1 = champLibre1;
	}
	public String getChampLibre2() {
		return champLibre2;
	}
	public void setChampLibre2(String champLibre2) {
		this.champLibre2 = champLibre2;
	}
	public String getChampLibre3() {
		return champLibre3;
	}
	public void setChampLibre3(String champLibre3) {
		this.champLibre3 = champLibre3;
	}
	public String getChampLibre4() {
		return champLibre4;
	}
	public void setChampLibre4(String champLibre4) {
		this.champLibre4 = champLibre4;
	}
	public TypeParametre getTypeParam() {
		return typeParam;
	}
	public void setTypeParam(TypeParametre typeParam) {
		this.typeParam = typeParam;
	}
	public Parametre(String code, String libelle, String champLibre1, String champLibre2, String champLibre3,
			String champLibre4, TypeParametre typeParam) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.champLibre1 = champLibre1;
		this.champLibre2 = champLibre2;
		this.champLibre3 = champLibre3;
		this.champLibre4 = champLibre4;
		this.typeParam = typeParam;
	}
	public Parametre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
