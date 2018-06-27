package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;

import subjects.Subjects;

public class GameScreen implements Screen {
	
	private boolean hasBeenInitialized = false;
	
	private Subjects subject = new Subjects();
 
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		
		if (!hasBeenInitialized) {
			subject.setCurrentSubject(Subjects.SUBJECT_BUS);
			hasBeenInitialized = true;
		}
		
		Gdx.gl.glClearColor(0, .5f, .5f, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
			int currentSubject = subject.getCurrentSubject();
			System.out.println("Current subject: " + currentSubject);
			System.out.println("Current question: " + subject.getQuestion().getCurrentQuestionBasedOnCurrentSubject(currentSubject));
			for (int i = 0; i < subject.getQuestion().getAnswer().answers[0].length; i++) {
				System.out.println("Current answers: " + subject.getQuestion().getAnswer().answers[0][i]);
			}
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}
}
