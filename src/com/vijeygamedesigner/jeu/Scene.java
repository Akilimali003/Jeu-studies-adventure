package com.vijeygamedesigner.jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.vijeygamedesigner.affichage.CompteARebours;
import com.vijeygamedesigner.affichage.Score;
import com.vijeygamedesigner.audio.Audio;
import com.vijeygamedesigner.objet.Bloc;
import com.vijeygamedesigner.objet.Objet;
import com.vijeygamedesigner.objet.Piece;
import com.vijeygamedesigner.objet.SoucheArbre;
import com.vijeygamedesigner.personnage.TallGhost;
import com.vijeygamedesigner.personnage.Cyclops;
import com.vijeygamedesigner.personnage.ShortGhost;


//***** La classe Scene est la classe la plus importante de l'application *****//
//***** Elle est accessible par toutes les autres classes, contient le moteur de l'application *****//
//***** Elle gere la partie graphique *****//
@SuppressWarnings("serial")
public class Scene extends JPanel {

	//**** Variables ****//
	private ImageIcon icoFond;
	private Image imgFond1;
	private Image imgFond2;
	
	private ImageIcon icoChateau1;
	private Image imgChateau1;
	private ImageIcon icoDepart;
	private Image imgDepart;
	
	private int xFond1;
	private int xFond2;
	private int dx;		//deplacement du fond d'ecran
	private int xPos;	//Position absolue dans le jeu
	private int ySol;	//hauteur courante du sol
	private int hauteurPlafond;	//hauteur courante du plafond
	private boolean ok;
	
	public Cyclops cyclops;
	
	public SoucheArbre SoucheArbre1;
	public SoucheArbre SoucheArbre2;
	public SoucheArbre SoucheArbre3;
	public SoucheArbre SoucheArbre4;
	public SoucheArbre SoucheArbre5;
	public SoucheArbre SoucheArbre6;
	public SoucheArbre SoucheArbre7;
	public SoucheArbre SoucheArbre8;
	
	public Bloc bloc1;
	public Bloc bloc2;
	public Bloc bloc3;
	public Bloc bloc4;
	public Bloc bloc5;
	public Bloc bloc6;
	public Bloc bloc7;
	public Bloc bloc8;
	public Bloc bloc9;
	public Bloc bloc10;
	public Bloc bloc11;
	public Bloc bloc12;
	
	public Piece piece1; 
	public Piece piece2; 
	public Piece piece3; 
	public Piece piece4; 
	public Piece piece5; 
	public Piece piece6; 
	public Piece piece7; 
	public Piece piece8; 
	public Piece piece9; 
	public Piece piece10; 
	
	public TallGhost tallGhost1;
	public TallGhost tallGhost2;
	public TallGhost tallGhost3;
	public TallGhost tallGhost4;
	public TallGhost tallGhost5;
	public TallGhost tallGhost6;
	public TallGhost tallGhost7;
	public TallGhost tallGhost8;
	
	public ShortGhost shortGhost1;
	public ShortGhost shortGhost2;
	public ShortGhost shortGhost3;
	public ShortGhost shortGhost4;
	public ShortGhost shortGhost5;
	public ShortGhost shortGhost6;
	public ShortGhost shortGhost7;
	public ShortGhost shortGhost8;
	public ShortGhost shortGhost9;
	
	private ImageIcon icoDrapeau;
	private Image imgDrapeau;
	private ImageIcon icoChateauFin;
	private Image imgChateauFin;
	
	private ArrayList<Objet> tabObjets;	//tableau qui enregistre tous les objets du jeu
	private ArrayList<Piece> tabPieces;	//tableau qui enregistre toutes les pieces du jeu
	private ArrayList<ShortGhost> tabShortGhost;	//tableau qui enregistre toutes les shortGhosts du jeu
	private ArrayList<TallGhost> tabTallGhost;	//tableau qui enregistre tous les tallGhostignons du jeu
	
	private Score score;
	private Font police;
	private CompteARebours compteARebours; 
	
