package com.app.gest.immo.dto;

import java.io.Serializable;
import java.util.Date;

public class EcheancierDTO implements Serializable {
	
	private String code;
	private String libelle;
	private Date datePerception;
	private Double montant;
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
	public Date getDatePerception() {
		return datePerception;
	}
	public void setDatePerception(Date datePerception) {
		this.datePerception = datePerception;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	

}
