package net.jaroski.game.entity.mob;

import net.jaroski.game.entity.statistics.Health;
import net.jaroski.game.graphics.AnimatedSprite;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.graphics.SpriteSheet;

public class Dummy extends Mob{
	
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 32, 32, 3);
	
	private AnimatedSprite animSprite = down;
	
	private int time = 0;
	
	
	public Dummy(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		this.name = "Dummy";
		sprite = Sprite.dummy;
		speed=0.5;
		xa=0;
		ya=0;
		hp = new Health(5);
	}
	
	public void update() {
		time++;
		
		if (time % (random.nextInt(50)+20) == 0) {
			xa = (random.nextInt(3) - 1)*speed;
			ya = (random.nextInt(3) - 1)*speed;
			if(random.nextInt(4) == 0) {
				xa=0;
				ya=0;
			}
		}
		
		
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
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		
		if(!hp.isAlive()) remove();
	}
	
	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob((int)(x-16), (int)(y-16), sprite);
	}
}
