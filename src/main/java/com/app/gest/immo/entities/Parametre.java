package com.app.gest.immo.entities;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class Parametre {
	
	private long id;
	private String code;
	private String libelle;
	private String champLibre1;
	private String champLibre2;
	private String champLibre3;
	private String champLibre4;
	@ManyToOne
	@JoinColumn(name ="Code_TypeParam", referencedColumnName = "TYPEPARAM_CODE")
	private TypeParametre typeParam;

}
