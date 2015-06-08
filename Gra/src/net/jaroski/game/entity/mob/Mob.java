package net.jaroski.game.entity.mob;

import net.jaroski.game.entity.Entity;
import net.jaroski.game.entity.Projectile;
import net.jaroski.game.entity.projectile.WizardProjectile;

public abstract class Mob extends Entity {

	protected Direction dir;
	protected boolean walking = false;
	protected double xa, ya;
	protected double speed;
	
	protected enum Direction {
		UP, DOWN, LEFT, RIGHT
	}
	
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
	
	private double abs(double value) {
		if(value<0) return -1;
		return 1;
	}
	
	protected void shoot(double x, double y, double sv) {
		//sv *= 180 / Math.PI;
		Projectile p = new WizardProjectile(x, y, sv, this);
		level.add(p);
	}
	
	public void update() {
		
	}
	
	public boolean collision(double xa, double ya) {
		boolean solid = false;
		for (int c=0;c<4;c++) { // c = corner, sprawdzamy wszystkie rogi na kolizje
			double xt = ((x+xa) - c%2 * 16 +1) / 16;
			double yt = ((y+ya) - c/2 * 16 -1) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c % 2 == 0) ix = (int) Math.floor(xt);
			if(c / 2 == 0) iy = (int) Math.floor(yt);
			if(level.getTile(ix,iy+1).solid()) solid = true;
		}
		return solid;
		
	}
	
	public boolean isCollide(double xa, double ya) {
		if((xa > (x-11) && xa < (x+11)) && (ya > (y-11) && ya < (y+11))) return true;
		return false;
	}
	
	public void render() {
		
	}
	
}
