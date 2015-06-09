package net.jaroski.game.entity;

import java.util.Random;

import net.jaroski.game.graphics.Sprite;

/**
 * Abstrakcyjna klasa obiektu Projectile dla wszelkiego rodzaju pocisk�w na mapie
 * @author Jaroski
 *
 */
public abstract class Projectile extends Entity {
	
	protected final double xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected double speed, damage;
	protected double distance, range;
	protected int anim;
	
	protected Random random = new Random();
	
	/**
	 * Konstruktor tworz�cy obiekt Projectile do dalszego wykorzystania
	 * @param x Pocz�tkowa pozycja X pocisku
	 * @param y Pocz�tkowa pozycja Y pocisku
	 * @param dir Kierunek w kt�rym si� przemieszcza pocisk
	 */
	public Projectile(double x, double y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Zwraca Sprite danego pocisku
	 */
	public Sprite getSprite() {
		return sprite;
	}
	
	/**
	 * Zwraca rozmiar Sprite'u danego pocisku
	 * @return Zwraca rozmiar Sprite'u
	 */
	public int getSpriteSize() {
		return sprite.SIZE;
	}
	
	/**
	 * Metoda s�u��ca do poruszania pocisku
	 */
	protected void move() {
		
	}
}
