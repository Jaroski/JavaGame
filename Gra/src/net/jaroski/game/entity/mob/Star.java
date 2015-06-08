package net.jaroski.game.entity.mob;

import java.util.List;

import net.jaroski.game.entity.statistics.Health;
import net.jaroski.game.graphics.AnimatedSprite;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.graphics.SpriteSheet;
import net.jaroski.game.level.Node;
import net.jaroski.game.util.Vector2i;

public class Star extends Mob {

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 32, 32, 3);
	
	private AnimatedSprite animSprite = down;
	
	private List<Node> path;
	private int time = 0;
	
	public Star(int x, int y) {
		this.x = x<<4;
		this.y = y<<4;
		this.name = "Star";
		sprite = Sprite.dummy;
		speed=0.8;
		xa=0;
		ya=0;
		hp = new Health(12);
	}
	
	private void follow() {
		xa=0;
		ya=0;
		
		int px = (int)level.getPlayerAt(0).getX();
		int py = (int)level.getPlayerAt(0).getY();
		Vector2i start = new Vector2i((int)getX() >> 4, (int)getY() >> 4);
		Vector2i destination = new Vector2i(px >> 4, py >> 4);
		if (time % 30 == 0) path = level.findPath(start, destination);
		
		if(path != null) {
			if(path.size() > 0) {
				Vector2i vec = path.get(path.size()-1).tile;
				if(x < vec.getX() << 4) xa++;
				if(x > vec.getX() << 4) xa--;
				if(y < vec.getY() << 4) ya++;
				if(y > vec.getY() << 4) ya--;
			}
		}
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}
	
	public void update() {
		time++;
		
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
	
	
	
	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob((int)(x - 16), (int)(y - 16), this);
	}
}
