package net.jaroski.game.entity.mob;

import java.util.List;

import net.jaroski.game.entity.statistics.Health;
import net.jaroski.game.graphics.AnimatedSprite;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.graphics.SpriteSheet;

/**
 * Klasa przedstawiaj¹ca Moba Chaser, jest to mob który goni gracza w sposób na si³e po prostej linii.
 * @author Jaroski
 *
 */
public class Chaser extends Mob{
	
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 32, 32, 3);
	
	private AnimatedSprite animSprite = down;
	
	/**
	 * Inicjalizacja moba
	 * @param x koordynat X moba na mapie, gdzie X jest miejscem pixelowym
	 * @param y koordynat Y moba na mapie, gdzie Y jest miejscem pixelowym
	 */
	public Chaser(int x, int y) {
		this.x = x<<4;
		this.y = y<<4;
		this.name = "Chaser";
		sprite = Sprite.dummy;
		speed=0.8;
		xa=0;
		ya=0;
		hp = new Health(8);
	}
	
	/**
	 * Funkcja specjalna moba.
	 * Daje mobowi mo¿liwoœæ œledzenia gracza.
	 */
	private void follow() {
		xa=0;
		ya=0;
		//Player player = level.getClientPlayer();
		List<Player> players = level.getPlayers(this, 100);
		
		if(players.size() > 0) {
			Player player = players.get(0);
			if((int)x < (int)player.getX()) xa+=speed;
			if((int)x > (int)player.getX()) xa-=speed;
			if((int)y < (int)player.getY()) ya+=speed;
			if((int)y > (int)player.getY()) ya-=speed;
			//if((int)x == (int)player.getX()) xa=0;
			//if((int)y == (int)player.getY()) ya=0;
		}


		if(xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}
	
	/**
	 * Aktualizacja logiki moba
	 */
	public void update() {
		
		
		if(walking) animSprite.update();
		else animSprite.setFrame(0);
		if (ya < 0) {
			animSprite = up;
			dir = Direction.UP;
		} else if (ya > 0) {
			animSprite = down;
			dir = Direction.DOWN;
		}
		if (xa < 0) {
			animSprite = left;
			dir = Direction.LEFT;
		} else if (xa > 0) {
			animSprite = right;
			dir = Direction.RIGHT;
		}
		
		follow();
		if(!hp.isAlive()) remove();
	}
	
	/**
	 * Render moba na ekranie
	 */
	
	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob((int)(x - 16), (int)(y - 16), this);
	}
}
