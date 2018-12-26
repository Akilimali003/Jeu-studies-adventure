package com.vijeygamedesigner.personnage;

import java.awt.Image;

import javax.swing.ImageIcon;

import com.vijeygamedesigner.objet.Objet;

public class ShortGhost extends Personnage implements Runnable{

	private Image imgshortGhost;
	private ImageIcon icoshortGhost;
	
	private final int PAUSE = 15;	//Temps d'attente en ms entre 2 tours de boucle
	private int dxshortGhost;	//Pas de deplacement de la shortGhost
	
	//****** CONSTRUCTEUR ******//
	public ShortGhost(int x, int y) {
		super(x, y, 43, 50);
		super.setVersDroite(true);
		super.setMarche(true);
		this.dxshortGhost = 1;
			
		this.icoshortGhost = new ImageIcon(getClass().getResource("/image/shortGhostArretGauche.png"));
		this.imgshortGhost = this.icoshortGhost.getImage();
		
		Thread chronoshortGhost = new Thread(this);
		chronoshortGhost.start();
	}

	//**** GETTERS ****//
	public Image getImgshortGhost() {return imgshortGhost;}
		
	//**** SETTERS ****//
		
	//**** METHODES ****//
	public void bouge(){	//Deplacement de la shortGhost
		if (super.isVersDroite() == true) {this.dxshortGhost = 1;}
		else{this.dxshortGhost = -1;}
		super.setX(super.getX() + dxshortGhost);
	}
		
	@Override
	public void run() {
		try {Thread.sleep(20);}	//On attend 20 ms avant d'appeler la methode bouge pour que tous les objets soient completement créés
		catch (InterruptedException e) {}
		
		while (true) {	//boucle infinie
			if(this.vivant == true){
				this.bouge();
				try {Thread.sleep(PAUSE);}
				catch (InterruptedException e) {}
			}
		}
	}
	
	public void contact(Objet objet){
		if (super.contactAvant(objet) == true && this.isVersDroite() == true) {
			super.setVersDroite(false);
			this.dxshortGhost = -1;
		}else if (super.contactArriere(objet) == true && this.isVersDroite() == false) {
			super.setVersDroite(true);
			this.dxshortGhost = 1;
		}
	}
	
	public void contact(Personnage personnage){
		if (super.contactAvant(personnage) == true && this.isVersDroite() == true) {
			super.setVersDroite(false);
			this.dxshortGhost = -1;
		}else if (super.contactArriere(personnage) == true && this.isVersDroite() == false) {
			super.setVersDroite(true);
			this.dxshortGhost = 1;
		}
	}

	public Image meurt(){
		String str;
		ImageIcon ico;
		Image img;
		
		str = "/image/shortGhostFermee.png";
		ico = new ImageIcon(getClass().getResource(str));
		img = ico.getImage();
		return img;
	}
}
