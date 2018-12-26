package com.vijeygamedesigner.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.vijeygamedesigner.audio.Audio;
import com.vijeygamedesigner.jeu.Main;
import com.vijeygamedesigner.objet.Objet;
import com.vijeygamedesigner.objet.Piece;

public class Cyclops extends Personnage{
	
	//**** Variables ****//
	private Image imgCyclops; 
	private ImageIcon icoCyclops;
	private boolean saut;	//vrai si cyclops saute
	private int compteurtSaut;	//durée du saut et la hauteur du saut
	private int compteurMort;
	
	//**** COSTRUCTEUR ****//
	public Cyclops(int x, int y){
		
		super(x, y, 28, 50);
		this.icoCyclops = new ImageIcon(getClass().getResource("/image/cyclopsMarcheDroite.png"));
		this.imgCyclops = this.icoCyclops.getImage();
		
		this.saut = false;
		this.compteurtSaut = 0;
		this.compteurMort = 0;
	}
	
	//**** GETTERS ****//
	public boolean isSaut() {return saut;}
	
	public Image getImgcyclops(){return imgCyclops;}
	
	//**** SETTERS ****//
	public void setSaut(boolean saut) {this.saut = saut;}
	
	//**** METHODES ****//
	@Override
	public Image marche(String nom, int frequence){
		String str;
		ImageIcon ico;
		Image img;
		if(this.marche == false || Main.scene.getxPos() <= 0 || Main.scene.getxPos() > 4645){
			if(this.versDroite == true){str = "/image/" + nom + "ArretDroite.png"; }
			else{str = "/image/" + nom + "ArretGauche.png";}
		}else{
			this.compteur++;
			if(this.compteur / frequence == 0){
				if(this.versDroite == true){str = "/image/" + nom + "ArretDroite.png";}
				else{str = "/image/" + nom + "ArretGauche.png";}
			}else{
				if(this.versDroite == true){str = "/image/" + nom + "MarcheDroite.png";}
				else{str = "/image/" + nom + "MarcheGauche.png";}
			}
			if(this.compteur == 2 * frequence){this.compteur = 0;}
		}
		
		//affichage de l'image du personnage
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
	
	public Image saute(){
		
		ImageIcon ico;
		Image img;
		String str;
		
		this.compteurtSaut++;
		
		//Montée du saut
		if(this.compteurtSaut <= 40){
			if(this.getY() > Main.scene.getHautPlafond()){this.setY(this.getY() - 4);}
			else{this.compteurtSaut = 41;}
			if(this.isVersDroite() == true){str = "/image/cyclopsSautDroite.png";}
			else{str = "/image/cyclopsSautGauche.png";}
			
		//Retombée du saut
		}else if(this.getY() + this.getHauteur() < Main.scene.getySol()){this.setY(this.getY() + 1);
			if(this.isVersDroite() == true){str = "/image/cyclopsSautDroite.png";}
			else{str = "/image/cyclopsSautGauche.png";}
			
		//Saut terminé
		}else{
			if(this.isVersDroite() == true){str = "/image/cyclopsArretDroite.png";}
			else{str = "/image/cyclopsArretGauche.png";}
			this.saut = false;
			this.compteurtSaut = 0;
		}
		
		//affichage de l'image de cyclops
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;	
	}
	
		public void contact (Objet objet){
			//Contact horizontal
			if((super.contactAvant(objet) == true && this.isVersDroite() == true) || (super.contactArriere(objet) == true && this.isVersDroite() == false)){
				Main.scene.setDx(0);
				this.setMarche(false);
		}
		
		//Contact avec objet en dessous
		if(super.contactDessous(objet) == true && this.saut == true){	//cyclops saute sur un objet
			Main.scene.setySol(objet.getY());
		}else if(super.contactDessous(objet) == false){	//cyclops tombe sur le sol initial
			Main.scene.setySol(293);
			if(this.saut == false){this.setY(243);}	//altitude initiale de cyclops
		}
		
		//Contact avec un objet au-dessus
		if(super.contactDessus(objet) == true){
			Main.scene.setHautPlafond(objet.getY() + objet.getHauteur());	//le plafond devient le dessous de l'objet
		}else if(super.contactDessus(objet) == false && this.saut == false){
			Main.scene.setHautPlafond(0);	//altitude du plafond initial (ciel)
		}
	}	
	
	public boolean contactPiece(Piece piece){
		//le contact avec une piece n'a aucune repercussion sur cyclops
		if(this.contactArriere(piece) == true || this.contactAvant(piece) == true || this.contactDessous(piece) == true || 
		   this.contactDessus(piece) == true ){
			return true;
		}else{
			return false;
		}
	}
	
	//Contact cyclops avec les personnages
	public void contact (Personnage personnage){
		if((super.contactAvant(personnage) == true) || (super.contactArriere(personnage) == true)){
			this.setMarche(false);
			this.setVivant(false);
		}
		else if(super.contactDessous(personnage) == true){
			personnage.setMarche(false);
			personnage.setVivant(false);
		}
	}
	
	//Gestion de la mort de cyclops	
	public Image meurt(){
		String str;
		ImageIcon ico;
		Image img;
		
		str = "/image/boom.png";
		if(this.compteurMort == 0){Audio.playSound("/audio/boum.wav");
			this.setMarche(false);
			this.setVivant(false);
		}	
		
		if(this.compteurMort == 300){Audio.playSound("/audio/partiePerdue.wav");}
		this.compteurMort++;
		if(this.compteurMort > 300){
			str = "/image/cyclopsMeurt.png";
			this.setY(this.getY() - 1);
		}
		
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}
