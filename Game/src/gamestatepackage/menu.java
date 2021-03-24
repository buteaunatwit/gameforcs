package gamestatepackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Game.Gamepanel;

public class menu extends state{
	
	private String[] options = {"Play", "Help","Quit"};
	private int currentselection = 0;
	

	public menu(Manager gsm) {
		super(gsm);
	}

	
	public void init() {}

	
	public void tick() {
		
	}

	
	public void draw(Graphics g) {
		
		g.setColor(new Color(50,100,200));
		g.fillRect(0, 0, Gamepanel.WIDTH, Gamepanel.HEIGHT);
		

		for (int i = 0; i < options.length; i++) {
			if(i==currentselection) {
				g.setColor(Color.GREEN);
			}
			else {
				g.setColor(Color.WHITE);
			}
			
			g.setFont(new Font("Arial", Font.PLAIN, 72));
			g.drawString(options[i], Gamepanel.WIDTH / 2 - 75, 150 + i *150);
		}
	}

	
	public void keypressed(int k) {
		if (k == KeyEvent.VK_DOWN) {
		 currentselection++;
		 if(currentselection >= options.length) {
			 currentselection=0;
			 
			 }
		 else if ( k == KeyEvent.VK_UP) {
		 currentselection--;
		 }
		 if (currentselection < 0) {
			 currentselection = options.length - 1;
			 
		 }
	}
	if (k == KeyEvent.VK_ENTER) {
		if(currentselection == 0) {
			gsm.states.push(new levelone(gsm));
			
		}
		else if(currentselection == 1) {
		
		}
	
		else if (currentselection ==2 ) {
			System.exit(0);
			
		}
		}
	}
	

	
	public void keyreleased(int k) {
		
	}

}
