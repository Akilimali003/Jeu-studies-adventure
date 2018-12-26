package com.vijeygamedesigner.jeu;

import javax.swing.JFrame;


public class Main {
	
	public static Scene scene;

	public static void main(String[] args) {
		
		// création de la fenêtre de l'application
		JFrame fenetre = new JFrame("Studies adventure");
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetre.setSize(700, 360);
		fenetre.setLocationRelativeTo(null);
		fenetre.setResizable(false);
		fenetre.setAlwaysOnTop(true);
		
		//instantiation de l'objet scene
		scene = new Scene();
		
		fenetre.setContentPane(scene);	// on associe la scène à la fenêtre de l'application
		fenetre.setVisible(true);
	}
}
