package com.app.gest.immo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.app.gest.immo.enumeration.EPeriodicite;
import com.app.gest.immo.enumeration.EStatutContrat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="CONTRAT")
public class Contrat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;
	@Column(name = "CODE")
	private String code;
	private String libelle;
	private Date dateMiseEnplace;
	private Date dateCreate;
	private int durée;
	private EPeriodicite periodicite;
	private Double tva;
	private Double montant;
	private EStatutContrat statut;
	@OneToMany
	private Set<Client> listClients = new HashSet<>();
	@OneToMany
	private Set<Bien> listBiens = new HashSet<>();
	@ManyToOne
	private Personne proprietaire;
	@ManyToOne
	private Gestionnaire gestionnaire;
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
	public Set<Client> getListClients() {
		return listClients;
	}
	public void setListClients(Set<Client> listClients) {
		this.listClients = listClients;
	}
	public Set<Bien> getListBiens() {
		return listBiens;
	}
	public void setListBiens(Set<Bien> listBiens) {
		this.listBiens = listBiens;
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
	public Contrat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contrat(String code, String libelle, Date dateMiseEnplace, Date dateCreate, int durée,
			EPeriodicite periodicite, Double tva, Double montant, EStatutContrat statut, Set<Client> listClients,
			Set<Bien> listBiens, Personne proprietaire, Gestionnaire gestionnaire) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.dateMiseEnplace = dateMiseEnplace;
		this.dateCreate = dateCreate;
		this.durée = durée;
		this.periodicite = periodicite;
		this.tva = tva;
		this.montant = montant;
		this.statut = statut;
		this.listClients = listClients;
		this.listBiens = listBiens;
		this.proprietaire = proprietaire;
		this.gestionnaire = gestionnaire;
	}
	
	

}
