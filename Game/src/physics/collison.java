package physics;

import java.awt.Point;

import objects.block;

public class collison {
	public static boolean playerblock(Point p, block b) {
		return b.contains(p);
	}

}
