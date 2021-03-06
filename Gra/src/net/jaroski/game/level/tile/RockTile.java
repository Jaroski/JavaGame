package net.jaroski.game.level.tile;

import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;

/**
 * Aktualnie wycofane z implementacji
 * @author Jaroski
 *
 */
public class RockTile extends Tile {
	
	public RockTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return true;
	}
}
