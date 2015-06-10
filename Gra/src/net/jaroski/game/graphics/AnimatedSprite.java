package net.jaroski.game.graphics;

/**
 * Klasa obs³uguj¹ca animacjê Spriteów
 * @author Jaroski
 *
 */
public class AnimatedSprite extends Sprite {
	
	private int frame = 0;;
	private Sprite sprite;
	private int rate = 5;
	private int time = 0;
	private int length = -1;
	
	/**
	 * Konstruktor obs³ugi Animacji
	 * @param sheet
	 * @param width
	 * @param height
	 * @param length
	 */
	
	public AnimatedSprite(SpriteSheet sheet, int width, int height, int length) {
		super(sheet, width, height);
		this.length = length;
		sprite = sheet.getSprites()[0];
		if(length > sheet.getSprites().length)
			System.err.println("Error! Length of animation is too long!");
	}
	
	/**
	 * Aktualizacja logiki
	 */
	public void update() {
		time++;
		if(time%rate == 0) {
			if(frame >= length -1) frame = 0;
			else frame++;
			sprite = sheet.getSprites()[frame];
		}
		//System.out.println(sprite + ", Frame: " + frame);
	}
	
	/**
	 * Zwraca Sprite
	 * @return Zwraca Sprite
	 */
	public Sprite getSprite() {
		return sprite;
		
	}
	
	/**
	 * Ustawia czêstotliwoœæ odœwierzania, aktualnie brak implementacji
	 * @param frames Ustawia czêstotliwoœæ odœwierzania
	 */
	public void setFrameRate(int frames) {
		this.rate = frames;
	}
	
	/**
	 * Zmiana animacji dla danego indexu
	 * @param index Indeks nowego stanu animacji
	 */
	public void setFrame(int index) {
		if(index > sheet.getSprites().length -1) {
			System.out.println("Index out of bounds in " + this);
			return;
		}
		sprite = sheet.getSprites()[index];
	}
}
