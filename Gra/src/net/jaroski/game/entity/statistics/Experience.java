package net.jaroski.game.entity.statistics;

public class Experience {
	
	private int level;
	private int exp;
	
	private int[] reqExp = new int[50];
	
	public int getLevel() {
		return level;
	}
	public int getExp() {
		return exp;
	}
	
	public void setLevel(int lvl) {
		this.level=lvl;
	}
	
	public void setExp(int xp) {
		this.exp=xp;
	}
	
	public void addLevel(int lvl) {
		this.level+=lvl;
	}
	
	public void addLevel() {
		this.level++;
	}
	
	public void addExp(int xp) {
		this.exp+=xp;
	}
	
	public void initExp() {
		for(int i=0; i<reqExp.length; i++) {
			switch(i) {
			case 0:
				reqExp[i]=10;
				break;
			case 1:
				reqExp[i]=20;
				break;
			case 2:
				reqExp[i]=50;
				break;
			case 3:
				reqExp[i]=100;
				break;
			case 4:
				reqExp[i]=200;
				break;
				
			// TO DO
				
			}
		}
	}
	
}
