package com.vijeygamedesigner.jeu;

import javax.swing.JFrame;


public class Main {
	
	public static Scene scene;

	public static void main(String[] args) {
		
		// cr�ation de la fen�tre de l'application
		JFrame fenetre = new JFrame("Studies adventure");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700, 360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		//instantiation de l'objet scene
		scene = new Scene();
		
		fenetre.setContentPane(scene);	// on associe la sc�ne � la fen�tre de l'application
		fenetre.setVisible(true);
	}
}
