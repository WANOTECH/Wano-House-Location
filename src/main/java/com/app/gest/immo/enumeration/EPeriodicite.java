package com.app.gest.immo.enumeration;

public enum EPeriodicite {
	
	Mensuelle(0), Trimestrielle(1), Semestrielle(2), Annuelle(3);
	
	Integer code;
	EPeriodicite(Integer code) {
		this.code = code;
	}
	Integer getPeriode() {
		return code;
	}
	
}
