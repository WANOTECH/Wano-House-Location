package com.app.gest.immo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CATEGORIE_BIEN")
public class CategorieBien {
	
	private Long id;
	private String code;
	private String nom;
	private String description;
	private Date dateCreation;
	private Date dateModif;
	private String utiCreation;
	private TypeBien typeBien;

}
