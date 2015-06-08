package net.jaroski.game.entity.mob;

import net.jaroski.game.Game;
import net.jaroski.game.entity.Projectile;
import net.jaroski.game.entity.projectile.WizardProjectile;
import net.jaroski.game.entity.statistics.Health;
import net.jaroski.game.graphics.AnimatedSprite;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.graphics.SpriteSheet;
import net.jaroski.game.input.Keyboard;
import net.jaroski.game.input.Mouse;
import net.jaroski.game.level.Level;

public class Player extends Mob {
	
	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private double fireRate = 0;
	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32, 32, 3);
	
	private AnimatedSprite animSprite = null;
	
	public Player(Keyboard input) {
		this.input = input;
		
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		this.name = "Player";
		fireRate = WizardProjectile.FIRE_RATE;
		animSprite = down;
		speed = 1;
		xa=0.0;
		ya=0.0;
		hp = new Health(10);
	}
	
	public void update() {
		xa=0;
		ya=0;
		if(walking) animSprite.update();
		else animSprite.setFrame(0);
		if(fireRate > 0) fireRate--;
		if (anim < 7500) anim++;
		else anim = 0;
		if (input.up) {
			ya-=speed;
			animSprite = up;
		} else if (input.down) {
			ya+=speed;
			animSprite = down;
		}
		if (input.left) {
			xa-=speed;
			animSprite = left;
		} else if (input.right) {
			xa+=speed;
			animSprite = right;
		}
		
		clear();
		updateShooting();
		
		if(xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		//if(!hp.isAlive()) remove();
	}
	
	private void clear() {
		for (int i=0;i<level.getProjectiles().size();i++) {
			Projectile p = level.getProjectiles().get(i);
			if(p.isRemoved()) level.getProjectiles().remove(i);
		}
	}

	private void updateShooting() {
		if(Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double sv = Math.atan2(dy, dx); // shoot vector
			
			//System.out.println(Level.getEntity(Mouse.getX(), Mouse.getY())); // trzeba ogarnac pozycje klikniecia myszka, aby wskazywala miejsce na mapie, a nie w oknie
			// do tego jeszcze zmienilem w Level liste entities[] i metode getEntity() na static
			shoot(x, y, sv);
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}
	
	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob((int)(x-16), (int)(y-16), sprite);
	}
	
	
}
