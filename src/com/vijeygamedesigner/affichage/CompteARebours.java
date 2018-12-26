package com.vijeygamedesigner.affichage;


public class CompteARebours implements Runnable{
	
	//Variables
	private final int PAUSE = 333;
	private int compteurTemps;
	private String str;
	Thread compteARebours = new Thread(this);
	
	//CONTRUCTOR
	public CompteARebours() {
		this.compteurTemps = 300;
		this.str = "Time : 300";
		
		compteARebours.start();
	}
	
	//GETTERS
	public int getCompteurTemps() {
		return compteurTemps;
	}
	
	public String getStr() {
		return str;
	}
	
	//SETTERS
	
	//METHODES
	@Override
	public void run() {
		while(true){ //Boucle infinie
			try{
				Thread.sleep(PAUSE);
			}catch(InterruptedException e){}
			if(this.compteurTemps >= 1){
				this.compteurTemps--;
				this.str = "Time : " + this.compteurTemps;
				
			}
		}
		
	}
	
	@SuppressWarnings("deprecation")
	public void arretTemps(){
		compteARebours.stop();
	}

}
