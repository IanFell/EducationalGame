package com.mygdx.taiwo;

import com.badlogic.gdx.Game;

import questions.Questions;
import render.Render;
import screens.GameScreen;
import subjects.Subjects;

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
	
	private Subjects subject   = new Subjects();
	private Questions question = new Questions();
	
	@Override
	public void create () {
		subject.setCurrentSubject(Subjects.SUBJECT_BUS);
		this.setScreen(new GameScreen());
	}

	@Override
	public void render () {
		super.render();
		gameLoop();
	}
	
	private void gameLoop() {
		System.out.println("Taiwo game in the game loop!");
		int currentSubject = subject.getCurrentSubject();
		System.out.println("Current subject: " + currentSubject);
		System.out.println("Current questions: " + question.getCurrentQuestionBasedOnCurrentSubject(currentSubject));
	}
	
	@Override
	public void dispose () {
		renderer.dispose();
	}
}
