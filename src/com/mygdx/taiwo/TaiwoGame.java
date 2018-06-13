package com.mygdx.taiwo;

import com.badlogic.gdx.Game;

import questions.Questions;
import render.Render;;

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
	public Render renderer = new Render();
	
	@Override
	public void create () {
	
	}

	@Override
	public void render () {
		super.render();
		gameLoop();
	}
	
	private void gameLoop() {
		System.out.print("Taiwo game in the gamme loop!");
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}
}
