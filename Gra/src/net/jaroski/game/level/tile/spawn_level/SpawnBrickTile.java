package net.jaroski.game.level.tile.spawn_level;

import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.level.tile.Tile;

/**
 * Tile ceg³y
 * @author Jaroski
 *
 */
public class SpawnBrickTile extends Tile {

	public SpawnBrickTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return true;
	}
	
	public boolean breakable() {
		return true;
	}
	
}
