package com.app.gest.immo.entities;

import com.app.gest.immo.enumeration.EEtatBien;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "BIEN")
public class Bien implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "CODE", unique = true)
	private String code;
	@Column(name = "NOM")
	private String nom;
	private String location;
	private String longitude;
	private String latittude;
	private int nombrePieces;
	private Double montantLoyer;
	private int superficie;
	@ManyToOne
	private Ville adresse;
	@ManyToOne
	private Region region;
	@ManyToOne
	private Quartier quartier;
	@ManyToOne
	private Personne proprietaire;
	@ManyToOne
	private Gestionnaire gestionnaire;
	@ManyToOne
	private CategorieBien categorieBien;
	private EEtatBien etatBien;
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
	public Ville getAdresse() {
		return adresse;
	}
	public void setAdresse(Ville adresse) {
		this.adresse = adresse;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Quartier getQuartier() {
		return quartier;
	}
	public void setQuartier(Quartier quartier) {
		this.quartier = quartier;
	}
	public Personne getProprietaire() {
		return proprietaire;
	}
	public void setProprietaire(Personne proprietaire) {
		this.proprietaire = proprietaire;
	}
	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}
	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}
	public EEtatBien getEtatBien() {
		return etatBien;
	}
	public void setEtatBien(EEtatBien etatBien) {
		this.etatBien = etatBien;
	}
	
	public CategorieBien getCategorieBien() {
		return categorieBien;
	}
	public void setCategorieBien(CategorieBien categorieBien) {
		this.categorieBien = categorieBien;
	}
	public Bien(String code, String nom, String location, String longitude, String latittude, int nombrePieces,
			Double montantLoyer, int superficie, Ville adresse, Region region, Quartier quartier, Personne proprietaire,
			Gestionnaire gestionnaire, EEtatBien etatBien) {
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
	public Bien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bien [code=" + code + ", nom=" + nom + "]";
	}
	

}