	//**** CONTRUCTEUR ****//
	public Scene(){
		
		super();
		
		this.xFond1 = -50;
		this.xFond2 = 750;
		this.dx = 0;
		this.xPos = -1;
		this.ySol = 293;
		this.hauteurPlafond = 0;
		this.ok = true;
		
		icoFond = new ImageIcon(getClass().getResource("/image/background.png"));
		this.imgFond1 = this.icoFond.getImage();	//associe notre icoFond à  imgFond1
		this.imgFond2 = this.icoFond.getImage();
		
		this.icoChateau1 = new ImageIcon(getClass().getResource("/image/chateauDebut.png"));
		this.imgChateau1 = this.icoChateau1.getImage();
		this.icoDepart = new ImageIcon(getClass().getResource("/image/fleche.png"));
		this.imgDepart = this.icoDepart.getImage();
		
		cyclops = new Cyclops(300, 245);
		
		SoucheArbre1 = new SoucheArbre(600, 229);
		SoucheArbre2 = new SoucheArbre(1000, 229);
		SoucheArbre3 = new SoucheArbre(1600, 229);
		SoucheArbre4 = new SoucheArbre(1900, 229);
		SoucheArbre5 = new SoucheArbre(2500, 229);
		SoucheArbre6 = new SoucheArbre(3000, 229);
		SoucheArbre7 = new SoucheArbre(3500, 229);
		SoucheArbre8 = new SoucheArbre(4500, 229);
		
		bloc1 = new Bloc(400, 180);
		bloc2 = new Bloc(1200, 180);
		bloc3 = new Bloc(1270, 170);
		bloc4 = new Bloc(1340, 160);
		bloc5 = new Bloc(2000, 180);
		bloc6 = new Bloc(2600, 160);
		bloc7 = new Bloc(2650, 180);
		bloc8 = new Bloc(3300, 160);
		bloc9 = new Bloc(3350, 140);
		bloc10 = new Bloc(4000, 170);
		bloc11 = new Bloc(4200, 200);
		bloc12 = new Bloc(4300, 210);
		
		piece1 = new Piece(407, 145);
		piece2 = new Piece(1207, 140);
		piece3 = new Piece(1277, 95);
		piece4 = new Piece(1347, 40);
		piece5 = new Piece(1730, 145);
		piece6 = new Piece(2657, 145);
		piece7 = new Piece(3160, 135);
		piece8 = new Piece(3307, 125);
		piece9 = new Piece(4207, 145);
		piece10 = new Piece(4306, 145);
		
		tallGhost1 = new TallGhost(650, 265);
		tallGhost2 = new TallGhost(1100, 265);
		tallGhost3 = new TallGhost(2100, 265);
		tallGhost4 = new TallGhost(2400, 265);
		tallGhost5 = new TallGhost(3200, 265);
		tallGhost6 = new TallGhost(3500, 265);
		tallGhost7 = new TallGhost(3700, 265);
		tallGhost8 = new TallGhost(4500, 265);
		
		shortGhost1 = new ShortGhost(800, 245);
		shortGhost2 = new ShortGhost(1500, 245);
		shortGhost3 = new ShortGhost(1800, 245);
		shortGhost4 = new ShortGhost(2500, 245);
		shortGhost5 = new ShortGhost(3100, 245);
		shortGhost6 = new ShortGhost(3600, 245);
		shortGhost7 = new ShortGhost(3900, 245);
		shortGhost8 = new ShortGhost(4200, 245);
		shortGhost9 = new ShortGhost(4400, 245);
		
		
		this.icoChateauFin = new ImageIcon(getClass().getResource("/image/chateauFin.png"));
		this.imgChateauFin = this.icoChateauFin.getImage();
		
		this.icoDrapeau = new ImageIcon(getClass().getResource("/image/Drapeau.png"));
		this.imgDrapeau = this.icoDrapeau.getImage();
		
		tabObjets = new ArrayList<>();
		this.tabObjets.add(this.SoucheArbre1);
		this.tabObjets.add(this.SoucheArbre2);
		this.tabObjets.add(this.SoucheArbre3);
		this.tabObjets.add(this.SoucheArbre4);
		this.tabObjets.add(this.SoucheArbre5);
		this.tabObjets.add(this.SoucheArbre6);
		this.tabObjets.add(this.SoucheArbre7);
		this.tabObjets.add(this.SoucheArbre8);
		
		this.tabObjets.add(this.bloc1);
		this.tabObjets.add(this.bloc2);
		this.tabObjets.add(this.bloc3);
		this.tabObjets.add(this.bloc4);
		this.tabObjets.add(this.bloc5);
		this.tabObjets.add(this.bloc6);
		this.tabObjets.add(this.bloc7);
		this.tabObjets.add(this.bloc8);
		this.tabObjets.add(this.bloc9);
		this.tabObjets.add(this.bloc10);
		this.tabObjets.add(this.bloc11);
		this.tabObjets.add(this.bloc12);
		
		tabPieces = new ArrayList<>();
		this.tabPieces.add(this.piece1);
		this.tabPieces.add(this.piece2);
		this.tabPieces.add(this.piece3);
		this.tabPieces.add(this.piece4);
		this.tabPieces.add(this.piece5);
		this.tabPieces.add(this.piece6);
		this.tabPieces.add(this.piece7);
		this.tabPieces.add(this.piece8);
		this.tabPieces.add(this.piece9);
		this.tabPieces.add(this.piece10);
		
		tabTallGhost = new ArrayList<>();
		this.tabTallGhost.add(this.tallGhost1);
		this.tabTallGhost.add(this.tallGhost2);
		this.tabTallGhost.add(this.tallGhost3);
		this.tabTallGhost.add(this.tallGhost4);
		this.tabTallGhost.add(this.tallGhost5);
		this.tabTallGhost.add(this.tallGhost6);
		this.tabTallGhost.add(this.tallGhost7);
		this.tabTallGhost.add(this.tallGhost8);
		
		tabShortGhost = new ArrayList<>();
		this.tabShortGhost.add(this.shortGhost1);
		this.tabShortGhost.add(this.shortGhost2);
		this.tabShortGhost.add(this.shortGhost3);
		this.tabShortGhost.add(this.shortGhost4);
		this.tabShortGhost.add(this.shortGhost5);
		this.tabShortGhost.add(this.shortGhost6);
		this.tabShortGhost.add(this.shortGhost7);
		this.tabShortGhost.add(this.shortGhost8);
		this.tabShortGhost.add(this.shortGhost9);
		
		this.setFocusable(true);
		this.requestFocusInWindow();
		this.addKeyListener(new Clavier());
		
		score = new Score();
		police = new Font("Arial", Font.PLAIN, 18);
		compteARebours = new CompteARebours();
		
		Thread chronoEcran = new Thread(new Chrono());
		chronoEcran.start();
	}
	
	
	//**** GETTERS ****//
	public int getDx() {return dx;}
	
