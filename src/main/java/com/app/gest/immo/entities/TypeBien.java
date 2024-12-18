package com.app.gest.immo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "TYEPE_BIEN")
public class TypeBien implements Serializable{
	
	private Long id;
	private String code;
	private String nom;
	private String description;
	private Date dateCreation;
	private Date dateModif;
	private String utiCreation;
	
}
