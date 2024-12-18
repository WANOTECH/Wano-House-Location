package com.app.gest.immo.enumeration;

public enum ESexe {
	
	Masculin("M"), Feminin("F"), Autre("A");

	String code;
	ESexe(String code) {
		this.code =code;
	}
	
	String getSexe() {
		return code;
	}

}
