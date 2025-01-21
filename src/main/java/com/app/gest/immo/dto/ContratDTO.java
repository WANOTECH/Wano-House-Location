package com.app.gest.immo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.app.gest.immo.enumeration.EPeriodicite;
import com.app.gest.immo.enumeration.EStatutContrat;

public class ContratDTO implements Serializable{
	
	private String code;
	private String libelle;
	private Date dateMiseEnplace;
	private Date dateCreate;
	private int durée;
	private EPeriodicite periodicite;
	private Double tva;
	private Double montant;
	private EStatutContrat statut;
	private Set<PersonneDTO> listClientsDTO = new HashSet<PersonneDTO>();
	private Set<BienDTO> listBiensDTP = new HashSet<BienDTO>();
	private String proprietaire;
	private String gestionnaire;
	private boolean isPeriodique;
	
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
	public Date getDateMiseEnplace() {
		return dateMiseEnplace;
	}
	public void setDateMiseEnplace(Date dateMiseEnplace) {
		this.dateMiseEnplace = dateMiseEnplace;
	}
	public Date getDateCreate() {
		return dateCreate;
	}
	public void setDateCreate(Date dateCreate) {
		this.dateCreate = dateCreate;
	}
	public int getDurée() {
		return durée;
	}
	public void setDurée(int durée) {
		this.durée = durée;
	}
	public EPeriodicite getPeriodicite() {
		return periodicite;
	}
	public void setPeriodicite(EPeriodicite periodicite) {
		this.periodicite = periodicite;
	}
	public Double getTva() {
		return tva;
	}
	public void setTva(Double tva) {
		this.tva = tva;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public EStatutContrat getStatut() {
		return statut;
	}
	public void setStatut(EStatutContrat statut) {
		this.statut = statut;
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
	
	public Set<PersonneDTO> getListClientsDTO() {
		return listClientsDTO;
	}
	public void setListClientsDTO(Set<PersonneDTO> listClientsDTO) {
		this.listClientsDTO = listClientsDTO;
	}
	public Set<BienDTO> getListBiensDTP() {
		return listBiensDTP;
	}
	public void setListBiensDTP(Set<BienDTO> listBiensDTP) {
		this.listBiensDTP = listBiensDTP;
	}
	
	public boolean isPeriodique() {
		return isPeriodique;
	}
	public void setPeriodique(boolean isPeriodique) {
		this.isPeriodique = isPeriodique;
	}
	public ContratDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
