import java.util.Random;

import javax.swing.JOptionPane;

public class Player {

	// Fields of class Player
	private int playerX;
	private int playerY;
	private int energy;
	private int scoreDance;
	private int scoreLook;
	private int scoreTotal;

	// Initialize the player's energy and scores
	public Player() {
		Random r = new Random();
		playerX = r.nextInt(10) * 50;
		playerY = r.nextInt(10) * 50;

		this.energy = (20 - StartWindow.diffLevel) * 10;
		this.scoreDance = 200 - 20 * StartWindow.tradeOff;
		this.scoreLook = 20 * StartWindow.tradeOff;
		this.scoreTotal = this.scoreDance + this.scoreLook;

	}

	// Update scoreTotal
	public void sTUpdate() {
		this.scoreTotal = this.scoreDance + this.scoreLook;
	}

	// Depending on the grid's type, the player's energy and scores change
	public void playerUpdate(Grid grid) {
		switch (grid.getGridType()) {
		case 1:
			if (this.scoreDance >= Thre.expectJ1) {
				this.scoreDance += 50;
				this.sTUpdate();
				JOptionPane.showMessageDialog(null, "You IMPRESSED Juror 1!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "You did NOT impress Juror 1!", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case 2:
			if (this.scoreDance >= Thre.expectJ2) {
				this.scoreDance += 50;
				this.sTUpdate();
				JOptionPane.showMessageDialog(null, "You IMPRESSED Juror 2!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "You did NOT impress Juror 2!", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case 3:
			if (this.scoreDance >= Thre.expectJ3) {
				this.scoreDance += 50;
				this.sTUpdate();
				JOptionPane.showMessageDialog(null, "You IMPRESSED Juror 3!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "You did NOT impress Juror 3!", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case 4:
			if (this.scoreLook >= Thre.expectS1) {
				this.scoreLook += 50;
				this.sTUpdate();
				JOptionPane.showMessageDialog(null, "You IMPRESSED Star 1!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "You did NOT impress Star 1!", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case 5:
			if (this.scoreLook >= Thre.expectS2) {
				this.scoreLook += 50;
				this.sTUpdate();
				JOptionPane.showMessageDialog(null, "You IMPRESSED Star 2!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "You did NOT impress Star 2!", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case 6:
			if (this.scoreTotal >= Thre.expectC1) {
				this.scoreLook += 50;
				this.sTUpdate();
				JOptionPane.showMessageDialog(null, "You DEFEATED Competitor 1!", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "You did NOT defeat Competitor 1!", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;

		case 7:
			if (this.scoreTotal >= Thre.expectC2) {
				this.scoreDance += 50;
				this.sTUpdate();
				JOptionPane.showMessageDialog(null, "You DEFEATED Competitor 2!", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "You did not defeat Competitor 2!", "INFO",
						JOptionPane.INFORMATION_MESSAGE);
			}
			break;
		case 8:
			this.scoreLook += Thre.aLScoreLookInc;
			JOptionPane.showMessageDialog(null, "Award for your Look!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			this.sTUpdate();
			break;

		case 9:
			this.scoreDance += Thre.aDScoreDanceInc;
			JOptionPane.showMessageDialog(null, "Award for your Dance!", "INFO", JOptionPane.INFORMATION_MESSAGE);
			this.sTUpdate();
			break;

		case 10:
			this.energy -= Thre.blEnerLoss;
			if (this.energy < 0) {
				Main.running = false;
				JOptionPane.showMessageDialog(null, "Energy Run Out!", "INFO", JOptionPane.ERROR_MESSAGE);
			}
			this.scoreDance += Thre.blScoreDanceInc;
			this.sTUpdate();
			JOptionPane.showMessageDialog(null, "Energy decreased but your Dance Score INCREASED!", "INFO",
					JOptionPane.INFORMATION_MESSAGE);
			break;

		case 11:
			this.energy -= Thre.sfEnerLoss;
			if (this.energy < 0) {
				Main.running = false;
				JOptionPane.showMessageDialog(null, "Energy Run Out!", "INFO", JOptionPane.ERROR_MESSAGE);
			}
			this.scoreDance += Thre.aDScoreDanceInc;
			this.sTUpdate();
			JOptionPane.showMessageDialog(null, "Energy decreased but your Dance Score INCREASED!", "INFO",
					JOptionPane.INFORMATION_MESSAGE);
			break;

		case 12:

			JOptionPane.showMessageDialog(null, "WIN THE TROPHY!CONGRATULATUIONS!", "INFO",
					JOptionPane.INFORMATION_MESSAGE);

			this.scoreDance += 250;
			this.scoreLook += 250;
			this.sTUpdate();
			Main.running = false;
			break;

		}
		return;
	}

	// getters and
	// setters***************************************************************
	public int getPlayerX() {
		return this.playerX;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public int getPlayerY() {
		return this.playerY;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

	public int getEnergy() {
		return this.energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getScoreDance() {
		return this.scoreDance;
	}

	public void setScoreDance(int scoreDance) {
		this.scoreDance = scoreDance;
	}

	public int getScoreLook() {
		return this.scoreLook;
	}

	public void setScoreLook(int scoreLook) {
		this.scoreLook = scoreLook;
	}

	public int getScoreTotal() {
		return this.scoreTotal;
	}

	public void setScoreTotal(int scoreTotal) {
		this.scoreTotal = scoreTotal;
	}
	// ***************************************************************
}
