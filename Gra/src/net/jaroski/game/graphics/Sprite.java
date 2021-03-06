package net.jaroski.game.graphics;

/**
 * Obs�uga Sprite'ow obiekt�w
 * @author Jaroski
 *
 */
public class Sprite {
	   
	public final int SIZE;
	private int width, height;
	private int x, y;
	public int[] pixels;
	protected SpriteSheet sheet;
	
	//Spawn Level Sprites Sheets:
	public static Sprite spawn_grass = new Sprite(16, 0, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_stone = new Sprite(16, 1, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_redbrick = new Sprite(16, 2, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_graybrick = new Sprite(16, 2, 1, SpriteSheet.spawn_level);
	public static Sprite spawn_water = new Sprite(16, 3, 0, SpriteSheet.spawn_level);
	public static Sprite spawn_point = new Sprite(16, 0, 2, SpriteSheet.spawn_level);
	
	// Tiles Sprite Sheets:
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite stone = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite brick = new Sprite(16, 4, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 1, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x0D2BD4); // 0x0D2BD4
	
	// player sprites
	public static Sprite playerDOWN0 = new Sprite(32, 1, 4, SpriteSheet.tiles);
	public static Sprite playerDOWN1 = new Sprite(32, 0, 4, SpriteSheet.tiles);
	public static Sprite playerDOWN2 = new Sprite(32, 2, 4, SpriteSheet.tiles);
	
	public static Sprite playerUP0 = new Sprite(32, 1, 7, SpriteSheet.tiles);
	public static Sprite playerUP1 = new Sprite(32, 0, 7, SpriteSheet.tiles);
	public static Sprite playerUP2 = new Sprite(32, 2, 7, SpriteSheet.tiles);
	
	public static Sprite playerRIGHT0 = new Sprite(32, 1, 6, SpriteSheet.tiles);
	public static Sprite playerRIGHT1 = new Sprite(32, 0, 6, SpriteSheet.tiles);
	public static Sprite playerRIGHT2 = new Sprite(32, 2, 6, SpriteSheet.tiles);
	
	public static Sprite playerLEFT0 = new Sprite(32, 1, 5, SpriteSheet.tiles);
	public static Sprite playerLEFT1 = new Sprite(32, 0, 5, SpriteSheet.tiles);
	public static Sprite playerLEFT2 = new Sprite(32, 2, 5, SpriteSheet.tiles);
	
	//utils
	public static Sprite fireball1 = new Sprite(16, 0, 0, SpriteSheet.fireball);
	public static Sprite fireball2 = new Sprite(16, 1, 0, SpriteSheet.fireball);
	public static Sprite fireball3 = new Sprite(16, 0, 1, SpriteSheet.fireball);
	
	//particles
	public static Sprite particle_normal = new Sprite(2, 0xAAAAAA);
	public static Sprite square = new Sprite(2, 0xFF0000);
	public static Sprite dummy = new Sprite(32, 0, 0, SpriteSheet.dummy_down);
	
	/**
	 * Wczytywanie Sprite'u
	 * @param sheet SpriteSheet
	 * @param width szeroko�� SpriteSheetu
	 * @param height wysoko�� SpriteSheetu
	 */
	protected Sprite(SpriteSheet sheet, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.sheet = sheet;
		pixels = new int[width*height];
	}
	
	/**
	 * Wczytywanie Sprite'u
	 * @param size rozmiar
	 * @param x x
	 * @param y y
	 * @param sheet sheet
	 */
	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	/**
	 * Wczytywanie Sprite'u
	 * @param width szerokosc
	 * @param height wysokosc
	 * @param colour kolor
	 */
	public Sprite(int width, int height, int colour) {
		SIZE = -1;
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
		setColour(colour);
	}
	
	/**
	 * Wczytywanie Sprite'u
	 * @param size rozmiar
	 * @param colour kolor
	 */
	public Sprite(int size, int colour) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColour(colour);
	}
	
	/**
	 * Wczytywanie Sprite'u
	 * @param pixels piksele
	 * @param width szerokosc
	 * @param height wysokosc
	 */
	public Sprite(int[] pixels, int width, int height) {
		SIZE = (width == height) ? width : -1;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}
	
	/**
	 * Ustawia kolor pikseli
	 * @param colour Numer koloru dla pikseli
	 */
	private void setColour(int colour) {
		for(int i=0;i < width * height; i++) {
			pixels[i] = colour;
		}
	}
	
	/**
	 * Zwraca szeroko�� Sprite'u
	 * @return Zwraca szeroko�� Sprite'u
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Zwraca szeroko�� Sprite'u
	 * @return Zwraca szeroko�� Sprite'u
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Wczytuje sheet do Sprite'u
	 */
	private void load()  {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.WIDTH];
			}
		}
	}
	
}