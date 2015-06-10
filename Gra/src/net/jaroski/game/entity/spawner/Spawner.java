package net.jaroski.game.entity.spawner;

import net.jaroski.game.entity.Entity;
import net.jaroski.game.level.Level;

/**
 * Klasa odpowiedzialna za Spawnowanie obiektów Entity na mapie
 * @author Jaroski
 *
 */
public class Spawner extends Entity {
	
	/**
	 * Typ Obiektu do Spawnowania
	 * @author Jaroski
	 *
	 */
	public enum Type {
		MOB, PARTICLE;
	}
	
	@SuppressWarnings("unused")
	private Type type;
	
	/**
	 * Generowanie Obiektów na mapie
	 * @param x Koordynat X pocz¹tkowy
	 * @param y Koordynat Y pocz¹tkowy
	 * @param type Typ obiektu do wygenerowania
	 * @param amount Iloœæ Particlow do wygenerowania
	 * @param level Mapa na której maj¹ byæ wygenerowane
	 */
	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	
}
