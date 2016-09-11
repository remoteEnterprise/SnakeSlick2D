package com.remoteenterprise.VIEW;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import com.remoteenterprise.MODEL.Block;
import com.remoteenterprise.MODEL.Snake;

public class SnakeGameBasicView extends BasicGame {
	private Snake snake;
	private Block[] blocks;
	private boolean pegouBlock, gerarBlock;
	private int x = 30, y, vaiMovimentar, posicaoBlock;
	private final int DELAY = 100;
	private int tempoDecorrido;
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
	
	public SnakeGameBasicView(String title) {
		super(title);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		for(int i = this.snake.getSnake().size()-1; i >= 0 ; i--) {
			g.drawString(i+"", this.snake.getSnake().get(i).getPosition().getX(),
					this.snake.getSnake().get(i).getPosition().getY()-5);
			g.drawString(this.snake.getSnake().get(i).toString(),
					this.snake.getSnake().get(i).getPosition().getX(),
					this.snake.getSnake().get(i).getPosition().getY());
		}
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.snake = Snake.getInstance();
		this.vaiMovimentar = this.snake.getSnake().size()-1;
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		Input input = gc.getInput();
		if(input.isKeyPressed(Input.KEY_RIGHT)) {
			this.teclaPressionada = Tecla.DIREITA.tecla;
		}
		
		if(input.isKeyPressed(Input.KEY_DOWN)) {
			this.teclaPressionada = Tecla.BAIXO.tecla;
		}
		
		if(input.isKeyPressed(Input.KEY_LEFT)) {
			this.teclaPressionada = Tecla.ESQUERDA.tecla;
		}
		
		if(input.isKeyPressed(Input.KEY_UP)) {
			this.teclaPressionada = Tecla.CIMA.tecla;
		}
		
		switch(this.teclaPressionada){
		case("NENHUMA"):
			break;
		case("DIREITA"):
			if(this.tempoDecorrido >= this.DELAY) {
				x+=10;
				this.movimentar();
				this.tempoDecorrido = 0;
			} else {
				this.tempoDecorrido += delta;
			}
		break;
		case("BAIXO"):
			if(this.tempoDecorrido >= this.DELAY) {
				y+=10;
				this.movimentar();
				this.tempoDecorrido = 0;
			} else {
				this.tempoDecorrido += delta;
			}
		break;
		case("ESQUERDA"):
			if(this.tempoDecorrido >= this.DELAY) {
				x-=10;
				this.movimentar();
				this.tempoDecorrido = 0;
			} else {
				this.tempoDecorrido += delta;
			}
		break;
		case("CIMA"):
			if(this.tempoDecorrido >= this.DELAY) {
				y-=10;				
				this.movimentar();
				this.tempoDecorrido = 0;
			} else {
				this.tempoDecorrido += delta;
			}
		break;
 		}
		
	}
	public void movimentar() {
		if(this.vaiMovimentar >= 0) {
			this.snake.getSnake().get(this.vaiMovimentar--).setPosition(x, y);
		} else {
			this.vaiMovimentar = this.snake.getSnake().size()-1;
			//Caso nao tenha essa linha, da a sensacao de movimento ondular, molar e talz
			//Mas ha um atraso dps de cada ondulação
			this.snake.getSnake().get(this.vaiMovimentar--).setPosition(x, y);
		}
	}
}
