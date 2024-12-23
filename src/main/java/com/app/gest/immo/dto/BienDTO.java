package com.app.gest.immo.dto;

import com.app.gest.immo.enumeration.EEtatBien;

public class BienDTO {
	
	private String code;
	private String nom;
	private String location;
	private String longitude;
	private String latittude;
	private int nombrePieces;
	private Double montantLoyer;
	private int superficie;
	private String adresse;
	private String region;
	private String quartier;
	private String proprietaire;
	private String gestionnaire;
	private EEtatBien etatBien;

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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatittude() {
		return latittude;
	}
	public void setLatittude(String latittude) {
		this.latittude = latittude;
	}
	public int getNombrePieces() {
		return nombrePieces;
	}
	public void setNombrePieces(int nombrePieces) {
		this.nombrePieces = nombrePieces;
	}
	public Double getMontantLoyer() {
		return montantLoyer;
	}
	public void setMontantLoyer(Double montantLoyer) {
		this.montantLoyer = montantLoyer;
	}
	public int getSuperficie() {
		return superficie;
	}
	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public EEtatBien getEtatBien() {
		return etatBien;
	}
	public void setEtatBien(EEtatBien etatBien) {
		this.etatBien = etatBien;
	}
	
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getQuartier() {
		return quartier;
	}
	public void setQuartier(String quartier) {
		this.quartier = quartier;
	}
	public String getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(String proprietaire) {
		this.proprietaire = proprietaire;
	}
	public String getGestionnaire() {
		return gestionnaire;
	}
	public void setGestionnaire(String gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
	public BienDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bien [code=" + code + ", nom=" + nom + "]";
	}
	public BienDTO(String code, String nom, String location, String longitude, String latittude, int nombrePieces,
			Double montantLoyer, int superficie, String adresse, String region, String quartier, String proprietaire,
			String gestionnaire, EEtatBien etatBien) {
		super();
		this.code = code;
		this.nom = nom;
		this.location = location;
		this.longitude = longitude;
		this.latittude = latittude;
		this.nombrePieces = nombrePieces;
		this.montantLoyer = montantLoyer;
		this.superficie = superficie;
		this.adresse = adresse;
		this.region = region;
		this.quartier = quartier;
		this.proprietaire = proprietaire;
		this.gestionnaire = gestionnaire;
		this.etatBien = etatBien;
	}
	
	
	

}
