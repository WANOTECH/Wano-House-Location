package com.app.gest.immo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.app.gest.immo.enumeration.EEtatLoyer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Loyer")
public class Loyer implements Serializable {
	private static final String dateFormat = "DD/MM/YYYY";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "CODE", unique = true)
	private String code;
	private String description;
	private Date datePerception;
	private Double montant;
	@OneToMany
	private Set<Bien> listBiens = new HashSet<Bien>();
	@ManyToOne
	private Contrat contrat;
	private EEtatLoyer etatLoyer;
	private String utiCreation;
	private Date dateCreation;
	private Date dateModif;
	private int indice;

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

	public Set<Bien> getListBiens() {
		return listBiens;
	}

	public void setListBiens(Set<Bien> listBiens) {
		this.listBiens = listBiens;
	}

	public Contrat getContrat() {
		return contrat;
	}

	public void setContrat(Contrat contrat) {
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

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Loyer(String code, String description, Date datePerception, Double montant, Set<Bien> listBiens,
			Contrat contrat, EEtatLoyer etatLoyer, String utiCreation, Date dateCreation, Date dateModif, int indice) {
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
		this.indice = indice;
	}

	public Loyer() {
		super();
		// TODO Auto-generated constructor stub
	}

}
