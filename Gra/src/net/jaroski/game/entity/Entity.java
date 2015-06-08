package net.jaroski.game.entity;

import java.util.Random;

import net.jaroski.game.entity.statistics.Health;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.level.Level;

public class Entity {
	
	protected double x, y;
	private boolean removed = false;
	protected Sprite sprite;
	protected Level level;
	protected final Random random = new Random();
	public Health hp;
	public String name = null;
	
	public Entity() {
		
	}
	
	public Entity(int x, int y, Sprite sprite) {
		this.x = x;
		this.y = y;
		this.sprite = sprite;
		
	}
	
	public void update() {
		
	}
	
	public void render(Screen screen) {
		if (sprite!=null) screen.renderSprite((int)x, (int)y, sprite, true);
	}
	
	public void remove() {
		// remove from level
		removed = true;
	}
	
	public boolean isRemoved() {
		return removed;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void init(Level level) {
		this.level = level;
	}
	
}
