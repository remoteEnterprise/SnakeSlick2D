package com.remoteenterprise.VIEW;

import java.util.Random;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

import com.remoteenterprise.MODEL.Block;
import com.remoteenterprise.MODEL.Snake;
import com.remoteenterprise.MODEL.Wall;

public class SnakeGameBasicView extends BasicGame {
	private Snake snake;

	private Block block;
	private Vector2f posicaoBlock;
	
	private boolean gerarBlock, colidiuComElaMesma, colidiuParede;
	
	private int x = 50, y = 50, vaiMovimentar;
	
	private static final int DELAY = 100, DELAY_KEY = 100;
	
	private Wall[] paredes;
	
	private int tempoDecorrido, tempoKey;
	
	private enum Tecla {CIMA("CIMA"),
						BAIXO("BAIXO"),
						ESQUERDA("ESQUERDA"),
						DIREITA("DIREITA"),
						NENHUMA("NENHUMA");
		private String tecla;
		private Tecla(String tecla) {
			this.tecla = tecla;
		}};
	private String teclaPressionada = Tecla.NENHUMA.tecla;
	
	private Color background;
	
	private Random geradorGeral;
	
	public SnakeGameBasicView(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		if(!colidiuComElaMesma && !this.colidiuParede) {
			//g.setAntiAlias(true);
			g.setBackground(this.background);
			
			for(int i = 0; i < this.paredes.length; i++) {
				g.fillRect(this.paredes[i].getPosicao().x, this.paredes[i].getPosicao().y,
						this.paredes[i].getLargura(), this.paredes[i].getAltura());
			}
			for(int i = 20; i <= 480; i+=10) {
				g.setColor(Color.black);
				g.drawRect(i, 20, 0, 460);
			}
			for(int i = 20; i <= 480; i+=10) {
				g.setColor(Color.black);
				g.drawRect(20, i, 460, 0);
			}
			for(int i = this.snake.getSnake().size()-1; i >= 0 ; i--) {
				if(i == 0) {
					g.setColor(Color.red);
					g.fillRect(this.snake.getSnake().get(i).getPosition().x,
							this.snake.getSnake().get(i).getPosition().y, 10, 10);
					//g.drawString(this.snake.getSnake().get(i).toString(),
						//	this.snake.getSnake().get(i).getPosition().getX(),
							//this.snake.getSnake().get(i).getPosition().getY());
				} else {
					g.setColor(Color.white);
					g.fillRect(this.snake.getSnake().get(i).getPosition().x,
							this.snake.getSnake().get(i).getPosition().y, 10, 10);
//					g.drawString(this.snake.getSnake().get(i).toString(),
//							this.snake.getSnake().get(i).getPosition().getX(),
//							this.snake.getSnake().get(i).getPosition().getY());
				}
				g.setColor(Color.black);
				g.fillRect(0, 0, 100, 20);
				g.setColor(Color.white);
				g.drawString(String.valueOf(this.snake.getSnake().size()),0,0);
			}
			if(this.gerarBlock) {
				this.block = new Block();
				this.posicaoBlock = this.block.getPosition();
				this.gerarBlock = false;
			}
			
			if(!this.gerarBlock) {
				g.setColor(new Color(this.geradorGeral.nextInt(255),
					this.geradorGeral.nextInt(255),
					this.geradorGeral.nextInt(255)));
				g.fillRect(this.block.getPosition().x, this.block.getPosition().y, 10, 10);
				//g.drawString(block.toString(), block.getPosition().getX(), block.getPosition().getY());
			}
		} else {
			g.setColor(Color.black);
			g.fillRect(0, 0, 100, 20);
			g.setColor(Color.white);
			g.drawString(String.valueOf(this.snake.getSnake().size()),0,0);
			for(int i = this.snake.getSnake().size()-1; i >= 0 ; i--) {
				g.drawString(this.snake.getSnake().get(i).toString(),
						this.snake.getSnake().get(i).getPosition().getX(),
						this.snake.getSnake().get(i).getPosition().getY());
			}
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.snake = Snake.getInstance();
		this.vaiMovimentar = this.snake.getSnake().size()-1;
		this.gerarBlock = true;
		this.geradorGeral = new Random();
		this.background = new Color(118,255,3);
		this.paredes = new Wall[4];
		this.paredes[0] = new Wall(0,0,500,20); //Left
		this.paredes[1] = new Wall(480,0, 500, 20); //Right
		this.paredes[2] = new Wall(0,0, 20, 500); //Top
		this.paredes[3] = new Wall(0,480, 20, 500); //Bottom
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		if(!this.colidiuComElaMesma && !this.colidiuParede){
			if(this.tempoKey >= SnakeGameBasicView.DELAY_KEY) {
				this.definirDirecao(gc, delta);
				this.tempoKey = 0;
			} else {
				this.tempoKey += delta;
			}
			
			switch(this.teclaPressionada){
			case("NENHUMA"):
				break;
			case("DIREITA"):
				if(this.tempoDecorrido >= SnakeGameBasicView.DELAY) {
					x+=10;
					this.movimentar();
					this.tempoDecorrido = 0;
				} else {
					this.tempoDecorrido += delta;
				}
			break;
			case("BAIXO"):
				if(this.tempoDecorrido >= SnakeGameBasicView.DELAY) {
					y+=10;
					this.movimentar();
					this.tempoDecorrido = 0;
				} else {
					this.tempoDecorrido += delta;
				}
			break;
			case("ESQUERDA"):
				if(this.tempoDecorrido >= SnakeGameBasicView.DELAY) {
					x-=10;
					this.movimentar();
					this.tempoDecorrido = 0;
				} else {
					this.tempoDecorrido += delta;
				}
			break;
			case("CIMA"):
				if(this.tempoDecorrido >= SnakeGameBasicView.DELAY) {
					y-=10;				
					this.movimentar();
					this.tempoDecorrido = 0;
				} else {
					this.tempoDecorrido += delta;
				}
			break;
	 		}
		}
		
	}
	public void definirDirecao(GameContainer gc, int delta) {
		Input input = gc.getInput();
		if(!this.colidiuComElaMesma && !this.colidiuParede){
			if(this.tempoKey >= SnakeGameBasicView.DELAY_KEY) {
					if(input.isKeyPressed(Input.KEY_RIGHT)) {
						if(!this.teclaPressionada.equals("ESQUERDA")){
							this.teclaPressionada = Tecla.DIREITA.tecla;
						}
					} else if(input.isKeyPressed(Input.KEY_DOWN)) {
						if(!this.teclaPressionada.equals("CIMA")){
							this.teclaPressionada = Tecla.BAIXO.tecla;
						}
					} else if(input.isKeyPressed(Input.KEY_LEFT)) {
						if(!this.teclaPressionada.equals("DIREITA")){
							this.teclaPressionada = Tecla.ESQUERDA.tecla;
						}
					} else if(input.isKeyPressed(Input.KEY_UP)) {
						if(!this.teclaPressionada.equals("BAIXO")){
							this.teclaPressionada = Tecla.CIMA.tecla;
						}
					}
					this.tempoKey = 0;
				} else {
					this.tempoKey += delta;
				}
		}
	}
	
	public void movimentar() {
		if(x <= 19 || x >= 479 || y <= 19 || y >= 479) {
			this.colidiuParede = true;
		}
		if(this.snake.colidiu(new Vector2f(x, y))) {
			this.colidiuComElaMesma = true;
			this.snake.setAlive(false);
		}
		if(this.vaiMovimentar >= 0) {
			this.snake.getSnake().get(this.vaiMovimentar--).setPosition(x, y);
		} else {
			this.vaiMovimentar = this.snake.getSnake().size()-1;
			//Caso nao tenha essa linha, da a sensacao de movimento ondular, molar e talz
			//Mas ha um atraso dps de cada ondulação
			this.snake.getSnake().get(this.vaiMovimentar--).setPosition(x, y);
		}
		
		//COLISAO COM BLOCK. AUMENTA TAMANHO DA COBRA
		if(this.snake.getSnake().get(this.vaiMovimentar+1).getPosition().x == this.block.getPosition().x &&
				this.snake.getSnake().get(this.vaiMovimentar+1).getPosition().y == this.block.getPosition().y) {
			this.snake.getSnake().add(this.block);
			this.background = new Color(this.geradorGeral.nextInt(255),
					this.geradorGeral.nextInt(255),
					this.geradorGeral.nextInt(255));
			this.gerarBlock = true;
		}
	}
}
