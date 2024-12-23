package com.app.gest.immo.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.app.gest.immo.enumeration.EEtatLoyer;

public class LoyerDTO {
	
	
	private String code;
	private String description;
	private Date datePerception;
	private Double montant;
	private Set<BienDTO> listBiens = new HashSet<BienDTO>();
	private ContratDTO contrat ;
	private EEtatLoyer etatLoyer;
	private String utiCreation;
	private Date dateCreation;
	private Date dateModif;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Set<BienDTO> getListBiens() {
		return listBiens;
	}
	public void setListBiens(Set<BienDTO> listBiens) {
		this.listBiens = listBiens;
	}
	public ContratDTO getContrat() {
		return contrat;
	}
	public void setContrat(ContratDTO contrat) {
		this.contrat = contrat;
	}
	public EEtatLoyer getEtatLoyer() {
		return etatLoyer;
	}
	public void setEtatLoyer(EEtatLoyer etatLoyer) {
		this.etatLoyer = etatLoyer;
	}
	public String getUtiCreation() {
		return utiCreation;
	}
	public void setUtiCreation(String utiCreation) {
		this.utiCreation = utiCreation;
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
	public LoyerDTO(String code, String description, Date datePerception, Double montant, Set<BienDTO> listBiens,
			ContratDTO contrat, EEtatLoyer etatLoyer, String utiCreation, Date dateCreation, Date dateModif) {
		super();
		this.code = code;
		this.description = description;
		this.datePerception = datePerception;
		this.montant = montant;
		this.listBiens = listBiens;
		this.contrat = contrat;
		this.etatLoyer = etatLoyer;
		this.utiCreation = utiCreation;
		this.dateCreation = dateCreation;
		this.dateModif = dateModif;
	}
	public LoyerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
