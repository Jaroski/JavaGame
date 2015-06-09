package net.jaroski.game.entity;

import java.util.Random;

import net.jaroski.game.entity.statistics.Health;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.level.Level;

/**
 * Klasa g³ówna dla obiektów wystêpuj¹cych w grze. Ka¿dy obiekt po niej dziedziczy.
 * @author Jaroski
 *
 */
public class Entity {
	
	protected double x, y;
	private boolean removed = false;
	protected Sprite sprite;
	protected Level level;
	protected final Random random = new Random();
	public Health hp;
	public String name = null;
	
	public Entity() {
		
	}
	
	/**
	 * Konstruktor obiektu Entity
	 * @param x Pozycja X poczatkowa
	 * @param y Pozycja Y pocz¹tkowa
	 * @param sprite Sprite danego obiektu
	 */
	public Entity(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		
	}
	
	/**
	 * Abstrakcyjna metoda która jest nadpisywana na nastêpnych poziomach obiektu
	 */
	public void update() {
		
	}
	
	/**
	 * Metoda renderuj¹ca obiekt na ekranie Screen
	 * @param screen Przekazanie obrazu na którym ma byæ renderowany obiekt
	 */
	public void render(Screen screen) {
		if (sprite!=null) screen.renderSprite((int)x, (int)y, sprite, true);
	}
	
	/**
	 * Metoda s³u¿¹ca do usuwania obiektów
	 */
	public void remove() {
		// remove from level
		removed = true;
	}
	
	/**
	 * Metoda sprawdzaj¹ca czy obiekt jest usuniêty
	 * @return zwraca TRUE jeœli obiekt jest usuniêty, albo FALSE je¿eli obiekt wci¹¿ istnieje
	 */
	public boolean isRemoved() {
		return removed;
	}
	
	/**
	 * Metoda zwracaj¹ca Sprite danego obiektu
	 * @return Zwraca Sprite danego obiektu
	 */
	public Sprite getSprite() {
		return sprite;
	}
	
	/**
	 * Zwraca X danego obiektu
	 * @return Zwraca X danego obiektu
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Zwraca Y danego obiektu
	 * @return Zwraca Y danego obiektu
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Metoda inicjalizuj¹ca Level dla obiektu
	 * @param level Parametr Level'u na którym inicjalizujemy dany obiekt
	 */
	public void init(Level level) {
		this.level = level;
	}
	
}
