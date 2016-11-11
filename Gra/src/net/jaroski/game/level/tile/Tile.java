package net.jaroski.game.level.tile;

import net.jaroski.game.graphics.Screen;
import net.jaroski.game.graphics.Sprite;
import net.jaroski.game.level.tile.spawn_level.*;

/**
 * Podstawowa obs³uga Tile dla wszystkich tekstur w grze
 * @author Jaroski
 *
 */
public class Tile {
	
	
	public Sprite sprite;
	
	// spawn tiles
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_stone = new SpawnStoneTile(Sprite.spawn_stone);
	public static Tile spawn_redbrick = new SpawnBrickTile(Sprite.spawn_redbrick);
	public static Tile spawn_graybrick = new SpawnBrickTile(Sprite.spawn_graybrick);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_point = new SpawnPointTile(Sprite.spawn_point);
	
	public final static int col_spawn_grass = 0xff19FF00;
	public final static int col_spawn_stone = 0xffA0A0A0;
	public final static int col_spawn_redbrick = 0xff404040;
	public final static int col_spawn_graybrick = 0xff808080;
	public final static int col_spawn_water = 0xff0000FF;
	public final static int col_spawn_point = 0xff19FFF7;
	
	// level tiles
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile stone = new StoneTile(Sprite.stone);
	public static Tile brick = new RedBrickTile(Sprite.brick);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	/**
	 * Render do przeci¹¿enia
	 * @param x X
	 * @param y Y
	 * @param screen screen
	 */
	public void render(int x, int y, Screen screen) {
		
	}
	
	/**
	 * Czy tile jest w formie przeszkody
	 * @return FALSE je¿eli Tile nie jest przeszkoda, TRUE je¿eli jest
	 */
	public boolean solid() {
		return false;
	}
	
	/**
	 * Czy mo¿na chodziæ po Tile
	 * @return FALSE je¿eli mozna chodzic po Tile, TRUE jeœli nie mozna  
	 */
	public boolean notWalkable() {
		return false;
	}
	
	public boolean isBreakable() {
		return false;
	}
}
