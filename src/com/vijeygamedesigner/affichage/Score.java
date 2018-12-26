package com.vijeygamedesigner.affichage;

public class Score {
	//Variables
	private final int NOMBRE_TOTAL_PIECES = 10;
	private int nbrePieces = 0;
	
	//CONSTRUCTOR
	public Score() {
		this.nbrePieces = 0;
	}
	
	//GETTERS
	public int getNbrePieces() {
		return nbrePieces;
	}
	
	public int getNOMBRE_TOTAL_PIECES() {
		return NOMBRE_TOTAL_PIECES;
	}
	
	//SETTERS
	public void setNbrePieces(int nbrePieces) {
		this.nbrePieces = nbrePieces;
	}

}
