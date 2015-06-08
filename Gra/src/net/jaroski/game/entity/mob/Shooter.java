package net.jaroski.game.entity.mob;

import java.util.List;

import net.jaroski.game.entity.Entity;
import net.jaroski.game.entity.projectile.WizardProjectile;
import net.jaroski.game.entity.statistics.Health;
import net.jaroski.game.graphics.AnimatedSprite;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.graphics.SpriteSheet;
import net.jaroski.game.util.Vector2i;

public class Shooter extends Mob{
	
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.dummy_down, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.dummy_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.dummy_right, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.dummy_up, 32, 32, 3);
	private AnimatedSprite animSprite = down;
	
	private double fireRate = 30;
	private double fire = 0;
	private int time = 0;
	
	public Shooter(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		this.name = "Shooter";
		sprite = Sprite.dummy;
		//fireRate = WizardProjectile.FIRE_RATE;
		fire=fireRate;
		speed=0.5;
		xa=0;
		ya=0;
		hp = new Health(3);
	}
	
	public Shooter(int x, int y, int hp) {
		this.x = x << 4;
		this.y = y << 4;
		this.name = "Shooter";
		sprite = Sprite.dummy;
		//fireRate = WizardProjectile.FIRE_RATE;
		fire=fireRate;
		speed=0.5;
		xa=0;
		ya=0;
		this.hp = new Health(hp);
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
		
		if(fire > 0) fire--;
		if(fire==0) shooting();
		if(!hp.isAlive()) remove();
	}
	
	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob((int)x -16, (int)y -16, this);
	}
	
	public void shooting() {
		List<Entity> entities = level.getEntities(this, 50);
		entities.add(level.getClientPlayer());
		
		double range = 50;
		Entity closest = null;
		for(int i=0; i < entities.size();i++) {
			Entity e = entities.get(i);
			double distance = Vector2i.getDistance(new Vector2i(x, y), new Vector2i(e.getX(), e.getY()));
			if(distance < range) {
				
				closest = e;
				}
		}
		if(closest != null) {
			double dx = closest.getX() - x;
			double dy = closest.getY() - y;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
		}
		this.fire=fireRate;
	}
	
}
