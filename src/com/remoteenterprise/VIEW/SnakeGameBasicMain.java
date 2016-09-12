package com.remoteenterprise.VIEW;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class SnakeGameBasicMain {

	public static void main(String[] args) {
		try {
			AppGameContainer agc = new AppGameContainer(new SnakeGameBasicView("Snake"));
			agc.setDisplayMode(500, 500, false);
			agc.setVSync(true);
			agc.setShowFPS(false);
			agc.setTargetFrameRate(59);
			agc.start();
		} catch(SlickException e) {
			e.printStackTrace();
		}

	}

}
