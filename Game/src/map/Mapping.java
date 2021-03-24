package map;

import java.awt.Graphics;

import objects.block;

public class Mapping {
	
	private String path;
	private int width, height;
	
	private block [][] blocks;
	public Mapping (String loadpath, int width, int height) {
		path = loadpath;
		this.width = width;
		this.height = height;
		
		blocks = new block[height][width];
		
		for(int i=0; i<blocks.length;i++) {
			for(int j=0; j<blocks[0].length; j++) {
				blocks[i][j]= new block(j* block.blocksize, i*block.blocksize);
			}}
	}
	public void draw(Graphics g) {
		for(int i=0; i<blocks.length;i++) {
			for(int j=0; j<blocks[0].length; j++) {
				blocks[i][j].draw(g);
			}
			
		}
	}
	public block[][]getblocks(){
		return blocks;
	}

}
