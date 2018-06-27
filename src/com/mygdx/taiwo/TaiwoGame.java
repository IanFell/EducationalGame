package com.mygdx.taiwo;

import com.badlogic.gdx.Game;

import render.Render;
import screens.GameScreen;

/**
 * This is a game made for school students, coded by Fabulous Fellini
 * and produced by Taiwo (insert last name here).
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
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}
}
