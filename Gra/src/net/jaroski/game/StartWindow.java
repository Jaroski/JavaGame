package net.jaroski.game;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Klasa obs�uguj�ca okno inicjalizacyjne gry
 * @author Jaroski
 *
 */
@SuppressWarnings("serial")
public class StartWindow extends JFrame implements ActionListener {
	private static JFrame frame;
	JPanel panel;
	JButton startGame;
	JButton about;
	JButton end;
	
	public StartWindow() {
		frame = new JFrame();
		panel = new JPanel();
		frame.setSize(200, 250);
		frame.setTitle("");
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		addButton(startGame, "Rozpocznij gre", "newGame");
		addButton(about, "       O grze        ", "about");
		addButton(end, "       Wy��cz       ", "end");
		frame.add(panel);
	}
	
	/**
	 * Dodajemy przycisk do okienka
	 * @param button Dany obiekt przycisku
	 * @param s Tekst na przycisku
	 * @param cmd Tekst komendy przycisku
	 */
	public void addButton(JButton button, String s, String cmd) {
		button = new JButton(s);
		button.setActionCommand(cmd);
		button.addActionListener(this);
		panel.add(button);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		StartWindow w = new StartWindow();
	}
	
	/**
	 * Przeci��ona obs�uga przycisk�w
	 */
	public void actionPerformed(ActionEvent e){
		String scmd = e.getActionCommand();
		System.out.println(scmd);
		switch(scmd) {
		case "newGame":
			Game.initGame();
			frame.dispose();
			break;
		case "about":
			aboutGame();
			break;
		case "end":
			frame.dispose();
			break;
		}
	}
	
	/**
	 * Okno m�wi�ce o zako�czeniu gry
	 * @param s rodzaj zako�czenia gry
	 */
	public static void endGame(String s) {
		
		if(s =="win") {
			JOptionPane.showMessageDialog(frame,
				    "Gratulacje, wygra�e�!",
				    "Koniec gry",
				    JOptionPane.PLAIN_MESSAGE);
		}
		if(s=="lose") {
			JOptionPane.showMessageDialog(frame,
				    "Niestety, przegra�e�!",
				    "Koniec gry",
				    JOptionPane.PLAIN_MESSAGE);
		}
		Game.getFrame().dispose();
	}
	
	/**
	 * Okno o grze i autorze
	 */
	public void aboutGame() {
		JLabel oGrze = new JLabel();;
		JFrame f = new JFrame();
		oGrze.setBounds(0, 0, 400, 300);
		oGrze.setVerticalAlignment(1);
		oGrze.setText("<html>DreamTeam project developer: <br><br> Jaros�aw Wi�niewski - Project Director<br><br><br><br>"
				+ "Celem gry jest pokonanie wszystkich potwor�w wyst�puj�cych na mapie.<br>"
				+ "W celu strzelania do potwor�w nale�y u�ywa� LPM.");
		f.setTitle("O grze");
		f.setSize(500, 400);
		
		f.add(oGrze);
		
		f.setVisible(true);
	}

}
