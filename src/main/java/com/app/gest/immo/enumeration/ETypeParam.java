package com.app.gest.immo.enumeration;

public enum ETypeParam {
	General(0), Client(1);

	Integer code;
	ETypeParam(int code) {
		this.code =code;
	}
	
	Integer getTypeParam() {
		return code;
	}

}
