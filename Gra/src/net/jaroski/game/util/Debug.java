package net.jaroski.game.util;

import net.jaroski.game.graphics.Screen;

public class Debug {
	
	private Debug() {
		
	}
	
	public static void drawRect(Screen screen, int x, int y, int width, int height, boolean fixed) {
		screen.drawRect(x, y, width, height, 0xFF00FF, fixed);
	}
	
	public static void drawRect(Screen screen, int x, int y, int width, int height, int col, boolean fixed) {
		screen.drawRect(x, y, width, height, col, fixed);
	}
}
