package com.remoteenterprise.MODEL;

import org.newdawn.slick.Image;

public class Upgrade {
	private String nome;
	private int id;
	private Image image;
	private UpgradeStrategy upgradeStrategy;
	
	public Upgrade(String nome, int id, UpgradeStrategy upgradeStrategy) {
		this.nome = nome;
		this.id = id;
		this.upgradeStrategy = upgradeStrategy;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public UpgradeStrategy getUpgradeStrategy() {
		return upgradeStrategy;
	}

	public void setUpgradeStrategy(UpgradeStrategy upgradeStrategy) {
		this.upgradeStrategy = upgradeStrategy;
	}
}
