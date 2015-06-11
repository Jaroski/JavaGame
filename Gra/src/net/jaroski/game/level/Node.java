package net.jaroski.game.level;

import net.jaroski.game.util.Vector2i;

/**
 * Klasa tworz�ca Node do cel�w obliczeniowych
 * @author Jaroski
 *
 */
public class Node {
	
	public Vector2i tile;
	public Node parent;
	public double fCost, gCost, hCost; // g = koszt od pocz�tku, h = koszt do ko�ca, f = ~const kosztu ca�ej drogi
	
	public Node(Vector2i tile, Node parent, double gCost, double hCost) {
		this.tile = tile;
		this.parent = parent;
		this.gCost = gCost;
		this.hCost = hCost;
		this.fCost = this.gCost + this.hCost;
	}
	
	
	
}
