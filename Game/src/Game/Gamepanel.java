package Game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import gamestatepackage.Manager;

public class Gamepanel extends JPanel implements Runnable, KeyListener {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 900;
	public static final int HEIGHT = 550;
	
	private Thread thread;
	private boolean isrunning = false;
	
	private int FPS = 60;
	private long targettime = 100 / FPS;
	
	private Manager gsm;

	public Gamepanel() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		addKeyListener(this);
		setFocusable(true);
		start();
		
		
	}
	private void start() {
		isrunning = true;
		thread = new Thread(this);
		thread.start();
		
	
	}
	public void run() {
		long start, elapsed, wait;
		
		gsm = new Manager();
		
		while(isrunning) {
			start = System.nanoTime();
			
			tick();
			repaint();
			
			elapsed = System.nanoTime() - start;
			wait = targettime - elapsed / 1000000;
			
			if (wait <0) {
				wait = 5;
				
			}
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	public void tick() {
		gsm.tick();
		
	}
	public void paint(Graphics g) {
		super.paint(g);
		
		g.clearRect(0, 0,  WIDTH,  HEIGHT);
		gsm.draw(g);
	}

	

	public void keyPressed(KeyEvent e) {
		gsm.keypressed(e.getKeyCode());
		
	}
	public void keyReleased(KeyEvent e) {
		gsm.keyreleased(e.getKeyCode());
		
	}
	public void keyTyped(KeyEvent e) {
		
	}

}
