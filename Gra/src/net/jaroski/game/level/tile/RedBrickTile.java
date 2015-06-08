package net.jaroski.game.level.tile;

import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;

public class RedBrickTile extends Tile {

	public RedBrickTile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	

}
