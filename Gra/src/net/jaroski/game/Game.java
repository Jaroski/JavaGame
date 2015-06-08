package net.jaroski.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import net.jaroski.game.entity.mob.Player;
import net.jaroski.game.graphics.Screen;
//import net.jaroski.game.graphics.SpriteSheet;
import net.jaroski.game.input.Keyboard;
import net.jaroski.game.input.Mouse;
import net.jaroski.game.level.Level;
import net.jaroski.game.level.TileCoordinate;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	private static int width = 300;
	private static int height = width / 16 * 9;
	private static int scale = 3;
	public static String title = "Game (still not alpha)";
	
	private Thread thread;
	private JFrame frame;
	private Keyboard key;
	private Level level;
	private Player player;
	private boolean running = false;
	
	private Screen screen;
	private Mouse mouse;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		frame = new JFrame();
		key = new Keyboard();
		mouse = new Mouse();
		level = Level.spawn;
		TileCoordinate pSpawn = new TileCoordinate(20, 45);
		
		player = new Player(pSpawn.getX(), pSpawn.getY(), key);
		//player = new Player(200,200, key);
		level.add(player);
		
		
		addKeyListener(key);
		
		addMouseListener(mouse);
		addMouseMotionListener(mouse);
	}
	
	public static int getWindowWidth() {
		return width*scale;
	}
	
	public static int getWindowHeight() {
		return height*scale;
	}
	
	//start thread
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.setPriority(Thread.MAX_PRIORITY);
		thread.start();
	}
	
	//stop thread
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	public void run() {
		//new Game();
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		requestFocus();
		
		while(running) {
			long now = System.nanoTime();
			delta+= (now-lastTime)/ns;
			lastTime = now;
			while(delta>=1) {
				update();
				updates++;
				delta--;
				
			}
			
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer+=1000;
				//System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + "  |  " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
		
	}
	//int x=0, y=0;
	//logic
	public void update() {
		key.update();
		level.update();
	}
	
	//graphic, buffer strategy
	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		screen.clear();
		double xScroll = player.getX()-screen.width/2;
		double yScroll = player.getY()-screen.height/2;
		level.render((int)xScroll, (int)yScroll, screen);
		
		//Sprite sprite = new Sprite(50, height, 0xff);
		//screen.renderSprite(width - 50, 0, sprite, false);
		//screen.renderSheet(40, 40, SpriteSheet.player, false);
		
		for(int i = 0 ; i < pixels.length ; i++) {
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Verdana", 0, 30));
		//g.fillRect(Mouse.getX() - 32, Mouse.getY() - 32, 64, 64);
		//g.drawString("Button: " + Mouse.getButton(), 80, 80);
		// >> 4 - wyswietla koordynaty, a nie pixele
		//g.drawString("X: " + (player.x >> 4) + ", Y: " + (player.y >> 4), 700, 450);
		g.dispose();
		bs.show();
		
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle(Game.title);
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
					
		game.start();
	}

}