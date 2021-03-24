package Game;

import java.awt.BorderLayout;


import javax.swing.JFrame;

public class Game {

	public static void main(String[] args) {
		JFrame frame = new JFrame ("Platformaer");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(new Gamepanel(), BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		

	}

}
