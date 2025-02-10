package com.app.gest.immo.enumeration;

public enum EEtatLoyer {
	
	Regler(0), Encours(1), Impayer(2), Exonenner(3);

	Integer valeur;
	EEtatLoyer(int valeur) {
		this.valeur = valeur;
		// TODO Auto-generated constructor stub
	}
	
	Integer getValeur() {
		return valeur;
	}

}
