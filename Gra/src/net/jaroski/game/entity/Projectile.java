package net.jaroski.game.entity;

import java.util.Random;

import net.jaroski.game.graphics.Sprite;

public abstract class Projectile extends Entity {
	
	protected final double xOrigin, yOrigin;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected double speed, damage;
	protected double distance, range;
	protected int anim;
	
	protected Random random = new Random();
	
	public Projectile(double x, double y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		
		this.x=x;
		this.y=y;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	public int getSpriteSize() {
		return sprite.SIZE;
	}
	
	protected void move() {
		
	}
}
