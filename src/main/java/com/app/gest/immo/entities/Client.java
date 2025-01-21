package com.app.gest.immo.entities;

import java.io.Serializable;

import com.app.gest.immo.enumeration.ETypeClient;

import jakarta.persistence.Entity;

@Entity
//@Table(name = "CLIENT")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Client extends Personne implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String piecesRecto;
	private String pieceVerso;
	private ETypeClient typeClient;
	private String refFiscale;
	public String getPiecesRecto() {
		return piecesRecto;
	}
	public void setPiecesRecto(String piecesRecto) {
		this.piecesRecto = piecesRecto;
	}
	public String getPieceVerso() {
		return pieceVerso;
	}
	public void setPieceVerso(String pieceVerso) {
		this.pieceVerso = pieceVerso;
	}
	public ETypeClient getTypeClient() {
		return typeClient;
	}
	public void setTypeClient(ETypeClient typeClient) {
		this.typeClient = typeClient;
	}
	public Client(String piecesRecto, String pieceVerso, ETypeClient typeClient) {
		super();
		this.piecesRecto = piecesRecto;
		this.pieceVerso = pieceVerso;
		this.typeClient = typeClient;
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getRefFiscale() {
		return refFiscale;
	}
	public void setRefFiscale(String refFiscale) {
		this.refFiscale = refFiscale;
	}

}
