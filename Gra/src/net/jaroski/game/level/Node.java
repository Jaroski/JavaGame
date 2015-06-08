package net.jaroski.game.level;

import net.jaroski.game.util.Vector2i;

public class Node {
	
	public Vector2i tile;
	public Node parent;
	public double fCost, gCost, hCost; // g = cost from start, h = cost to end, f = ~const cost of whole way
	
	public Node(Vector2i tile, Node parent, double gCost, double hCost) {
		this.tile = tile;
		this.parent = parent;
		this.gCost = gCost;
		this.hCost = hCost;
		this.fCost = this.gCost + this.hCost;
	}
	
	
	
}
