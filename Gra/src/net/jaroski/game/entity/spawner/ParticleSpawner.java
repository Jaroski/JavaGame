package net.jaroski.game.entity.spawner;

import net.jaroski.game.entity.particle.Particle;
import net.jaroski.game.level.Level;

/**
 * Klasa generuj¹ca Particle na zderzeniu siê WizardProjectile z obiektem sta³ym kolizyjnym
 * @author Jaroski
 *
 */
public class ParticleSpawner extends Spawner{
	//private int life;
	
	/**
	 * Metoda generuj¹ca Particle
	 * @param x Koordynat X pocz¹tkowy
	 * @param y Koordynat Y pocz¹tkowy
	 * @param life Czas ¿ycia Particla
	 * @param type Typ obiektu do wygenerowania
	 * @param amount Iloœæ Particlow do wygenerowania
	 * @param level Mapa na której maj¹ byæ wygenerowane
	 */
	public ParticleSpawner(int x, int y, int life, Type type, int amount, Level level) {
		super(x, y, Type.PARTICLE, amount, level);
		//this.life = life;
		for(int i=0;i<amount;i++) {
			if(type == Type.PARTICLE) {
				level.add(new Particle(x, y, life));
			}
		}
	}
	
	
	
}
