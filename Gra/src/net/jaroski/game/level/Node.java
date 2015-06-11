package net.jaroski.game.level;

import net.jaroski.game.util.Vector2i;

/**
 * Klasa tworz¹ca Node do celów obliczeniowych
 * @author Jaroski
 *
 */
public class Node {
	
	public Vector2i tile;
	public Node parent;
	public double fCost, gCost, hCost; // g = koszt od pocz¹tku, h = koszt do koñca, f = ~const kosztu ca³ej drogi
	
	public Node(Vector2i tile, Node parent, double gCost, double hCost) {
		this.tile = tile;
		this.parent = parent;
		this.gCost = gCost;
		this.hCost = hCost;
		this.fCost = this.gCost + this.hCost;
	}
	
	
	
}
