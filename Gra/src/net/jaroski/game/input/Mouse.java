package net.jaroski.game.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Klasa rejestruj�ca obs�ug� myszki
 * @author Jaroski
 *
 */
public class Mouse implements MouseListener, MouseMotionListener {

	private static int mouseX = -1;
	private static int mouseY = -1;
	private static int mouseB = -1;
	
	/**
	 * Metoda zwracaj�ca zmienn� X pozycji myszki
	 * @return Zwraca pozycj� X myszki
	 */
	public static int getX() {
		return mouseX;
	}
	
	/**
	 * Metoda zwracaj�ca zmienna Y pozycji myszki
	 * @return Zwraca pozycje Y myszki
	 */
	public static int getY() {
		return mouseY;
	}
	
	/**
	 * Metoda zwracaj�ca stan przycisku myszki
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
	 * Aktualizacja flagi przycisku myszki, ustawiaj�ca dowolny przycisk myszki
	 */
	public void mousePressed(MouseEvent e) {
		mouseB = e.getButton();
	}
	
	/**
	 * Uwolnienie stanu przycisk�w myszki
	 */
	public void mouseReleased(MouseEvent e) {
		mouseB = -1;
	}

}
