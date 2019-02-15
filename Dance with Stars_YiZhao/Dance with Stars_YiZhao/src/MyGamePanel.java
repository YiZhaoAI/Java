import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class MyGamePanel extends JPanel {

	/**
	 * The game Panel.
	 */
	private static final long serialVersionUID = 1L;
	Player p;
	public Grid grid;


	public MyGamePanel(Player p) {
		this.p = p;
	}

	public void paintComponent(Graphics g) {
		grid = new Grid(p);
		BufferedImage bi = null;
		switch (grid.getGridType()) {
		case 1:
			bi = Img.juror1P;
			break;
		case 2:
			bi = Img.juror2P;
			break;
		case 3:
			bi = Img.juror3P;
			break;
		case 4:
			bi = Img.star1P;
			break;
		case 5:
			bi = Img.star2P;
			break;
		case 6:
			bi = Img.competitor1P;
			break;
		case 7:
			bi = Img.competitor2P;
			break;
		case 8:
			bi = Img.awardLookP;
			break;
		case 9:
			bi = Img.awardDanceP;
			break;
		case 10:
			bi = Img.blindLightP;
			break;
		case 11:
			bi = Img.slipFloorP;
			break;
		case 12:
			bi = Img.trophyP;
		}
		g.fillRect(0, 0, 500, 500);

		// setting the visible area
		g.setColor(Color.WHITE);
		if (p.getPlayerX() == 450 && p.getPlayerY() == 450)
			g.fillRect(p.getPlayerX() - 50, p.getPlayerY() - 50, 100, 100);
		else if (p.getPlayerX() == 450)
			g.fillRect(p.getPlayerX() - 50, p.getPlayerY() - 50, 100, 150);
		else if (p.getPlayerY() == 450)
			g.fillRect(p.getPlayerX() - 50, p.getPlayerY() - 50, 150, 100);
		else
			g.fillRect(p.getPlayerX() - 50, p.getPlayerY() - 50, 150, 150);

		// setting the player
		g.drawImage(Img.playerP, p.getPlayerX(), p.getPlayerY(), 50, 50, null);
		g.drawImage(bi, grid.getGridX(), grid.getGridY(), 50, 50, null);

		g.setColor(Color.GREEN);
		for (int i = 0; i < 10; i++) {
			g.drawLine(0, i * 50, 500, i * 50);
			g.drawLine(i * 50, 0, i * 50, 500);
		}

	}

}
	

