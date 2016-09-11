package com.remoteenterprise.MODEL;

import org.newdawn.slick.geom.Vector2f;

public class Block {
	private Char block;
	private Vector2f position;
	
	public Block() {
		this.block = new Char('o');
		this.position = new Vector2f(0,0);
	}
	
	public Char getBlock() {
		return block;
	}
	
	public Vector2f getPosition() {
		return this.position;
	}
	
	public void setPosition(int x, int y) {
		this.position.set(x, y);
	}
	
	public String toString() {
		return String.valueOf(this.block.getC());
	}
}
