package com.app.gest.immo.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "GESTIONNAIRE")
public class Gestionnaire extends Personne implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date dateNomination;

	public Date getDateNomination() {
		return dateNomination;
	}

	public void setDateNomination(Date dateNomination) {
		this.dateNomination = dateNomination;
	}

	public Gestionnaire() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Gestionnaire(Date dateNomination) {
		super();
		this.dateNomination = dateNomination;
	}

}
