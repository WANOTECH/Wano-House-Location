package com.app.gest.immo.entities;

import java.util.Random;

public class UtilsAPP {

	public String generateCode(String className, String id) {
		Random random = new Random();
		// Format du code (par exemple : TYPEBIEN-0001)
		String formattedSequence = String.format("%04d", id);
		char randomLetter = (char) ('A' + random.nextInt(26));
		String code = className.toUpperCase() + "-" + randomLetter + formattedSequence;

		return code;
	}

	public UtilsAPP() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
