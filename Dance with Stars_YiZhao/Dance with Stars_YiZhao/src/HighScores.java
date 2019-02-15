import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.*;

public class HighScores {

	private static BufferedReader br;
	private static BufferedWriter bw;
	public static int[] highScores = new int[3];

	public static void readScores() throws IOException {
		// read the history scores
		br = new BufferedReader(new FileReader(new File("src\\scores.txt")));
		String s = br.readLine();
		highScores = new int[3];
		String[] ss = s.split(" ");
		for (int i = 0; i < 3; i++) {
			highScores[i] = Integer.parseInt(ss[i]);
		}
	}

	public static void putNewScore(int score) {
		Arrays.sort(highScores);
		if (score > highScores[2]) {
			JOptionPane.showMessageDialog(null, "Your score is the LARGEST score in history!", "SCORES",
					JOptionPane.CLOSED_OPTION);
			highScores[0] = highScores[1];
			highScores[1] = highScores[2];
			highScores[2] = score;
		}
		if (score > highScores[1] && score < highScores[2]) {
			JOptionPane.showMessageDialog(null, "Your score is the SECOND largest score in history!", "SCORES",
					JOptionPane.CLOSED_OPTION);
			highScores[0] = highScores[1];
			highScores[1] = score;
		}
		if (score > highScores[0] && score < highScores[1]) {
			JOptionPane.showMessageDialog(null, "Your score is the THIRD largest score in history!", "SCORES",
					JOptionPane.CLOSED_OPTION);
			highScores[0] = score;
		}
	}

	public static void showScores() {
		JFrame frameScore = new JFrame("SCORE");
		JPanel panelScore = new JPanel();
		GridLayout layoutScore = new GridLayout(4, 1);
		panelScore.setLayout(layoutScore);

		JLabel titleScore = new JLabel("The three highest scores in history: ");
		panelScore.add(titleScore);

		JLabel scoreFirst = new JLabel();
		scoreFirst.setText("No.1: " + highScores[2]);
		panelScore.add(scoreFirst);

		JLabel scoreSecond = new JLabel();
		scoreSecond.setText("No.2: " + highScores[1]);
		panelScore.add(scoreSecond);

		JLabel scoreThird = new JLabel();
		scoreThird.setText("No.3: " + highScores[0]);
		panelScore.add(scoreThird);

		frameScore.add(panelScore);
		frameScore.setContentPane(panelScore);
		frameScore.pack();
		frameScore.setVisible(true);
		frameScore.setResizable(false);
		frameScore.setLocationRelativeTo(null);

	}

	public static void writeScores() throws IOException {
		bw = new BufferedWriter(new FileWriter(new File("src\\scores.txt")));
		String s = "";

		for (int i = 0; i < 3; i++) {
			s += highScores[i] + " ";
		}

		bw.write(s);

		bw.close();

	}
}
