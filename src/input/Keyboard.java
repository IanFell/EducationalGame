package input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import subjects.Subjects;
import tests.Tests;

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class Keyboard {
	public void handleInput(Subjects subject) {
		if(Gdx.input.isKeyPressed(Input.Keys.ENTER)) {
			Tests.outputSubjectQuestionAndAnswers(subject, subject.getCurrentSubject());
		}
	}
}
