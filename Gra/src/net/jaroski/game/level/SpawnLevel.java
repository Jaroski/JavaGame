package net.jaroski.game.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.jaroski.game.entity.mob.Chaser;
import net.jaroski.game.entity.mob.Dummy;
import net.jaroski.game.entity.mob.Shooter;
import net.jaroski.game.entity.mob.Star;

/**
 * Klasa odpowiedzialna za wczytywanie mapy, oraz generowanie potworów na niej
 * @author Jaroski
 *
 */
public class SpawnLevel extends Level {
	
	/**
	 * Konstruktor klasy generuj¹cej mapê
	 * @param path Argument przekazuj¹cy œcie¿kê do pliku graficznego z którego bêdzie wczytana mapa
	 */
	public SpawnLevel(String path) {
		super(path);
	}
	
	/**
	 * Metoda wczytuje tablice mapy z podanego pliku obrazowego
	 */
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];
			
			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load level file!");
		}
		
		generateMobs();
	}
	
	// spawn_grass = 0xff19FF00
	// spawn_stone = 0xffA0A0A0
	// spawn_redbrick = 0xff404040
	// spawn_graybrick = 0xff808080
	// spawn_water = 0xff0000FF
	// spawn_point = 0xff19FFF7
	
	/**
	 * Stara metoda s³u¿¹ca do rêcznego generowania mapy,
	 * np. randomowego uzupe³niania tablicy mapy
	 */
	protected void generateLevel() {
		
	}
	
	/**
	 * Metoda generuj¹ca Moby(potwory) na mapie
	 */
	
	protected void generateMobs() {
		add(new Chaser(20, 55));
		add(new Star(17, 35));
		//add(new Shooter(20, 55));
		add(new Dummy(20, 55));
		add(new Shooter(20, 62));
		for(int i=0;i<5;i++) {
			add(new Dummy(20, 55));
			
		}
	}
}
