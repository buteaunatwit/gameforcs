package gamestatepackage;

import java.awt.Graphics;
import java.util.Map;

import map.Mapping;
import objects.block;


public class levelone extends state{
	
	private entities.player player;
	private Mapping map;
	
	
	
	public levelone(Manager gsm) {
		super(gsm);
	}

	
	public void init() {
		player= new entities.player(30,30);
		map = new Mapping ("",4,4);
		
		xOFFset = -200;
		yOFFset = -400;
	}

	@Override
	public void tick() {
	
		 player.tick(map.getblocks());
		
	}

	
	public void draw(Graphics g) {
		 player.draw(g);
		 map.draw(g);
		 
		 
		
	}

	
	public void keypressed(int k) {
		player.keyPressed(k);
		
	}

	
	public void keyreleased(int k) {
		player.keyReleased(k);
		
		
	}

}
