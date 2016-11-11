package net.jaroski.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klasa rejestruj¹ca wszelkie naciœniêcia przycisków na klawiaturze
 * @author Jaroski
 *
 */
public class Keyboard implements KeyListener{
	
	private boolean[] keys = new boolean[200];
	public boolean up, down, left, right;
	public boolean pause;
	
	/**
	 * Aktualizacja zmiennej boolean dla oflagowanych przycisków
	 */
	public void update() {
		up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
		pause = keys[KeyEvent.VK_P];
		/*
		// console check
		for(int i=0 ; i < keys.length; i++) {
			if(keys[i]) {
				System.out.println("KEY: " + i);
			}
		}*/
	}
	
	/**
	 * Zmiana flagi dla naciœniêtego przycisku na TRUE
	 */
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		
	}

	/**
	 * Zmiana flagi dla naciœniêtego przycisku na FALSE
	 */
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		
	}
	
	/**
	 * Metoda nie jest zaimplementowana
	 */
	public void keyTyped(KeyEvent e) {
		
		
	}
	
}
