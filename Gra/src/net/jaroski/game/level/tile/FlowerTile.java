package net.jaroski.game.level.tile;

import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;

public class FlowerTile extends Tile {
	
	public FlowerTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
