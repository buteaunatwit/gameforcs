package gamestatepackage;

import java.awt.Graphics;
import java.util.Stack;

public class Manager {
	
	public Stack<state> states;
	
	
	
	public Manager() {
		states= new Stack<state>();
		states.push(new menu(this));
		
		
	}
	public void tick() {
		states.peek().tick();
		
	}
	public void draw(Graphics g) {
		states.peek().draw(g);
	}
	public void keypressed(int k) {
		states.peek().keypressed(k);
	}
	public void keyreleased(int k) {
		states.peek().keyreleased(k);
	}

}
