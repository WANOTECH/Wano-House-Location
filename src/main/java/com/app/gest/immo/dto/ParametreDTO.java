package com.app.gest.immo.dto;

import java.io.Serializable;

public class ParametreDTO implements Serializable{

	private String code;
	private String libelle;
	private String champLibre1;
	private String champLibre2;
	private String champLibre3;
	private String champLibre4;
	
	private String typeParam;
	
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
	public String getTypeParam() {
		return typeParam;
	}
	public void setTypeParam(String typeParam) {
		this.typeParam = typeParam;
	}
	public ParametreDTO(String code, String libelle, String champLibre1, String champLibre2, String champLibre3,
			String champLibre4, String typeParam) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.champLibre1 = champLibre1;
		this.champLibre2 = champLibre2;
		this.champLibre3 = champLibre3;
		this.champLibre4 = champLibre4;
		this.typeParam = typeParam;
	}
	public ParametreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
