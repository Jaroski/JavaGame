package net.jaroski.game.entity.mob;

import net.jaroski.game.entity.Entity;
import net.jaroski.game.entity.Projectile;
import net.jaroski.game.entity.projectile.WizardProjectile;

/**
 * Klasa abstrakcyjna przedstawiaj¹ca Moba, ka¿dy NPC oraz gracz musi po niej dziedziczyæ
 * @author Jaroski
 *
 */
public abstract class Mob extends Entity {

	protected Direction dir;
	protected boolean walking = false;
	protected double xa, ya;
	protected double speed;
	
	/**
	 * Enum przedstawiaj¹cy kierunek moba na mapie, UP, DOWN, LEFT, RIGHT
	 * @author Jaroski
	 *
	 */
	protected enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
	/**
	 * Metoda poruszaj¹ca moby, dla parametru X i Y poruszamy moby osobno, aby nie traciæ ukoœnej kolizji dla pewnych parametrów
	 * @param xa ruch w osi X
	 * @param ya ruch w osi Y
	 */
	public void move(double xa, double ya) {
		if(xa!=0 && ya!=0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		
		if(xa>0) dir = Direction.RIGHT; // right x++
		if(xa<0) dir = Direction.LEFT; // left x--
		if(ya>0) dir = Direction.DOWN; // down y++
		if(ya<0) dir = Direction.UP; // up y--
		
		// precise movement
		while(xa != 0) { // if xa = 1.4
			if(Math.abs(xa) > 1) { // xa -1 = 0.4 -> ruszamy o 1, zostaje 0.4
				if(!collision(abs(xa), ya)) {
					this.x+=abs(xa);
				}
				xa-=abs(xa);
			} else {
				if(!collision(abs(xa), ya)) {
					this.x+=xa;
				}
				xa=0;
			}
		}
		while(ya != 0) { // if ya = 1.4
			if(Math.abs(ya) > 1) { // ya -1 = 0.4 -> ruszamy o 1, zostaje 0.4
				if(!collision(xa, abs(ya))) {
					this.y+=abs(ya);
				}
				ya-=abs(ya);
			} else {
				if(!collision(xa, abs(ya))) {
					this.y+=ya;
				}
				ya=0;
			}
		}
		
		if(!collision(xa, ya)){
			x+=xa;
			y+=ya;
		}
	}
	
	/**
	 * Wartoœæ abs
	 * @param value parametr
	 * @return zwraca 1 dla wartoœci value wieksza rowna 0, albo 1 dla value mniejsza od 0
	 */
	private double abs(double value) {
		if(value<0) return -1;
		return 1;
	}
	
	/**
	 * Metoda strzelaj¹ca WizardProjectilem
	 * @param x miejsce pocz¹tkowe w osi X
	 * @param y miejsce pocz¹tkowe w osi Y
	 * @param sv k¹t strza³u atan2
	 */
	protected void shoot(double x, double y, double sv) {
		//sv *= 180 / Math.PI;
		Projectile p = new WizardProjectile(x, y, sv, this);
		level.add(p);
	}
	
	/**
	 * Metoda abstrakcyjna do aktualizacji logiki
	 */
	public void update() {
		
	}
	
	/**
	 * Metoda sprawdzaj¹ca kolizjê dla ruchu
	 * @param xa parametr w osi X
	 * @param ya parametr w osi Y
	 * @return Zwraca TRUE je¿eli nie mo¿na wykonaæ ruchu, albo FALSE je¿eli mo¿na wykonaæ ruch
	 */
	
	public boolean collision(double xa, double ya) {
		boolean walkable = false;
		for (int c=0;c<4;c++) { // c = corner, sprawdzamy wszystkie rogi na kolizje
			double xt = ((x+xa) - c%2 * 16 +1) / 16;
			double yt = ((y+ya) - c/2 * 16 -1) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c % 2 == 0) ix = (int) Math.floor(xt);
			if(c / 2 == 0) iy = (int) Math.floor(yt);
			if(level.getTile(ix,iy+1).notWalkable()) walkable = true;
			
		}
		
		return walkable;
		
	}
	
	/**
	 * Metoda sprawdzaj¹ca kolizjê parametrów xa i ya z mobem
	 * @param xa parametr osi X
	 * @param ya parametr osi Y
	 * @return Zwraca TRUE je¿eli wystêpuje kolizja, FALSE je¿eli kolizji brak
	 */
	public boolean isCollide(double xa, double ya) {
		if((xa > (x-11) && xa < (x+11)) && (ya > (y-11) && ya < (y+11))) return true;
		return false;
	}
	
	/**
	 * Metoda abstrakcyjna do renderu moba
	 */
	public void render() {
		
	}
	
}