	public int getxPos() {return xPos;}
	
	public int getySol() {return ySol;}
	
	public int getHautPlafond() {return hauteurPlafond;}


	//**** SETTERS ****//
	public void setDx(int dx) {this.dx = dx;}
	
	public void setxFond1(int xFond1) {this.xFond1 = xFond1;}
	
	public void setySol(int ySol) {this.ySol = ySol;}

	public void setHautPlafond(int hauteurPlafond) {this.hauteurPlafond = hauteurPlafond;}

	public void setxFond2(int xFond2) {this.xFond2 = xFond2;}

	public void setxPos(int xPos) {this.xPos = xPos;}

	
	//**** METHODES ****//
	public void deplacementFond(){	//deplacement des images "fixes" de l'écran simulant le deplacement de cyclops
		
		if(this.xPos >= 0 && this.xPos <= 4625){
			//Mise a jour des positions des éléments du jeu lors du deplacement de cyclops
			this.xPos = this.xPos + this.dx;
			this.xFond1 = this.xFond1 - this.dx;
			this.xFond2 = this.xFond2 - this.dx;
		}
		//Permanence du fond d'ecran
		if(this.xFond1 == -800){this.xFond1 = 800;}
		else if(this.xFond2 == -800){this.xFond2 = 800;}
		else if(this.xFond1 == 800){this.xFond1 = -800;}
		else if(this.xFond2 == 800){this.xFond2 = -800;}
		}
	
