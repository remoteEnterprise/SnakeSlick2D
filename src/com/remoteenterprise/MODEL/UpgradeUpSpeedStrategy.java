package com.remoteenterprise.MODEL;

public class UpgradeUpSpeedStrategy implements UpgradeStrategy {

	@Override
	public void upgrade(Snake snake) {
		snake.setSpeed(snake.getSpeed()-10);
	}
}
