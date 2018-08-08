package screens;

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

import handlers.SoundHandler;
import input.InputHandler;
import subjects.Subjects;
import tests.Tests;

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class GameScreen implements Screen {

	/**
	 * Variables for screen grid.  Currently it is 5 x 5.
	 */
	private int gridCount                     = 5;
	private float[] gridXAnswerButtonPosition = new float[gridCount];
	private float[] gridYAnswerButtonPosition = new float[gridCount];
	private float[] gridXSnapButtonPosition   = new float[gridCount];
	private float[] gridYSnapButtonPosition   = new float[gridCount];

	// Keep track if user has placed a correct answer on correct answer square and it has snapped in place.
	private boolean[] hasSnappedInPlace = new boolean[12];

	private InputHandler inputHandler = new InputHandler();
	
	private SoundHandler soundHandler = new SoundHandler();

	// Has game screen been initialized?  At launch no.  After launch yes.
	private boolean gameScreenHasBeenInitialized;

	private Stage stage;

	/**
	 * Button variables.
	 */
	private Texture subjectTexture;
	private TextureRegion subjectTextureRegion;
	private TextureRegionDrawable subjectTextureRegionDrawable;
	private ImageButton subjectLabel;  

	private Texture[] answerTextures                             = new Texture[12];
	private TextureRegion[] answerTextureRegions                 = new TextureRegion[12];
	private TextureRegionDrawable[] answerTextureRegionsDrawable = new TextureRegionDrawable[12];
	public ImageButton[] answerButtons                           = new ImageButton[12];

	private Texture[] answerSnapTextures                             = new Texture[12];
	private TextureRegion[] answerSnapTextureRegions                 = new TextureRegion[12];
	private TextureRegionDrawable[] answerSnapTextureRegionsDrawable = new TextureRegionDrawable[12];
	private ImageButton[] answerSnapButtons                          = new ImageButton[12];

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
		if (!gameScreenHasBeenInitialized) {
			initializeGameScreen();
			gameScreenHasBeenInitialized = true;
		}
		
		inputHandler.handleInput(subject);
		soundHandler.handleSound(this);

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (playerHasWon()) {
			// Change background color.  This will change eventually.  For now, just signify user has won.
			Gdx.gl.glClearColor(0.5f, 0.2f, 0.1f, 0);
		} else {
			Gdx.gl.glClearColor(0.1f, 0.5f, 0.2f, 0);
		}

		// Perform UI logic.
		stage.act(Gdx.graphics.getDeltaTime()); 

		// Draw the stage which contains the game play screen.
		stage.draw(); 


		for (int i = 0; i < answerButtons.length; i++) {
			if (
					answerButtons[i].getX() < answerSnapButtons[i].getX() + answerSnapButtons[i].getWidth() && answerButtons[i].getX() + answerButtons[i].getWidth() > answerSnapButtons[i].getX() &&
					answerButtons[i].getY() < answerSnapButtons[i].getY() + answerSnapButtons[i].getHeight()&& answerButtons[i].getY() + answerButtons[i].getHeight() > answerSnapButtons[i].getY()
					) {
				answerButtons[i].setPosition(answerSnapButtons[i].getX(), answerSnapButtons[i].getY());
				hasSnappedInPlace[i] = true;

				if (soundHandler.playSound[i]) {
					soundHandler.playRandomCorrectAnswerSound(i);
				}
			}
		}
	}

	public boolean playerHasWon() {
		for (int i = 0; i < hasSnappedInPlace.length; i++) {
			if (!hasSnappedInPlace[i]) {
				return false;
			}
		}
		return true;
	}

	private void initializeGameScreen() {
		subject.setCurrentSubject(Subjects.SUBJECT_BUS);
		gameScreenHasBeenInitialized = false;
		int gridXIncrement           = 15;
		int gridYIncrement           = 25;
		int gridYSnapButtonIncrement = 350;  // Different than gridYIncrement because this is the starting position of snap button one.
		for (int i = 0; i < gridXAnswerButtonPosition.length; i++) {
			gridXAnswerButtonPosition[i] += gridXIncrement;
			gridYAnswerButtonPosition[i] += gridYIncrement;
			gridXSnapButtonPosition[i]   += gridXIncrement;
			gridYSnapButtonPosition[i]   += gridYSnapButtonIncrement;
			gridXIncrement               += 275;
			int yIncrement               = 65;
			gridYIncrement               += yIncrement;
			gridYSnapButtonIncrement     += yIncrement;
		}
		initializeGui();
		soundHandler.init();
	}

	private void initializeGui() {
		subjectTexture               = new Texture(Gdx.files.internal("Question.png"));
		subjectTextureRegion         = new TextureRegion(subjectTexture);
		subjectTextureRegionDrawable = new TextureRegionDrawable(subjectTextureRegion);
		subjectLabel                 = new ImageButton(subjectTextureRegionDrawable); 

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

		answerSnapTextures[0]  = new Texture(Gdx.files.internal("AnswerBox1.png"));
		answerSnapTextures[1]  = new Texture(Gdx.files.internal("AnswerBox2.png"));
		answerSnapTextures[2]  = new Texture(Gdx.files.internal("AnswerBox3.png"));
		answerSnapTextures[3]  = new Texture(Gdx.files.internal("AnswerBox4.png"));
		answerSnapTextures[4]  = new Texture(Gdx.files.internal("AnswerBox5.png"));
		answerSnapTextures[5]  = new Texture(Gdx.files.internal("AnswerBox6.png"));
		answerSnapTextures[6]  = new Texture(Gdx.files.internal("AnswerBox7.png"));
		answerSnapTextures[7]  = new Texture(Gdx.files.internal("AnswerBox8.png"));
		answerSnapTextures[8]  = new Texture(Gdx.files.internal("AnswerBox9.png"));
		answerSnapTextures[9]  = new Texture(Gdx.files.internal("AnswerBox10.png"));
		answerSnapTextures[10] = new Texture(Gdx.files.internal("AnswerBox11.png"));
		answerSnapTextures[11] = new Texture(Gdx.files.internal("AnswerBox12.png"));

		stage = new Stage(new ScreenViewport()); 
		Gdx.input.setInputProcessor(stage); //Start taking input from the UI.

		subjectLabel.setPosition(Gdx.graphics.getWidth() / 2 - subjectLabel.getWidth() / 2, Gdx.graphics.getHeight() - subjectLabel.getHeight() * 1.5f);
		subjectLabel.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Subject button pressed!");
				Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
			}
		});
		stage.addActor(subjectLabel);

		// PUT ALL ANSWER SNAP STUFF TOGETHER, AS WELL AS EVERTHING ELSE.
		for (int i = 0; i < answerSnapButtons.length; i++) {
			answerSnapTextureRegions[i] = new TextureRegion(answerSnapTextures[i]);
			answerSnapTextureRegionsDrawable[i] = new TextureRegionDrawable(answerSnapTextureRegions[i]);
			answerSnapButtons[i] = new ImageButton(answerSnapTextureRegionsDrawable[i]);
			answerSnapButtons[i].setSize(answerSnapButtons[i].getWidth() / 2, answerSnapButtons[i].getHeight() / 2);
			stage.addActor(answerSnapButtons[i]);  
		}

		for (int i = 0; i < answerButtons.length; i++) {
			answerTextureRegions[i] = new TextureRegion(answerTextures[i]);
			answerTextureRegionsDrawable[i] = new TextureRegionDrawable(answerTextureRegions[i]);
			answerButtons[i] = new ImageButton(answerTextureRegionsDrawable[i]);
			answerButtons[i].setSize(answerButtons[i].getWidth() / 2, answerButtons[i].getHeight() / 2);
			stage.addActor(answerButtons[i]);  
		}

		answerButtons[0].setX(gridXAnswerButtonPosition[0]);
		answerButtons[1].setX(gridXAnswerButtonPosition[1]);
		answerButtons[2].setX(gridXAnswerButtonPosition[2]);
		answerButtons[3].setX(gridXAnswerButtonPosition[3]);
		answerButtons[4].setX(gridXAnswerButtonPosition[4]);
		answerButtons[5].setX(gridXAnswerButtonPosition[0]);
		answerButtons[6].setX(gridXAnswerButtonPosition[1]);
		answerButtons[7].setX(gridXAnswerButtonPosition[2]);
		answerButtons[8].setX(gridXAnswerButtonPosition[3]);
		answerButtons[9].setX(gridXAnswerButtonPosition[4]);
		answerButtons[10].setX(gridXAnswerButtonPosition[0]);
		answerButtons[11].setX(gridXAnswerButtonPosition[1]);

		answerButtons[0].setY(gridYAnswerButtonPosition[0]);
		answerButtons[1].setY(gridYAnswerButtonPosition[1]);
		answerButtons[2].setY(gridYAnswerButtonPosition[2]);
		answerButtons[3].setY(gridYAnswerButtonPosition[3]);
		answerButtons[4].setY(gridYAnswerButtonPosition[4]);
		answerButtons[5].setY(gridYAnswerButtonPosition[3]);
		answerButtons[6].setY(gridYAnswerButtonPosition[2]);
		answerButtons[7].setY(gridYAnswerButtonPosition[1]);
		answerButtons[8].setY(gridYAnswerButtonPosition[0]);
		answerButtons[9].setY(gridYAnswerButtonPosition[1]);
		answerButtons[10].setY(gridYAnswerButtonPosition[2]);
		answerButtons[11].setY(gridYAnswerButtonPosition[3]);

		answerSnapButtons[0].setX(gridXSnapButtonPosition[0]);
		answerSnapButtons[1].setX(gridXSnapButtonPosition[1]);
		answerSnapButtons[2].setX(gridXSnapButtonPosition[2]);
		answerSnapButtons[3].setX(gridXSnapButtonPosition[3]);
		answerSnapButtons[4].setX(gridXSnapButtonPosition[4]);
		answerSnapButtons[5].setX(gridXSnapButtonPosition[0]);
		answerSnapButtons[6].setX(gridXSnapButtonPosition[1]);
		answerSnapButtons[7].setX(gridXSnapButtonPosition[2]);
		answerSnapButtons[8].setX(gridXSnapButtonPosition[3]);
		answerSnapButtons[9].setX(gridXSnapButtonPosition[4]);
		answerSnapButtons[10].setX(gridXSnapButtonPosition[0]);
		answerSnapButtons[11].setX(gridXSnapButtonPosition[1]);

		answerSnapButtons[0].setY(gridYSnapButtonPosition[0]);
		answerSnapButtons[1].setY(gridYSnapButtonPosition[1]);
		answerSnapButtons[2].setY(gridYSnapButtonPosition[2]);
		answerSnapButtons[3].setY(gridYSnapButtonPosition[3]);
		answerSnapButtons[4].setY(gridYSnapButtonPosition[4]);
		answerSnapButtons[5].setY(gridYSnapButtonPosition[3]);
		answerSnapButtons[6].setY(gridYSnapButtonPosition[2]);
		answerSnapButtons[7].setY(gridYSnapButtonPosition[1]);
		answerSnapButtons[8].setY(gridYSnapButtonPosition[0]);
		answerSnapButtons[9].setY(gridYSnapButtonPosition[1]);
		answerSnapButtons[10].setY(gridYSnapButtonPosition[2]);
		answerSnapButtons[11].setY(gridYSnapButtonPosition[3]);

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
			answerSnapTextures[i].dispose();
		}
		soundHandler.dispose();
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
				if (!hasSnappedInPlace[0]) {
					answerButtons[0].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[1] && hasSnappedInPlace[0]) {
					answerButtons[1].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[2] && hasSnappedInPlace[1]) {
					answerButtons[2].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());

				}
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
				if (!hasSnappedInPlace[3] && hasSnappedInPlace[2]) {
					answerButtons[3].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[4] && hasSnappedInPlace[3]) {
					answerButtons[4].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[5]  && hasSnappedInPlace[4]) {
					answerButtons[5].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[6] && hasSnappedInPlace[5]) {
					answerButtons[6].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[7] && hasSnappedInPlace[6]) {
					answerButtons[7].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[8] && hasSnappedInPlace[7]) {
					answerButtons[8].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[9] && hasSnappedInPlace[8]) {
					answerButtons[9].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[10] && hasSnappedInPlace[9]) {
					answerButtons[10].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
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
				if (!hasSnappedInPlace[11] && hasSnappedInPlace[10]) {
					answerButtons[11].setPosition(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
				}
			}
		});
	}
}
