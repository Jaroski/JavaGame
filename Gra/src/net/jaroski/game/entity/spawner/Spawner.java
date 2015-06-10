package net.jaroski.game.entity.spawner;

import net.jaroski.game.entity.Entity;
import net.jaroski.game.level.Level;

/**
 * Klasa odpowiedzialna za Spawnowanie obiekt�w Entity na mapie
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
	 * Generowanie Obiekt�w na mapie
	 * @param x Koordynat X pocz�tkowy
	 * @param y Koordynat Y pocz�tkowy
	 * @param type Typ obiektu do wygenerowania
	 * @param amount Ilo�� Particlow do wygenerowania
	 * @param level Mapa na kt�rej maj� by� wygenerowane
	 */
	public Spawner(int x, int y, Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	
}
