package net.jaroski.game.level;

/**
 * Klasa przeliczaj�ca koordynaty na piksele, oraz odwrotnie
 * @author Jaroski
 *
 */
public class TileCoordinate {
	private int x, y;
	private final int TILE_SIZE = 16;
	
	/**
	 * Przelicza koordynaty (X,Y) z mapy na pikselow� pozycj� kafelki
	 * @param x Koordynat X z mapy
	 * @param y Koordynat Y z mapy
	 */
	public TileCoordinate(int x, int y) {
		this.x=x * TILE_SIZE;
		this.y=y * TILE_SIZE;
	}
	/**
	 * Zwraca sam� wsp�rz�dn� X
	 * @return Zwraca wsp�rz�dn� X
	 */
	public int getX() {
		return x;
	}
	/**
	 * Zwraca sam� wsp�rz�dn� Y
	 * @return Zwraca wsp�rz�dn� Y
	 */
	public int getY() {
		return y;
	}
	/**
	 * Zwraca tablic� koordynat�w X i Y
	 * @return Zwraca tablic� koordynat�w X i Y
	 */
	public int[] getXY() {
		int[] r = new int[2];
		r[0] = x;
		r[1] = y;
		return r;
	}
}
