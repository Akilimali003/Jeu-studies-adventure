package com.vijeygamedesigner.jeu;

public class Chrono implements Runnable{

	//***** Variable *****//
	private final int PAUSE = 4;	//temps d'attente entre 2 tours de boucle: 4 millisecondes
	
	//**** METHODES ****//
	@Override
	public void run() {
		
		while(true){
			Main.scene.repaint();	//Appel de la méthode PaintComponent de l'objet scene
			try {
				Thread.sleep(PAUSE);	//temps de pause du flux (4 ms)
			} catch (InterruptedException e) {}
		}
		
	}
	

}
