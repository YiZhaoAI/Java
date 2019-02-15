import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyGameFrame extends JFrame {

	/**
	 * The Game Frame
	 */
	private static final long serialVersionUID = 1L;

	private MyDataPanel mdp;
	private MyGamePanel mgp;
	Player p;

	MyGameFrame() {
		this.setTitle("Dance With Stars!");
		this.setSize(650, 550);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		p = new Player();
		mgp = new MyGamePanel(p);
		mgp.setBounds(0, 0, 500, 500);
		this.add(mgp);

		mdp = new MyDataPanel(p);
		mdp.setBounds(500, 0, 150, 300);
		this.add(mdp);

		// **********************************************************
		JPanel mbp = new JPanel();
		mbp.setBounds(500, 300, 150, 200);
		GridLayout layoutButton = new GridLayout(2, 1);
		mbp.setLayout(layoutButton);
		JButton button1 = new JButton("High Scores");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HighScores.showScores();
			}
		});
		mbp.add(button1);

		JButton button2 = new JButton("Exit");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mbp.add(button2);
		this.add(mbp);
		// ***************************************************

		mgp.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int tempX = e.getX() / 50 * 50;
				int tempY = e.getY() / 50 * 50;

				int gX = mgp.grid.getGridX();
				int gY = mgp.grid.getGridY();

				if (tempX == gX && tempY == gY) {
					p.playerUpdate(mgp.grid);
					mdp.repaint();
				}

				if (tempX <= 450 && tempY <= 450) {
					if ((Math.abs(tempX - p.getPlayerX()) + Math.abs(tempY - p.getPlayerY()) <= 50)
							|| (Math.abs(tempX - p.getPlayerX()) == 50 && Math.abs(tempY - p.getPlayerY()) == 50)) {
						p.setPlayerX(tempX);
						p.setPlayerY(tempY);
						p.setEnergy(p.getEnergy() - 20);
						if (p.getEnergy() < 0) {
							Main.running = false;
							JOptionPane.showMessageDialog(null, "Energy Run Out!", "INFO", JOptionPane.ERROR_MESSAGE);
						}
					}

					else {
						JOptionPane.showMessageDialog(null, "Invalid Move", "INFO", JOptionPane.ERROR_MESSAGE);
					}

					if (Main.running) {
						mdp.repaint();
						mgp.repaint();

					}

					else {
						JOptionPane.showMessageDialog(null, "EXIT", "INFO", JOptionPane.CLOSED_OPTION);
						HighScores.putNewScore(p.getScoreTotal());
						HighScores.showScores();
						try {
							HighScores.writeScores();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

				}

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

	}

}
