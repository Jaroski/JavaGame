package net.jaroski.game.level.tile.spawn_level;

import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.level.tile.Tile;

/**
 * Tile trawy
 * @author Jaroski
 *
 */
public class SpawnGrassTile extends Tile{

	public SpawnGrassTile(Sprite sprite) {
		super(sprite);
		
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
}
