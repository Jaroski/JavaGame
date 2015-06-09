package net.jaroski.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Klasa rejestruj¹ca obs³ugê myszki
 * @author Jaroski
 *
 */
public class Mouse implements MouseListener, MouseMotionListener {

	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	
	/**
	 * Metoda zwracaj¹ca zmienn¹ X pozycji myszki
	 * @return Zwraca pozycjê X myszki
	 */
	public static int getX() {
		return mouseX;
	}
	
	/**
	 * Metoda zwracaj¹ca zmienna Y pozycji myszki
	 * @return Zwraca pozycje Y myszki
	 */
	public static int getY() {
		return mouseY;
	}
	
	/**
	 * Metoda zwracaj¹ca stan przycisku myszki
	 * @return Zwraca stan przycisku myszki
	 */
	public static int getButton() {
		return mouseB;
	}
	
	/**
	 * Aktualizacja pozycji myszki przez MouseEvent listener
	 */
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	/**
	 * Aktualizacja pozycji myszki przez MouseEvent listener
	 */
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	/**
	 * Metoda nie zaimplementowana
	 */
	public void mouseClicked(MouseEvent e) {
		
	}
	
	/**
	 * Metoda nie zaimplementowana
	 */
	public void mouseEntered(MouseEvent e) {
		
	}
	
	/**
	 * Metoda nie zaimplementowana
	 */
	public void mouseExited(MouseEvent e) {
		
	}
	
	/**
	 * Aktualizacja flagi przycisku myszki, ustawiaj¹ca dowolny przycisk myszki
	 */
	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
	}
	
	/**
	 * Uwolnienie stanu przycisków myszki
	 */
	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
	}

}
