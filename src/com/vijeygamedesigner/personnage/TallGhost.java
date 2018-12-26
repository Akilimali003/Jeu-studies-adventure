package com.vijeygamedesigner.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.vijeygamedesigner.objet.Objet;

public class TallGhost extends Personnage implements Runnable{

	private Image imgtallGhost;
	private ImageIcon icotallGhost;
	
	private final int PAUSE = 15;	//Temps d'attente en ms entre 2 tours de boucle
	private int dxtallGhost;	//Pas de deplacement du tallGhostignon
	
	//****** CONSTRUCTEUR ******//
	public TallGhost(int x, int y) {
		super(x, y, 27, 30);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxtallGhost = 1;
		
		this.icotallGhost = new ImageIcon(getClass().getResource("/image/tallGhostArretDroite.png"));
		this.imgtallGhost = this.icotallGhost.getImage();
	
		Thread chronotallGhost = new Thread(this);
		chronotallGhost.start();
	}
	
	//**** GETTERS ****//
	public Image getImgtallGhost() {return imgtallGhost;}
	
	//**** SETTERS ****//
	
	//**** METHODES ****//
	public void bouge(){	//Deplacement du tallGhostignon
		if (super.isVersDroite() == true) {this.dxtallGhost = 1;}
		else{this.dxtallGhost = -1;}
		super.setX(super.getX() + dxtallGhost);
	}
	
	@Override
	public void run() {
		try {Thread.sleep(20);}	//On attend 20 ms avant d'appeler la methode bouge pour que tous les objets soient completement créés
		catch (InterruptedException e) {}
		
		while (true) {	//boucle infinie
			if(this.vivant == true){
				this.bouge();
				try {Thread.sleep(PAUSE);}
				catch (InterruptedException e){}
			}
		}
	}
	
	public void contact(Objet objet){
		if (super.contactAvant(objet) == true && this.isVersDroite() == true) {
			super.setVersDroite(false);
			this.dxtallGhost = -1;
		}else if (super.contactArriere(objet) == true && this.isVersDroite() == false) {
			super.setVersDroite(true);
			this.dxtallGhost = 1;
		}
	}
	
	public void contact(Personnage personnage){
		if (super.contactAvant(personnage) == true && this.isVersDroite() == true) {
			super.setVersDroite(false);
			this.dxtallGhost = -1;
		}else if (super.contactArriere(personnage) == true && this.isVersDroite() == false) {
			super.setVersDroite(true);
			this.dxtallGhost = 1;
		}
	}
	
	public Image meurt(){
		String str;
		ImageIcon ico;
		Image img;
		
		if(this.isVersDroite() == true){str = "/image/tallGhostEcraseDroite.png";}
		else{str = "/image/tallGhostEcraseGauche.png";}
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}
