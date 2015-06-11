package net.jaroski.game.level;

import java.util.Random;

/**
 * Stara klasa s�u��ca do generowania losowej mapy, zostawiona na wszelki wypadek dla ewentualnych test�w
 * @author Jaroski
 *
 */
public class RandomLevel extends Level {
	private static final Random random = new Random();
	
	public RandomLevel(int width, int height) {
		super(width, height);
		
	}
	
	protected void generateLevel() {
		for(int y=0;y<height;y++) {
			for(int x=0;x<width;x++) {
				tilesInt[x+y*width] = random.nextInt(4);
				
			}
		}
	}
	
	
	
}
