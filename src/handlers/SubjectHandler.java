package handlers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

import subjects.Subjects;
import tests.Tests;

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class SubjectHandler {
	
	private Texture subjectTexture;
	private TextureRegion subjectTextureRegion;
	private TextureRegionDrawable subjectTextureRegionDrawable;
	private ImageButton subjectLabel;  
	
	/**
	 * 
	 * @param Stage    stage
	 * @param Subjects subject
	 */
	public void init(Stage stage, final Subjects subject) {
		subjectTexture               = new Texture(Gdx.files.internal("Question.png"));
		subjectTextureRegion         = new TextureRegion(subjectTexture);
		subjectTextureRegionDrawable = new TextureRegionDrawable(subjectTextureRegion);
		subjectLabel                 = new ImageButton(subjectTextureRegionDrawable); 
		
		subjectLabel.setPosition(
				Gdx.graphics.getWidth() / 2 - subjectLabel.getWidth() / 2, 
				Gdx.graphics.getHeight() - subjectLabel.getHeight() * 1.25f
				);
		subjectLabel.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				System.out.println("Subject button pressed!");
				Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
			}
		});
		stage.addActor(subjectLabel);
	}
	
	public void dispose() {
		subjectTexture.dispose();
	}
}
