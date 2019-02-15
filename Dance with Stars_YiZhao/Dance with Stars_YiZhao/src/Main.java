import java.io.IOException;

public class Main {
	/*
	 * Dance with Stars.----by Yi Zhao
	 */

	public static boolean running = true;

	// main function
	public static void main(String[] args) {

		// read the history scores
		try {
			HighScores.readScores();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// load images
		new Img();

		// start the game
		StartWindow.launchStartWindow();

	}

}
