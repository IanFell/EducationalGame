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

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class GameScreen implements Screen {
	
	/**
	 * Keeps track if button has been pressed.  
	 * There is only one button.  This is only a comment until 
	 * we actually begin coding the game.
	 */
	private boolean buttonPressed;
	
	/**
	 * Has game screen been initialized?
	 * At launch no.  After launch yes.
	 */
	private boolean hasBeenInitialized;
	
	/**
	 * These are variables for the button.
	 */
	private Stage stage;
	private Texture myTexture;
	private TextureRegion myTextureRegion;
	private TextureRegionDrawable myTexRegionDrawable;
	private ImageButton button;
	
	/**
	 * In this class we only need a Subjects class. 
	 * The Subjects class takes the Questions class.
	 * The Questions class takes the Answers class.
	 */
	private Subjects subject = new Subjects();

	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void render(float delta) {
		if (!hasBeenInitialized) {
			initializeGameScreen();
			hasBeenInitialized = true;
		}

		/**
		 * Handle input.
		 * However, input is also handled by the ClickEvent Handler.
		 * Somewhere we will have to set buttonPressed back to false after event is over.
		 * Make a class to handle input, both keyboard and mouse.
		 */
		if (buttonPressed) {
			Gdx.gl.glClearColor(0, .5f, .5f, 0);
		} else {
			Gdx.gl.glClearColor(0, 0, 0, 0);
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
		}
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		// Perform UI logic.
		stage.act(Gdx.graphics.getDeltaTime()); 
		
		// Draw the stage which contains the button.
		stage.draw(); 
	}
	
	private void initializeGameScreen() {
		subject.setCurrentSubject(Subjects.SUBJECT_BUS);
		buttonPressed      = false;
		hasBeenInitialized = false;
		initializeGui();
	}
	
	private void initializeGui() {
		myTexture           = new Texture(Gdx.files.internal("badlogic.jpg"));
		myTextureRegion     = new TextureRegion(myTexture);
		myTexRegionDrawable = new TextureRegionDrawable(myTextureRegion);
		button              = new ImageButton(myTexRegionDrawable); 
		// Set up a stage for the UI.
		stage               = new Stage(new ScreenViewport()); 
		//Add the button to the stage to perform rendering and take input.
		stage.addActor(button); 
		Gdx.input.setInputProcessor(stage); //Start taking input from the ui
		button.setPosition(Gdx.graphics.getWidth() / 2 - button.getWidth() / 2, Gdx.graphics.getHeight() / 2 - button.getHeight() / 2);
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
