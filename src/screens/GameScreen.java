package screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import subjects.Subjects;
import tests.Tests;

public class GameScreen implements Screen {
	private boolean buttonPressed = false;
	private Stage stage;
	private Texture myTexture;
	private TextureRegion myTextureRegion;
	private TextureRegionDrawable myTexRegionDrawable;
	private ImageButton button;
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
			myTexture = new Texture(Gdx.files.internal("badlogic.jpg"));
			myTextureRegion = new TextureRegion(myTexture);
			myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
			button = new ImageButton(myTexRegionDrawable); //Set the button up
			stage = new Stage(new ScreenViewport()); //Set up a stage for the ui
			stage.addActor(button); //Add the button to the stage to perform rendering and take input.
			Gdx.input.setInputProcessor(stage); //Start taking input from the ui
			hasBeenInitialized = true;
		}

		if (buttonPressed) {
			Gdx.gl.glClearColor(0, .5f, .5f, 0);
		} else {
			Gdx.gl.glClearColor(0, 0, 0, 0);
		}
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		stage.act(Gdx.graphics.getDeltaTime()); //Perform ui logic
		stage.draw(); //Draw the ui
		
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
		}

		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Button pressed!");
				Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				buttonPressed = true;
			}

		});
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
