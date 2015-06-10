package net.jaroski.game.entity.statistics;


/**
 * Klasa odpowiedzialna za obs³ugê ¿ycia Mobów
 * @author Jaroski
 *
 */
public class Health {
	private int maxHealth;
	private int health;
	
	public Health() {
		this.health=0;
	}
	
	public Health(int hp) {
		this.maxHealth=hp;
		this.health=hp;
	}
	
	public boolean isAlive() {
		if(this.health>0) {
			return true;
		} else {
			return false;
		}
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public double getHealthPerc() {
		return health/maxHealth*100;
	}
	
	public void setHealth(int hp) {
		this.health=hp;
	}
	
	public void setMaxHealth(int maxHP) {
		this.maxHealth=maxHP;
	}
	
	public void changeHealth(int hp) {
		if(this.health+hp > maxHealth) {
			this.health=maxHealth;
		} else {
			this.health+=hp;
		}
	}
	
	public void update() {
		
	}
}
