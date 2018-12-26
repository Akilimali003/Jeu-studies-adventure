package com.vijeygamedesigner.objet;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Piece extends Objet implements Runnable{

	//**** VARIABLES ****//
	private int compteur;
	private final int PAUSE = 15;	//Temps d'attente entre 2 tours de boucle
	
	public Piece(int x, int y) {
		super(x, y, 30, 30);

		super.icoObjet = new ImageIcon(getClass().getResource("/image/piece1.png"));
		super.imgObjet = super.icoObjet.getImage();
	}
	
	
	//**** GETTERS ****//
	
	
	//**** SETTERS ****//
	
	
	//**** METHODES ****//
	public Image bouge(){	//mouvement de la piece
		String str;
		ImageIcon ico;
		Image img;
		
		this.compteur++;
		if (this.compteur / 100 == 0) { str = "/image/piece1.png";}
		else{str = "/image/piece2.png";}
		if (this.compteur == 200) {this.compteur = 0;}
		
		//Affichage de l'image du personnage
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}


	@Override
	public void run() {
		try {Thread.sleep(20);}	//On attend 20 ms avant d'appeler la methode bouge pour que tous les objets soient completement créés
		catch (InterruptedException e) {}
		
		while (true) {	//boucle infinie
		this.bouge();
			try {Thread.sleep(PAUSE);}
			catch (InterruptedException e) {}
		}
	}

}
