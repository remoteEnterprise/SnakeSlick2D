package com.remoteenterprise.MODEL;

import org.newdawn.slick.geom.Vector2f;

public interface Snake2D {
	public void reset();
	public void resetStatusUpgrade();
	public boolean colidiu(Vector2f posicao);
}
