package net.jaroski.game.entity.particle;

import net.jaroski.game.entity.Entity;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;

/**
 * Klasa obs³uguj¹ca Particle, czyli odbryzgi przy zde¿eniu siê WizardProjectile ze sta³ym obiektem kolizyjnym.
 * @author Jaroski
 *
 */
public class Particle extends Entity {
	
	private Sprite sprite;
	
	private int life;
	//private int time = 0;
	
	protected double xx, yy, zz;
	protected double xa, ya, za;
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param life
	 */
	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.xx = x;
		this.yy = y;
		this.life = life + (random.nextInt(30) - 15);
		sprite = Sprite.particle_normal;
		// +1.5 - particle + w prawo, xa<0 -> w prawo kompletnie
		
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
		this.zz = random.nextFloat() + 2.0;
	}
	
	public void update() {
		life--;
		if(life <= 0) remove();
		za -= 0.1;
		
		if(zz < 0) {
			zz = 0;
			za *= -0.5;
			xa *= 0.4;
			ya *= 0.4;
		}
		
		move((xx + xa), (yy+ ya) + (zz + za));
			
		
	}
	
	private void move(double x, double y) {
		if(collision(x, y)) {
			this.xa *= -0.5;
			this.ya *= -0.5;
			this.za *= -0.5;
		}
		
		this.xx += xa;
		this.yy += ya;
		this.zz += za;
	}
	
	public boolean collision(double x, double y) {
		boolean solid = false;
		for(int c=0; c<4;c++) {
			double xt = (x - c % 2 * 16) / 16;
			double yt = (y - c / 2 * 16) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if(c%2 == 0) ix = (int) Math.floor(xt);
			if(c/2 == 0) iy = (int) Math.floor(yt); 
			
			if(level.getTile(ix, iy).solid()) solid = true;
		}
		return solid;
	}
	
	public void render(Screen screen) {
		screen.renderSprite((int)xx, (int)yy - (int)zz, sprite, true);
	}
	
}
