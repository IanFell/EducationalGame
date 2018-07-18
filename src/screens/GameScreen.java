package screens;

import java.util.Random;

import com.badlogic.gdx.Gdx;
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

import input.InputHandler;
import subjects.Subjects;
import tests.Tests;

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class GameScreen implements Screen {
	
	private InputHandler inputHandler = new InputHandler();
	
	/**
	 * Has game screen been initialized?
	 * At launch no.  After launch yes.
	 */
	private boolean hasBeenInitialized;
	
	/**
	 * These are variables for the button.
	 */
	private Stage stage;
	private Texture subjectTexture;
	private TextureRegion subjectTextureRegion;
	private TextureRegionDrawable subjectTextureRegionDrawable;
	private ImageButton subjectButton;  // change this to normal image
	
	private Texture[] answerTextures                             = new Texture[12];
	private TextureRegion[] answerTextureRegions                 = new TextureRegion[12];
	private TextureRegionDrawable[] answerTextureRegionsDrawable = new TextureRegionDrawable[12];
	private ImageButton[] answerButtons                          = new ImageButton[12];
	
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
		
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.gl.glClearColor(0.1f, 0.5f, 0.2f, 0);

		inputHandler.handleInput(subject);
		
		// Perform UI logic.
		stage.act(Gdx.graphics.getDeltaTime()); 
		
		// Draw the stage which contains the button.
		stage.draw(); 
	}
	
	private void initializeGameScreen() {
		subject.setCurrentSubject(Subjects.SUBJECT_BUS);
		hasBeenInitialized = false;
		initializeGui();
	}
	
	private void initializeGui() {
		subjectTexture               = new Texture(Gdx.files.internal("Question.png"));
		subjectTextureRegion         = new TextureRegion(subjectTexture);
		subjectTextureRegionDrawable = new TextureRegionDrawable(subjectTextureRegion);
		subjectButton                = new ImageButton(subjectTextureRegionDrawable); 
		
		answerTextures[0]  = new Texture(Gdx.files.internal("AnswerOne.png"));
		answerTextures[1]  = new Texture(Gdx.files.internal("AnswerTwo.png"));
		answerTextures[2]  = new Texture(Gdx.files.internal("AnswerThree.png"));
		answerTextures[3]  = new Texture(Gdx.files.internal("AnswerFour.png"));
		answerTextures[4]  = new Texture(Gdx.files.internal("AnswerFive.png"));
		answerTextures[5]  = new Texture(Gdx.files.internal("AnswerSix.png"));
		answerTextures[6]  = new Texture(Gdx.files.internal("AnswerSeven.png"));
		answerTextures[7]  = new Texture(Gdx.files.internal("AnswerEight.png"));
		answerTextures[8]  = new Texture(Gdx.files.internal("AnswerNine.png"));
		answerTextures[9]  = new Texture(Gdx.files.internal("AnswerTen.png"));
		answerTextures[10] = new Texture(Gdx.files.internal("AnswerEleven.png"));
		answerTextures[11] = new Texture(Gdx.files.internal("AnswerTwelve.png"));
		

		stage = new Stage(new ScreenViewport()); 
		Gdx.input.setInputProcessor(stage); //Start taking input from the ui
		
		subjectButton.setPosition(Gdx.graphics.getWidth() / 2 - subjectButton.getWidth() / 2, Gdx.graphics.getHeight() - subjectButton.getHeight() * 1.5f);
		subjectButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Subject button pressed!");
				Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
			}
		});
		
		stage.addActor(subjectButton);
		
		Random random = new Random();
		for (int i = 0; i < answerButtons.length; i++) {
			answerTextureRegions[i] = new TextureRegion(answerTextures[i]);
			answerTextureRegionsDrawable[i] = new TextureRegionDrawable(answerTextureRegions[i]);
			answerButtons[i] = new ImageButton(answerTextureRegionsDrawable[i]);
			answerButtons[i].setSize(answerButtons[i].getWidth() / 2, answerButtons[i].getHeight() / 2);
			stage.addActor(answerButtons[i]);
			answerButtons[i].setPosition(
					random.nextInt((int)(stage.getWidth())), 
					random.nextInt((int) stage.getHeight())
					);
			
		}
		setUpAnswerButtonClickListeners();
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
		subjectTexture.dispose();
		for (int i= 0; i < answerTextures.length; i++) {
			answerTextures[i].dispose();
		}
	}

		private void setUpAnswerButtonClickListeners() {
			
			answerButtons[0].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[0].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			answerButtons[1].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[1].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			answerButtons[2].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[2].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			answerButtons[3].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[3].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			answerButtons[4].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[4].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			
			answerButtons[5].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[5].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			
			answerButtons[6].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[6].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			
			answerButtons[7].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[7].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			answerButtons[8].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[8].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			answerButtons[9].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[9].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			answerButtons[10].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[10].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
			
			
			answerButtons[11].addListener(new ClickListener() {
				@Override
				public void clicked(InputEvent event, float x, float y) {
					System.out.println("Button pressed!");
					Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
				}
				
				@Override
				public void touchDragged(InputEvent event, float x, float y, int pointer) {
					answerButtons[11].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			});
		}
}
