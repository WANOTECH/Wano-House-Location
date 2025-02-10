package com.app.gest.immo.enumeration;

public enum EStatutContrat {
	Encours("EN"), Resilier("RE"), Annuler("AN"), Abanndonner("AB");

	String code;
	EStatutContrat(String code) {
		this.code=code;
		// TODO Auto-generated constructor stub
	}
	
	String getCode() {
		return code;
	}
	
	
}
