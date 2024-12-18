package com.app.gest.immo.enumeration;

public enum EEtatBien {
	
	Occupe("O"), Libre("L"), EnReparation("R"), Abandonne("A");
	
	String code;

	EEtatBien(String code) {
		this.code=code;
	}
	
	String getEtatBien() {
		return code;
	}

}
