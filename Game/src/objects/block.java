package objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import gamestatepackage.state;

public class block extends Rectangle {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int blocksize = 64;
	
	
	public block(int x, int y) {
		setBounds(x,y,blocksize,blocksize);
}
	
	public void tick() {
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x  - (int)state.xOFFset , y - (int)state.yOFFset , width, height);
	}

}
