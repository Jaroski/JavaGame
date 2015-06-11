package net.jaroski.game.level.tile;

import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;

/**
 * Tile je¿eli nie mamy podanego w danym miejscu Tile, a trzeba go narysowaæ
 * @author Jaroski
 *
 */
public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	
}
