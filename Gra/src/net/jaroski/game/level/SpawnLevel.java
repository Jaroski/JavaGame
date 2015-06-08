package net.jaroski.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.jaroski.game.entity.mob.Chaser;
import net.jaroski.game.entity.mob.Dummy;
import net.jaroski.game.entity.mob.Shooter;
import net.jaroski.game.entity.mob.Star;


public class SpawnLevel extends Level {
	
	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
		}
		
		add(new Chaser(20, 55));
		add(new Star(17, 35));
		//add(new Shooter(20, 55));
		add(new Dummy(20, 55));
		add(new Shooter(20, 62));
		for(int i=0;i<5;i++) {
			add(new Dummy(20, 55));
			
		}
	}
	
	// spawn_grass = 0xff19FF00
	// spawn_stone = 0xffA0A0A0
	// spawn_redbrick = 0xff404040
	// spawn_graybrick = 0xff808080
	// spawn_water = 0xff0000FF
	// spawn_point = 0xff19FFF7
	
	protected void generateLevel() {
		
	}
}
