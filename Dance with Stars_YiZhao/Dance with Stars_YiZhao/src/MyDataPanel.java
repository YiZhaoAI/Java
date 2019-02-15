import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MyDataPanel extends JPanel {

	/**
	 * The Data panel.
	 */
	private static final long serialVersionUID = 1L;
	Player p;

	MyDataPanel(Player p) {
		this.p = p;
	}

	public void paintComponent(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, 150, 300);
		g.setColor(Color.BLACK);

		g.drawString("Energy: " + p.getEnergy(), 10, 40);
		g.drawString("Dance Score: " + p.getScoreDance(), 10, 100);
		g.drawString("Look Score: " + p.getScoreLook(), 10, 160);
		g.drawString("Total Score: " + p.getScoreTotal(), 10, 220);

	}

}
