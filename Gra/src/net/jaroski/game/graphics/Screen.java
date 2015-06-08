package net.jaroski.game.graphics;

//import java.util.Random;

import net.jaroski.game.entity.Projectile;
import net.jaroski.game.entity.mob.Chaser;
import net.jaroski.game.entity.mob.Mob;
import net.jaroski.game.entity.mob.Star;
import net.jaroski.game.level.tile.Tile;

public class Screen {
	
	public int width, height;
	public int[] pixels;
	public int xOffset, yOffset;
	//private int playerSize = 32;
	private int mobSize = 32;
	
	//private Random random = new Random();
	
	public Screen(int width, int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear() {
		for(int i=0;i<pixels.length; i++) {
			pixels[i]=0;
		}
	}
	
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y=0;y<tile.sprite.SIZE; y++) {
			int ya = y + yp;
			for(int x=0;x<tile.sprite.SIZE; x++) {
				int xa = x + xp;
				if (xa < -tile.sprite.SIZE || xa >= width || ya < 0 || ya >= height) break;
				if (xa<0) xa=0;
				pixels[xa + ya * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
			}
		}
	}
	
	public void renderSheet(int xp, int yp, SpriteSheet sheet, boolean fixed) {
		if(fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for(int y=0; y < sheet.HEIGHT; y++) {
			int ya = y + yp;
			for(int x=0; x < sheet.WIDTH; x++) {
				int xa = x + xp;
				if (xa<0 || xa >= width || ya < 0 || ya >= height) continue;
				pixels[xa + ya * width] = sheet.pixels[x + y * sheet.WIDTH];
				
			}
		}
	}
	
	public void renderSprite(int xp, int yp, Sprite sprite, boolean fixed) {
		if(fixed) {
			xp -= xOffset;
			yp -= yOffset;
		}
		for(int y=0;y<sprite.getHeight(); y++) {
			int ya = y + yp;
			for(int x=0;x<sprite.getWidth(); x++) {
				int xa = x + xp;
				if (xa<0 || xa >= width || ya < 0 || ya >= height) continue;
				pixels[xa + ya * width] = sprite.pixels[x + y * sprite.getWidth()];
				
			}
		}
	}
	
	public void renderProjectile(int xp, int yp, Projectile p) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y=0;y<p.getSpriteSize(); y++) {
			int ya = y + yp;
			for(int x=0;x<p.getSpriteSize(); x++) {
				int xa = x + xp;
				if (xa < -p.getSpriteSize() || xa >= width || ya < 0 || ya >= height) break;
				if (xa<0) xa=0;
				//pixels[xa + ya * width] = p.getSprite().pixels[x + y * p.getSprite().SIZE];
				int col = p.getSprite().pixels[x + y * p.getSprite().SIZE];
				if(col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void renderMob(int xp, int yp, Mob mob) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y=0;y< mobSize; y++) {
			int ya = y + yp;
			for(int x=0;x< mobSize; x++) {
				int xa = x + xp;
				if (xa < -mobSize || xa >= width || ya < 0 || ya >= height) break;
				if (xa<0) xa=0;
				int col = mob.getSprite().pixels[x + y * mobSize];
				if (mob instanceof Chaser && col == 0xffFFD9AD) col = 0xffBA0015;
				if (mob instanceof Star && col == 0xffFFD9AD) col = 0xffE8E83A;
				if(col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void renderMob(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y=0;y< mobSize; y++) {
			int ya = y + yp;
			for(int x=0;x< mobSize; x++) {
				int xa = x + xp;
				if (xa < -mobSize || xa >= width || ya < 0 || ya >= height) break;
				if (xa<0) xa=0;
				int col = sprite.pixels[x + y * mobSize];
				if(col != 0xffff00ff) pixels[xa + ya * width] = col;
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}