package net.jaroski.game.entity.spawner;

import net.jaroski.game.entity.particle.Particle;
import net.jaroski.game.level.Level;

public class ParticleSpawner extends Spawner{
	//private int life;

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
