package net.jaroski.game;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

public class StartWindow extends JPanel {
	JFrame frame;
	JPanel panel;
	JButton startGame;
	
	public StartWindow() {
		frame = new JFrame();
		frame.setSize(200, 250);
		frame.setTitle("JavaGame");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		startGame = new JButton("Start");
		//addButton("Start game");
		panel.add(startGame);
		frame.add(panel);
	}
	
	public void addButton(String s) { //, ActionListener al) {
		JButton button = new JButton(s);
		
		panel.add(button);
	}
	
	public static void main(String[] args) {
		StartWindow w = new StartWindow();
		
	}
}
