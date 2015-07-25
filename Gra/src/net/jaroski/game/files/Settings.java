package net.jaroski.game.files;

public class Settings extends Files {
	
	private static String settings = "Settings";
	
	private int max_fps;
	private int screen_width;
	private int screen_heigth;
	
	public Settings(String s) {
		super(s);
	}
	
	public void readFile() {
		//line = scan.nextLine();
		//String[] words = line.split(" ");
	}
	
	public static void main(String[] args) {
		Settings s = new Settings(settings);
		//s.checkFile(settings);
	}
}
