package com.remoteenterprise.MODEL;

import java.util.Vector;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class Snake implements Snake2D {
	private static Snake uniqueInstance = new Snake();
	private boolean alive;
	private double speed;
	private double speedKey;
	private Vector<Block> snake;
	private Vector2f position;
	private Upgrade upgrade;
	
	private Snake() {
		this.alive = true;
		this.snake = new Vector<>();
		this.position = new Vector2f(50,50);
		this.snake.add(new Block());
		this.snake.get(0).setPosition(50, 50);
		this.speed = 100;
		this.speedKey = this.speed;
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
	
	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public double getSpeedKey() {
		return speedKey;
	}

	public void setSpeedKey(double speedKey) {
		this.speedKey = speedKey;
	}
	
	public Upgrade getUpgrade() {
		return upgrade;
	}

	public void setUpgrade(Upgrade upgrade) {
		this.upgrade = upgrade;
	}

	@Override
	public boolean colidiu(Vector2f posicao) {
		for(int i = 0; i < this.snake.size(); i++) {
			if(posicao.x == this.snake.get(i).getPosition().x && 
					posicao.y == this.snake.get(i).getPosition().y) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void reset() {
		this.alive = true;
		this.snake = new Vector<>();
		this.position = new Vector2f(50,50);
		this.snake.add(new Block());
		this.snake.get(0).setPosition(50, 50);
	}
	
	@Override
	public void resetStatusUpgrade() {
		this.speed = 100;
		this.speedKey = this.speed;
	}
}
