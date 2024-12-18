package com.app.gest.immo.entities;

import java.io.Serializable;

import com.app.gest.immo.enumeration.ETypeClient;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client extends Personne implements Serializable{
	
	private String piecesRecto;
	private String pieceVerso;
	private ETypeClient typeClient;
	

}
