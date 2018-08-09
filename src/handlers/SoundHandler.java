package handlers;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

import screens.GameScreen;

/**
 * 
 * @author Taiwo / Fabulous Fellini
 *
 */
public class SoundHandler {
	
	public Sound ahhSound;
	public Sound ohhSound;
	public Sound wowSound;
	public Sound crowdCheeringSound;
	
	/**
	 * Sounds play when user gets correct answer on correct answer square.
	 * Crowd cheers when user gets all answers on all answer squares.
	 */
	public boolean[] playSound       = new boolean[12];
	public boolean playWinningSound  = true;
	
	/**
	 * Used to determine which sound to play when user gets a correct answer on answer square.
	 * This will either be ahh, ooh, or wow from above.
	 */
	public int randomSound;
	
	public void init() {
		for (int i = 0; i < playSound.length; i++) {
			playSound[i] = true;
		}
		loadSounds();
	}
	
	private void loadSounds() {
		ahhSound            = Gdx.audio.newSound(Gdx.files.internal("Ahh.mp3"));
		ohhSound            = Gdx.audio.newSound(Gdx.files.internal("Ohh.mp3"));
		wowSound            = Gdx.audio.newSound(Gdx.files.internal("Wow.mp3"));
		crowdCheeringSound  = Gdx.audio.newSound(Gdx.files.internal("CrowdCheering.mp3"));
	}
	
	public void dispose() {
		ahhSound.dispose();
		ohhSound.dispose();
		wowSound.dispose();
		crowdCheeringSound.dispose();
	}

	/**
	 * 
	 * @param GameScreen gameScreen
	 */
	public void handleSound(GameScreen gameScreen) {
		if (gameScreen.playerHasWon()) {
			if (playWinningSound) {
				crowdCheeringSound.play();
				playWinningSound = false;
			}
		}	
	}

	/**
	 * Generate and play random sound when user places the correct answer
	 * over the correct answer snap square.
	 * 
	 * @param int i
	 */
	public void playRandomCorrectAnswerSound(int i) {
		Random random = new Random();
		randomSound   = random.nextInt(3);
		switch (randomSound) {
		case 0:
			ahhSound.play();
			break;
		case 1:
			ohhSound.play();
			break;
		case 2:
			wowSound.play();
			break;
		default:
			playSound[i] = false;
		}
		playSound[i] = false;
	}
}
