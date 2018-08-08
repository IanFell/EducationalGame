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
	
	/**
	 * Sounds play when user gets correct answer on correct answer square.
	 * Crowd cheers when user gets all answers on all answer squares.
	 */
	public boolean[] playSound       = new boolean[12];
	public boolean playWinningSound  = true;
	public Sound ahhSound            = Gdx.audio.newSound(Gdx.files.internal("Ahh.mp3"));
	public Sound ohhSound            = Gdx.audio.newSound(Gdx.files.internal("Ohh.mp3"));
	public Sound wowSound            = Gdx.audio.newSound(Gdx.files.internal("Wow.mp3"));
	public Sound crowdCheeringSound  = Gdx.audio.newSound(Gdx.files.internal("CrowdCheering.mp3"));
	
	/**
	 * Used to determine which sound to play when user gets a correct answer on answer square.
	 * This will either be ahh, ooh, or wow from above.
	 */
	public int randomSound;
	
	public void init() {
		for (int i = 0; i < playSound.length; i++) {
			playSound[i] = true;
		}
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
