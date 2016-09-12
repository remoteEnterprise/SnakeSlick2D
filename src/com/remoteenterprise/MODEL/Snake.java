package com.remoteenterprise.MODEL;

import java.util.Vector;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class Snake {
	private static Snake uniqueInstance = new Snake();
	private boolean alive;
	private Vector<Block> snake;
	private Vector2f position;
	
	private Snake() {
		this.alive = true;
		this.snake = new Vector<>();
		this.position = new Vector2f(50,50);
		this.snake.add(new Block());
		this.snake.get(0).setPosition(50, 50);
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public Vector<Block> getSnake() {
		return snake;
	}

	public void setSnake(Vector<Block> snake) {
		this.snake = snake;
	}

	public Vector2f getPosition() {
		return position;
	}

	public void setPosition(Vector2f position) {
		this.position = position;
	}
	
	public static Snake getInstance() {
		return Snake.uniqueInstance;
	}
	
	public boolean colidiu(Vector2f posicao) {
		for(int i = 0; i < this.snake.size(); i++) {
			if(posicao.x == this.snake.get(i).getPosition().x && 
					posicao.y == this.snake.get(i).getPosition().y) {
				return true;
			}
		}
		return false;
	}
}
