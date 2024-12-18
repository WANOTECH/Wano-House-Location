package com.app.gest.immo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "GESTIONNAIRE")
public class Gestionnaire extends Personne implements Serializable{
	
	private Date dateNomination;
}
