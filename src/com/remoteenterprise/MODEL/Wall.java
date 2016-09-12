package com.remoteenterprise.MODEL;

import org.newdawn.slick.geom.Vector2f;

public class Wall {
	private Vector2f posicao;
	private float altura;
	private float largura;
	
	public Wall(int x, int y, float altura, float largura) {
		this.posicao = new Vector2f(x,y);
		this.altura = altura;
		this.largura = largura;
	}

	public Vector2f getPosicao() {
		return posicao;
	}

	public void setPosicao(Vector2f posicao) {
		this.posicao = posicao;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getLargura() {
		return largura;
	}

	public void setLargura(float largura) {
		this.largura = largura;
	}
}
