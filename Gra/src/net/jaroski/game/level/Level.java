package net.jaroski.game.level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import net.jaroski.game.entity.Entity;
import net.jaroski.game.entity.Projectile;
import net.jaroski.game.entity.mob.Mob;
import net.jaroski.game.entity.mob.Player;
import net.jaroski.game.entity.particle.Particle;
import net.jaroski.game.graphics.Screen;
import net.jaroski.game.level.tile.Tile;
import net.jaroski.game.util.Vector2i;

public class Level {
	
	
	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;
	
	private static List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();
	private List<Entity> trash = new ArrayList<Entity>();
	
	private List<Player> players = new ArrayList<Player>();
	
	private Comparator<Node> nodeSorter = new Comparator<Node>() {
		public int compare(Node n0, Node n1) {
			if(n1.fCost < n0.fCost) return +1;
			if(n1.fCost > n0.fCost) return -1;
			return 0;
		}
	};
	
	public static Level spawn = new SpawnLevel("/levels/spawn.png");
	
	//for square map
	int mapSize;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width*height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
		generateLevel();
		
	}

	protected void generateLevel() {
		
	}
	
	protected void loadLevel(String path) {
		
	}
	
	public void update() {
		for(int i=0; i<players.size(); i++) {
			players.get(i).update();
		}
		for(int i=0; i <entities.size(); i++) {
			entities.get(i).update();
		}
		for(int i=0;i<projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for(int i=0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		for(int i=0; i< trash.size(); i++) {
			trash.get(i).update();
		}
		remove();
	}
	
	private void remove() {
		for(int i=0; i <entities.size(); i++) {
			if (entities.get(i).isRemoved()) entities.remove(i);
		}
		for(int i=0;i<projectiles.size(); i++) {
			if (projectiles.get(i).isRemoved()) projectiles.remove(i);
		}
		for(int i=0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved()) particles.remove(i);
		}
		for(int i=0; i<trash.size(); i++) {
			if (trash.get(i).isRemoved()) trash.remove(i);
		}
		for(int i=0; i<players.size(); i++) {
			if (players.get(i).isRemoved()) players.remove(i);
		}
		
	}
	
	public List<Projectile> getProjectiles() {
		return projectiles;
	}
	
	//private void time() {
		
	//}
	
	public void add(Entity e) {
		e.init(this);
		if(e instanceof Particle) {
			particles.add((Particle)e);
		} else if(e instanceof Projectile) {
			projectiles.add((Projectile)e);
		} else if(e instanceof Player) {
			players.add((Player)e);
		} else if(e instanceof Mob){
			entities.add(e);
		} else {
			trash.add(e);
			//System.out.println(e);
		}
	}
	
	public List<Player> getPlayer() {
		return players;
	}
	public Player getPlayerAt(int index) {
		return players.get(index);
	}
	public Entity getEntityCollideMob(Entity e, Mob target) {
		if(target.isCollide(e.getX(), e.getY())) return target;
		return null;
	}
	
	
	public Player getClientPlayer() {
		return players.get(0);
	}
	
	public List<Node> findPath(Vector2i start, Vector2i goal) {
		List<Node> openList = new ArrayList<Node>();
		List<Node> closedList = new ArrayList<Node>();
		Node current = new Node(start, null, 0, getDistance(start, goal));
		openList.add(current);
		
		while(openList.size() > 0) {
			Collections.sort(openList, nodeSorter);
			current = openList.get(0);
			if(current.tile.equals(goal)) {
				List<Node> path = new ArrayList<Node>();
				while(current.parent != null) {
					path.add(current);
					current = current.parent;
					//System.out.println("current: " + current.tile.getX() + ", " + current.tile.getY());
				}
				openList.clear();
				closedList.clear();
				return path;
			}
			
			openList.remove(current);
			closedList.add(current);
			
			for(int i=0; i<9;i++) {
				if(i == 4) continue;
				int x = current.tile.getX();
				int y = current.tile.getY();
				int xi = (i % 3) - 1;
				int yi = (i / 3) - 1;
				Tile at = getTile(x+xi, y+yi);
				//System.out.println("(" + (x+xi) + ", " + (y+yi) + ")");
				if(at == null) continue;
				if(at.solid()) continue;
				// jesli nie da sie przejsc na skos
				if(xi!=0 && yi!=0) {
					Tile c1 = getTile(x+xi, y);
					Tile c2 = getTile(x, y+yi);
					if(c1.solid() && c2.solid()) continue;
				}
				// 
				Vector2i a = new Vector2i(x+xi, y+yi);
				double gCost = current.gCost + getDistance(current.tile, a) == 1 ? 1 : 0.95;
				double hCost = getDistance(a, goal);
				Node node = new Node(a, current, gCost, hCost);
				if(vecInList(closedList, a) && gCost >= node.gCost) continue;
				if(!vecInList(openList, a) || gCost < node.gCost) openList.add(node);
			}
		}
		
		closedList.clear();
		return null;
	}
	
	private boolean vecInList(List<Node> list, Vector2i vector) {
		for(Node n : list) {
			if(n.tile.equals(vector)) return true;
		}
		return false;
	}
	
	private double getDistance(Vector2i tile, Vector2i goal) {
		double dx = tile.getX() - goal.getX();
		double dy = tile.getY() - goal.getY();
		return Math.sqrt(dx * dx + dy * dy);
	}
	
	// radius == pixels
	public List<Entity> getEntities(Entity e, int radius) {
		List<Entity> result = new ArrayList<Entity>();
		int ex = (int)e.getX();
		int ey = (int)e.getY();
		for(int i=0;i<entities.size();i++) {
			Entity entity = entities.get(i);
			if(entity.equals(e)) continue;
			int x = (int)entity.getX();
			int y = (int)entity.getY();
			
			int dx = Math.abs(x-ex);
			int dy = Math.abs(y-ey);
			double distance = Math.sqrt((dx*dx) + (dy*dy));
			if(distance < radius) {
				result.add(entity);
			}
		}
		return result;
	}
	
	public static Entity getEntity(int xx, int yy) {
		for(int i=0;i<entities.size();i++) {
			int w = entities.get(i).getSprite().getWidth()/2;
			int h = entities.get(i).getSprite().getHeight()/2;
			int xa=(int)entities.get(i).getX()-w;
			int xb=(int)entities.get(i).getX()+w;
			int ya=(int)entities.get(i).getY()-h;
			int yb=(int)entities.get(i).getY()+h;
			
			if((xx>=xa) && (xx<=xb) && (yy>=ya) && (yy<=yb)) {
				System.out.println(entities.get(i));
				return entities.get(i);
			}
		}
		
		return null;
	}
	
	// dwie metody do shoot(), aby pominac siebie na kolizji - trza by zlaczyc w jedna metode, ale mi sie nie chce
	public List<Mob> getMobs(Entity e, int radius, Entity owner) {
		List<Mob> result = new ArrayList<Mob>();
		int ex = (int)e.getX();
		int ey = (int)e.getY();
		for(int i=0;i<entities.size();i++) {
			Mob entity = (Mob) entities.get(i);
			if(entity.equals(e)) continue;
			if(entity.equals(owner)) continue;
			int x = (int)entity.getX();
			int y = (int)entity.getY();
			
			int dx = Math.abs(x-ex);
			int dy = Math.abs(y-ey);
			double distance = Math.sqrt((dx*dx) + (dy*dy));
			if(distance < radius) {
				result.add(entity);
			}
		}
		return result;
	}
	public List<Player> getPlayers(Entity e, int radius, Entity owner) {
		List<Player> result = new ArrayList<Player>();
		int ex = (int)e.getX();
		int ey = (int)e.getY();
		for(int i=0; i < players.size();i++) {
			Player entity = players.get(i);
			if(entity.equals(owner)) continue;
			int x = (int)entity.getX();
			int y = (int)entity.getY();
			
			int dx = Math.abs(x-ex);
			int dy = Math.abs(y-ey);
			double distance = Math.sqrt((dx*dx) + (dy*dy));
			if(distance < radius) {
				result.add(entity);
			}
		}
		return result;
	}
	// koniec metod do shoot()

	// zwraca liste Players w radius Entity e, radius == pixels
	public List<Player> getPlayers(Entity e, int radius) {
		List<Player> result = new ArrayList<Player>();
		int ex = (int)e.getX();
		int ey = (int)e.getY();
		for(int i=0; i < players.size();i++) {
			Player entity = players.get(i);
			int x = (int)entity.getX();
			int y = (int)entity.getY();
			
			int dx = Math.abs(x-ex);
			int dy = Math.abs(y-ey);
			double distance = Math.sqrt((dx*dx) + (dy*dy));
			if(distance < radius) {
				result.add(entity);
			}
		}
		return result;
	}
	
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
		
		for(int y = y0; y < y1+1; y++) {
			for(int x = x0; x < x1+1; x++) {
				
				getTile(x, y).render(x, y, screen);
			}
		}
		for(int i=0; i<players.size(); i++) {
			players.get(i).render(screen);
		}
		for(int i=0; i<entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for(int i=0; i<projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for(int i=0; i<particles.size(); i++) {
			particles.get(i).render(screen);
		}
		for(int i=0; i<trash.size(); i++) {
			trash.get(i).render(screen);
		}
	}
	
	public boolean tileCollision(int x, int y, int size, int xOffset, int yOffset) {
		boolean solid = false;
		for(int c=0; c<4;c++) {
			int xt = (x - c % 2 * size + xOffset) >> 4;
			int yt = (y - c / 2 * size + yOffset) >> 4;
			if(getTile(xt, yt).solid()) solid = true;
		}
		return solid;
	}
	/*
	public boolean tileCollision(double x, double y, double xa, double ya) {
		
		return getTile((int)(x+xa)/16, (int)(y+ya+4)/16).solid();
	}*/
	
	// Grass = 0xff007F0E
	// Flower = 0xffE9FF00
	// Rock = 0xff404040
	public Tile getTile(int x, int y) {
		
		if (x < 0 || y < 0 || x >= width || y >= height) return Tile.voidTile;
		
		
		if(tiles[x+y*width] == Tile.col_spawn_grass) return Tile.spawn_grass;
		if(tiles[x+y*width] == Tile.col_spawn_stone) return Tile.spawn_stone;
		if(tiles[x+y*width] == Tile.col_spawn_redbrick) return Tile.spawn_redbrick;
		if(tiles[x+y*width] == Tile.col_spawn_graybrick) return Tile.spawn_graybrick;
		if(tiles[x+y*width] == Tile.col_spawn_water) return Tile.spawn_water;
		if(tiles[x+y*width] == Tile.col_spawn_point) return Tile.spawn_point;
		return Tile.voidTile;
		
	}
}
