package com.vijeygamedesigner.jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.vijeygamedesigner.audio.Audio;

public class Clavier implements KeyListener{

	@Override
	public void keyPressed(KeyEvent e) {
		if(Main.scene.cyclops.isVivant() == true){
		if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(Main.scene.getxPos() == -1){
				Main.scene.setxPos(0);		//R�initialisation de xPos
				Main.scene.setxFond1(-50);	//R�initialisation de xFond1
				Main.scene.setxFond2(750);	//R�initialisation de xFond2	
			}
			
			Main.scene.cyclops.setMarche(true);
			Main.scene.cyclops.setVersDroite(true);
			Main.scene.setDx(1);	//D�placement du fond vers la gauche lors de l'appuis sur la touche "fl�che droite"
			
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT){	//Fl�che gauche
			Main.scene.cyclops.setMarche(true);
			Main.scene.cyclops.setVersDroite(false);
			Main.scene.setDx(-1);	//D�placement du fond vers la droite lors de l'appuis sur la touche "fl�che gauche"
			
			if(Main.scene.getxPos() == 4645){
				Main.scene.setxPos(4625);
				Main.scene.setxFond1(-50);
				Main.scene.setxFond2(750);
			}
		}
		//cyclops saute
		if(e.getKeyCode() == KeyEvent.VK_SPACE){
			Main.scene.cyclops.setSaut(true);
			Audio.playSound("/audio/saut.wav");
		}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Main.scene.cyclops.setMarche(false);
		Main.scene.setDx(0);	//Remise � 0 de la variable dx de l'objet scene
		}						//lors du relachement des touches
	
	@Override
	public void keyTyped(KeyEvent e) {}

}