	private boolean partieGagnee(){
		if(this.compteARebours.getCompteurTemps() > 0 && this.cyclops.isVivant() == true && this.score.getNbrePieces() == 10 
			&& this.xPos > 4370){
			if(this.ok == true){
				Audio.playSound("/audio/partieGagnee.wav");
				this.ok = false;
			}
			return true;
		}else{
			return false;
		}
	}
	
	private boolean partiePerdue(){
		if(this.cyclops.isVivant() == false || this.compteARebours.getCompteurTemps() <= 0){
			cyclops.meurt();
			return true;
		}else{
			return false;
		}
	}
	
	private boolean finDePartie(){
		if(this.partieGagnee() == true || this.partiePerdue() == true){
			return true;
		}else{
			return false;
		}
	}
	
	public void paintComponent(Graphics g){	//dessin de toutes les images visibles à  l'ecran (appel toutes les 5 ms environ)
		
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		//Detection contact avec les objects
		for (int i = 0; i < this.tabObjets.size(); i++) {
			//cyclops
			if(this.cyclops.proche(this.tabObjets.get(i))){this.cyclops.contact(this.tabObjets.get(i));}
			
			//tallGhosts
			for (int j = 0; j < this.tabTallGhost.size(); j++){
				if(this.tabTallGhost.get(j).proche(this.tabObjets.get(i))){this.tabTallGhost.get(j).contact(this.tabObjets.get(i));}
			}
			//shortGhosts
			for (int j = 0; j < this.tabShortGhost.size(); j++){
				if(this.tabShortGhost.get(j).proche(this.tabObjets.get(i))){this.tabShortGhost.get(j).contact(this.tabObjets.get(i));}
			}
		}
		
		//Detection de contact de cyclops avec les pieces
		for (int i = 0; i < this.tabPieces.size(); i++) {
			if (this.cyclops.proche(this.tabPieces.get(i))) {
				if (this.cyclops.contactPiece(this.tabPieces.get(i))) {
					Audio.playSound("/audio/piece.wav");
					this.tabPieces.remove(i);
					this.score.setNbrePieces(this.score.getNbrePieces() + 1);
				}
				
			}
		}
		
		//Detection des contacts des tallGhostignons avec les personnages (hors cyclops)
		for (int i = 0; i < this.tabTallGhost.size(); i++){
			//tallGhost
			for (int j = 0; j < this.tabTallGhost.size(); j++){
				if (j != i){
					if(this.tabTallGhost.get(j).proche(this.tabTallGhost.get(i))){this.tabTallGhost.get(j).contact(this.tabTallGhost.get(i));}
				}
			}
			//shortGhost
			for (int j = 0; j < this.tabShortGhost.size(); j++){
					if(this.tabShortGhost.get(j).proche(this.tabTallGhost.get(i))){this.tabShortGhost.get(j).contact(this.tabTallGhost.get(i));}
			}
		}
		
		//Detection des contacts des shortGhosts avec les personnages (hors cyclops)
		for (int i = 0; i < this.tabShortGhost.size(); i++){
			//tallGhost
			for (int j = 0; j < this.tabTallGhost.size(); j++){
					if(this.tabTallGhost.get(j).proche(this.tabShortGhost.get(i))){this.tabTallGhost.get(j).contact(this.tabShortGhost.get(i));}
			}
			//shortGhost
			for (int j = 1; j < this.tabShortGhost.size(); j++){
				if (j != i){
					if(this.tabShortGhost.get(j).proche(this.tabShortGhost.get(i))){this.tabShortGhost.get(j).contact(this.tabShortGhost.get(i));}
				}
			}
		}
		
		//Detection des contacts de cyclops avec des personnages
		//tallGhost
		for (int i = 0; i < this.tabTallGhost.size(); i++){
			if(this.cyclops.proche(this.tabTallGhost.get(i))&& this.tabTallGhost.get(i).isVivant() == true) {
				this.cyclops.contact(this.tabTallGhost.get(i));
				if(this.tabTallGhost.get(i).isVivant() == false) {Audio.playSound("/audio/ecrasePersonnage.wav");}
			}
		}
		//shortGhost
		for (int i = 0; i < this.tabShortGhost.size(); i++){
			if(this.cyclops.proche(this.tabShortGhost.get(i))&& this.tabShortGhost.get(i).isVivant() == true) {
				this.cyclops.contact(this.tabShortGhost.get(i));
				if(this.tabShortGhost.get(i).isVivant() == false){Audio.playSound("/audio/ecrasePersonnage.wav");}
			}
		}
		
		//deplacement de tous les objets "fixes" du jeu
		this.deplacementFond();
		if(this.xPos >= 0 && this.xPos <= 4625){
			for (int i = 0; i < this.tabObjets.size(); i++) {this.tabObjets.get(i).deplacement();}
			for (int i = 0; i < this.tabPieces.size(); i++) {this.tabPieces.get(i).deplacement();}
			for (int i = 0; i < this.tabTallGhost.size(); i++){this.tabTallGhost.get(i).deplacement();}
			for (int i = 0; i < this.tabShortGhost.size(); i++){this.tabShortGhost.get(i).deplacement();}
		}
		
		//dessin de l'image du fond
		g2.drawImage(this.imgFond1, this.xFond1, 0, null);	
		g2.drawImage(this.imgFond2, this.xFond2, 0, null);
		
		//dessin de l'image du chateau du début
		g2.drawImage(this.imgChateau1, 10 - this.xPos, 133, null);
		
		//dessin de l'image du panneau du depart
		g2.drawImage(imgDepart, 220 - this.xPos, 214, null);
		
		//image des objets
		for (int i = 0; i < this.tabObjets.size(); i++) {
			g2.drawImage(this.tabObjets.get(i).getImgObjet(), this.tabObjets.get(i).getX(), this.tabObjets.get(i).getY(), null);
		}
		
		//Images des pieces
		for (int i = 0; i < this.tabPieces.size(); i++) {
			g2.drawImage(this.tabPieces.get(i).bouge(), this.tabPieces.get(i).getX(), this.tabPieces.get(i).getY(), null);
		}
		
		//Image du drapeau de fin
		g2.drawImage(imgDrapeau, 4650 - this.getxPos(), 144, null);
		//Image du chateau d'arriver
		g2.drawImage(imgChateauFin, 5025 - this.getxPos(), 104, null);
		
		//Image cyclops
		if(this.cyclops.isVivant() == true){
			if(this.cyclops.isSaut()){g2.drawImage(this.cyclops.saute(), this.cyclops.getX(), this.cyclops.getY(), null);}	
			else{g2.drawImage(this.cyclops.marche("cyclops", 25), this.cyclops.getX(), this.cyclops.getY(), null);}
		}else{g2.drawImage(this.cyclops.meurt(), this.cyclops.getX(), this.cyclops.getY(), null);}
			
		//Image des tallGhosts
		for (int i = 0; i < this.tabTallGhost.size(); i++){
			if (this.tabTallGhost.get(i).isVivant() == true){
				g2.drawImage(this.tabTallGhost.get(i).marche("tallGhost", 45), this.tabTallGhost.get(i).getX(),this.tabTallGhost.get(i).getY(), null);
			}else{
				g2.drawImage(this.tabTallGhost.get(i).meurt(), this.tabTallGhost.get(i).getX(),this.tabTallGhost.get(i).getY() + 20, null);
			}
		}
		//Image des shortGhosts
		for (int i = 0; i < this.tabShortGhost.size(); i++){
			if (this.tabShortGhost.get(i).isVivant() == true){
				g2.drawImage(this.tabShortGhost.get(i).marche("shortGhost", 45), this.tabShortGhost.get(i).getX(),this.tabShortGhost.get(i).getY(), null);
			}else{
				g2.drawImage(this.tabShortGhost.get(i).meurt(), this.tabShortGhost.get(i).getX(),this.tabShortGhost.get(i).getY() + 20, null);
			}
		}
		
		//Mise a jour du score
		g2.setFont(police);
		g2.setColor(Color.decode("#ffffff"));
		if(this.score.getNbrePieces() <= 1 ){
			g2.drawString(this.score.getNbrePieces() + " Coin found out of " + this.score.getNOMBRE_TOTAL_PIECES(), 490, 25);
		}else{
			g2.drawString(this.score.getNbrePieces() + " Coins found out of " + this.score.getNOMBRE_TOTAL_PIECES(), 480, 25);
		}
		
		//Mise a jour du temps restant du jeu
		g2.drawString(this.compteARebours.getStr(), 10, 25);
		g2.setColor(Color.decode("#ffffff"));
		
		//Fin de partie
		if(this.finDePartie() == true){
			Font policeFin = new Font("Astrolyte", Font.BOLD, 50);
			g2.setFont(policeFin);
			g2.setColor(Color.decode("#55B25A"));
			if(this.partieGagnee() == true){
				g2.drawString("You win !", 225, 180);
				g2.drawString("WELCOME AT ULKT", 30, 120);
				this.compteARebours.arretTemps();
			}else{
				g2.drawString("Game Over !", 177, 180);
				this.compteARebours.arretTemps();
			}
		}
		
		//Mise a jour des contributeurs du jeu
		if(this.finDePartie() == true){
			//Temps epouise
			if(this.compteARebours.getCompteurTemps() <= 0){
				cyclops.meurt();
				Font cast = new Font("Astrolyte", Font.BOLD, 25);
				g2.setFont(cast);
				g2.drawString("Time Up", 287, 100);
			}
			//Partie gagnee
			//Affichage du lien du site d'inscription de l'ulkt
			if(this.partieGagnee() == true){
				Font cast = new Font("Bookman Old Style", Font.BOLD, 13);
				g2.setFont(cast);
				g2.setColor(Color.decode("#ffffff"));

				g2.drawString("www.ulkt.org", 580, 305);
			}
			//Affichage des facultés
			if(this.partieGagnee() == true){
				Font cast = new Font("Bookman Old Style", Font.BOLD, 13);
				g2.setFont(cast);
				g2.setColor(Color.decode("#569d58"));
				g2.drawString("⦁	 Droit", 95, 200);
				g2.drawString("⦁	 Economie et gestion", 95, 215);
				g2.drawString("⦁	 Agronomie et developpement durable", 95, 230);
				g2.drawString("⦁	 Nouvelle technologie de l'information et communication (NTIC)", 95, 245);
				g2.drawString("⦁	 Informatique de gestion", 95, 260);
				g2.drawString("⦁	 Peche et navigation", 95, 275);
				g2.drawString("⦁ Sciences sociales, politiques et administrative", 95, 290);				
				
			//Partie perdue
			}else{
				Font cast = new Font("Astrolyte", Font.BOLD, 13);
				g2.setFont(cast);
				g2.setColor(Color.decode("#569d58"));
				g2.drawString("Game Designer: ......... Akilimali Vijey", 220, 200);
				g2.drawString("Programmer: ......... Akilimali Vijey", 228, 215);
				g2.drawString("Graphic Designer: ......... Clarice Godwin Akilimali", 170, 230);
				g2.drawString("Sound Designer: ......... Yefta Dan", 235, 245);
				g2.drawString("Manager: ......... Zacharie Boroto", 237, 260);
			}
		}
	}
}
