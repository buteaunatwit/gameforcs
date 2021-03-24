package gamestatepackage;

import java.awt.Graphics;

public abstract class state {
	protected Manager gsm;
	public static double xOFFset, yOFFset;
	
	public state(Manager gsm) {
		
		this.gsm = gsm;
		
		xOFFset = 0;
		yOFFset =0;
		init();
	}
	public abstract void init();
	public abstract void tick();
	public abstract void draw(Graphics g);
	public abstract void keypressed(int k);
	public abstract void keyreleased(int k);
	

}
