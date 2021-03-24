package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;

import Game.Gamepanel;
import gamestatepackage.state;
import objects.block;
import physics.collison;

public class player {
	
	
	private boolean right= false, left = false, jumping =false, falling =false;
	private boolean topcollision = false;
	
	private double x,y;
	private int width, height;
	
	//move speed
	private double movespeed = .5;
	
	private double jumpspeed= 5 ;
	private double currentjumpspeed = jumpspeed;
	
	private double maxfallspeed= .5;
	private double currentfallspeed = 0.1;
	
	public player(int width, int height) {
		 x= Gamepanel.WIDTH/2;
		 y= Gamepanel.HEIGHT/2;
		 this.width=width;
		 this.height=height;

}
	public void tick(block[][] b) {
		
		/*test if(right) {
			x++;
		}
		if(left) {
			x--;
		}
		*/
		
		int iX= (int)x;
		int iY = (int)y;
		
		for( int i =0; i<b.length; i++) {
			for (int j=0; j<b[0].length;j++) {
			//right
			if(collison.playerblock (new Point(iX + width + (int)state.xOFFset, iY + (int)state.yOFFset +2), b[i][j])
					|| collison.playerblock(new Point(iX+width+(int)state.xOFFset,iY +height+(int)state.yOFFset-1), b[i][j])) {
				right = false;
				
			}
			//left 
		if(collison.playerblock (new Point(iX  + (int)state.xOFFset-1, iY + (int)state.yOFFset+2), b[i][j])
					|| collison.playerblock(new Point(iX+(int)state.xOFFset-1,iY +height+(int)state.yOFFset-1), b[i][j])) {
				left=false;
			}
			//top
			if(collison.playerblock (new Point(iX  + (int)state.xOFFset+1, iY + (int)state.yOFFset), b[i][j])
					|| collison.playerblock(new Point(iX+width+(int)state.xOFFset-1,iY +(int)state.yOFFset), b[i][j])) {
				jumping =  false;
				falling = true;
			}
		if(collison.playerblock (new Point(iX  + (int)state.xOFFset+2, iY + height +(int)state.yOFFset+1), b[i][j])
					|| collison.playerblock(new Point(iX+width+(int)state.xOFFset-1,iY+ height + (int)state.yOFFset+1), b[i][j])) {
			y = b[i][j].getY() - height -state.yOFFset;
			falling = false;
				topcollision = true;
				
					
			}else {
				if(!topcollision && !jumping) {
					falling = true;
				}
				
			}
			}
		}
		
		topcollision = false;
		if(right) {
			state.xOFFset+= movespeed;
		}
		if(left) {
			state.xOFFset-= movespeed;
		}
		
		if(jumping) {
			state.yOFFset-=currentjumpspeed;
			
			currentjumpspeed -=.1;
			
			if(currentjumpspeed <= 0) {
				currentjumpspeed = jumpspeed;
				jumping = false;
				falling = true;
				
			}
			
		}
		if (falling) {
			state.yOFFset += currentfallspeed;
			if(currentfallspeed < maxfallspeed) {
				currentfallspeed += .1;
			}
			if (!falling) {
				currentfallspeed = .1;
				
			}
		}
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x,(int) y,width,height);
	
	}
	public void keyPressed(int k) {
		if(k ==KeyEvent.VK_D) right = true;
		if(k ==KeyEvent.VK_A) left= true;
		if(k ==KeyEvent.VK_SPACE && !jumping && !falling) jumping = true;
	}
	public void keyReleased(int k) {
		if(k ==KeyEvent.VK_D) right = false;
		if(k ==KeyEvent.VK_A) left=false;
		
	}
	
	}