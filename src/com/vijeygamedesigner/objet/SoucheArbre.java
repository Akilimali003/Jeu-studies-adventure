package com.vijeygamedesigner.objet;

import javax.swing.ImageIcon;

public class SoucheArbre extends Objet{


	//**** Variables ****//
	
	//**** CONSTRUCTEUR ****//
	public SoucheArbre(int x, int y) {
		
		super(x, y, 43, 65);
		super.icoObjet = new ImageIcon(getClass().getResource("/image/SoucheArbre.png"));
		super.imgObjet = this.icoObjet.getImage();
	}

	//**** GETTERS ****//
	
	
	//**** SETTERS ****//
	
	
	//**** METHODES ****//
	
}
