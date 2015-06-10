package net.jaroski.game.entity.projectile;

import java.util.ArrayList;
import java.util.List;

import net.jaroski.game.entity.Entity;
import net.jaroski.game.entity.Projectile;
import net.jaroski.game.entity.mob.Mob;
import net.jaroski.game.entity.spawner.ParticleSpawner;
import net.jaroski.game.entity.spawner.Spawner;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;

/**
 * Klasa generuj¹ca WizardProjectile, czyli kulê ognia.
 * @author Jaroski
 *
 */
public class WizardProjectile extends Projectile{
	public static final int FIRE_RATE = 10; // higher is slower
	Entity owner;
	List<Mob> targets = new ArrayList<Mob>();
	
	/**
	 * Konstruktor WizardProjectile
	 * @param x Parametr pocz¹tkowy osi X
	 * @param y Parametr pocz¹tkowy osi Y
	 * @param sv K¹t atan2 dla toru lotu
	 * @param owner Entity które stworzy³o WizardProjectile
	 */
	public WizardProjectile(double x, double y, double sv, Entity owner) {
		super(x, y, sv);
		range = random.nextInt(100) + 150;
		speed = 2;
		damage = 20;
		anim = 0;
		this.owner = owner;
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
		
	}
	
	/**
	 * Aktualizacja logiki
	 */
	public void update() {
		//if(level.tileCollision(x, y, nx, ny)) {
		if(level.tileCollision((int)(x + nx), (int)(y + ny), 7, 3, 9)) {	
		
			level.add(new ParticleSpawner((int)x, (int)y, 30, Spawner.Type.PARTICLE, random.nextInt(35)+15, level));
			
			//nx = 0;
			//ny = 0;
			remove();
		}
		targets = level.getMobs(this, 100, owner);
		for(Mob m : level.getPlayers(this, 100, owner)) {
			targets.add(m);
		}
		for(Mob e : targets) {
			
			Entity colided = level.getEntityCollideMob(this, e);
			if(colided != null) {
				colided.hp.changeHealth(-1);
				System.out.println(owner.name + "'s WizardProjectile dealt damage to entity: " + colided.name);
				remove();
				//System.out.println("shoot removed");
			}
		}
		move();
		//System.out.println("X: " + x + " Y: " + y);
		if (anim < 500) anim++;
		else anim = 0;
	}
	
	/**
	 * Przesuniêcie WizardProjectile
	 */
	protected void move() {
		x += nx;
		y += ny;
		if(distance() > range) remove();
	}
	
	/**
	 * Zwraca odleg³oœæ przebyt¹ przez WizardProjectile
	 * @return Odleg³oœæ która WizardProjectile ju¿ przeszed³
	 */
	private double distance() {
		double dist = 0;
		dist = Math.sqrt(Math.abs((xOrigin - x)*(xOrigin-x) + (yOrigin - y) * (yOrigin - y)));
		
		return dist;
	}
	
	/**
	 * Render na ekranie
	 */
	public void render(Screen screen) {
		if(anim % 30 < 10) {
			sprite = Sprite.fireball1;
		} else if(anim % 30 < 20) {
			sprite = Sprite.fireball2;
		} else {
			sprite = Sprite.fireball3;
		}
		
		screen.renderProjectile((int)x - 8, (int)y - 2, this);
	}

}
