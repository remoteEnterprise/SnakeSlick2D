package com.remoteenterprise.MODEL;

import java.util.LinkedList;
import java.util.Random;

import org.newdawn.slick.geom.Vector2f;

public class Block {
	private Char block;
	private Upgrade upgrade;
	private Vector2f position;
	private static LinkedList<Integer> posicoes = gerarPosicoes();
	
	public Block() {
		this.block = new Char('o');
		Random rand = new Random();
		this.position = new Vector2f(Block.posicoes.get(rand.nextInt(Block.posicoes.size())), 
				Block.posicoes.get(rand.nextInt(Block.posicoes.size())));
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
	
	public Upgrade getUpgrade() {
		return upgrade;
	}

	public void setUpgrade(Upgrade upgrade) {
		this.upgrade = upgrade;
	}

	private static LinkedList<Integer> gerarPosicoes() {
		LinkedList<Integer> posicoes = new LinkedList<>();
		for(int i = 20; i < 460; i+=10) {
			posicoes.add(i);
		}
		return posicoes;
	}
}
