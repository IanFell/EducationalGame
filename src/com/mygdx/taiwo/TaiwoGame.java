package com.mygdx.taiwo;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import render.Render;
import screens.GameScreen;

/**
 * This is a game made for school students, coded by Fabulous Fellini
 * and produced by Taiwo Soyege.
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class TaiwoGame extends Game {
	
	/** 
	 * Game renderer.
	 */
	private Render renderer = new Render();
	
	@Override
	public void create () {
		this.setScreen(new GameScreen());
	}

	@Override
	public void render () {
		super.render();
		gameLoop();
	}
	
	private void gameLoop() {
		System.out.println("Taiwo game in the game loop!");
		System.out.println("Frames per second: " + Gdx.graphics.getFramesPerSecond());
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}
}
