package input;

import subjects.Subjects;

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class InputHandler {
	
	private Keyboard keyboard = new Keyboard();
	private Mouse mouse       = new Mouse();
	
	public void handleInput(Subjects subject) {
		keyboard.handleInput(subject);
		mouse.handleInput();
	}
}
