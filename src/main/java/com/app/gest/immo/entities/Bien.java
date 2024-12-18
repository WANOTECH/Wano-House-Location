package com.app.gest.immo.entities;

import com.app.gest.immo.enumeration.EEtatBien;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "BIEN")
public class Bien {
	
	private Long id;
	private String code;
	private String nom;
	private String quartier;
	private String longitude;
	private String latittude;
	private int nombrePieces;
	private Double montantLoyer;
	private int superficie;
	private Parametre adresse;
	private Personne proprietaire;
	private Gestionnaire gestionnaire;
	private EEtatBien etatBien;

}
