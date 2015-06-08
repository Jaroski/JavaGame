package net.jaroski.game.level;

/**
 * Klasa przeliczaj¹ca koordynaty na piksele, oraz odwrotnie
 * @author Jaroski
 *
 */
public class TileCoordinate {
	private int x, y;
	private final int TILE_SIZE = 16;
	
	/**
	 * Przelicza koordynaty (X,Y) z mapy na pikselow¹ pozycjê kafelki
	 * @param x Koordynat X z mapy
	 * @param y Koordynat Y z mapy
	 */
	public TileCoordinate(int x, int y) {
		this.x=x * TILE_SIZE;
		this.y=y * TILE_SIZE;
	}
	/**
	 * Zwraca sam¹ wspó³rzêdn¹ X
	 * @return Zwraca wspó³rzêdn¹ X
	 */
	public int getX() {
		return x;
	}
	/**
	 * Zwraca sam¹ wspó³rzêdn¹ Y
	 * @return Zwraca wspó³rzêdn¹ Y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Zwraca tablicê koordynatów X i Y
	 * @return Zwraca tablicê koordynatów X i Y
	 */
	public int[] getXY() {
		int[] r = new int[2];
		r[0] = x;
		r[1] = y;
		return r;
	}
}
