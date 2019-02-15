import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class StartWindow extends JFrame {

	/**
	 * The start window
	 */
	private static final long serialVersionUID = 1L;
	public static int diffLevel = 4;
	public static int tradeOff = 5;

	public static void launchStartWindow() {

		// create the frame
		JFrame frame = new JFrame();

		// create the host panel
		JPanel panelHost = new JPanel();
		BoxLayout layoutHost = new BoxLayout(panelHost, BoxLayout.Y_AXIS);
		panelHost.setLayout(layoutHost);

		// labelTop is added into the host panel
		JLabel labelTop = new JLabel("Dancing with the stars");
		panelHost.add(labelTop);

		// panelSlider is for the two JSlider components
		JPanel panelSlider = new JPanel();

		BoxLayout layoutSlider = new BoxLayout(panelSlider, BoxLayout.Y_AXIS);
		panelSlider.setLayout(layoutSlider);

		// JSlider slider1
		JLabel labelDifficulty = new JLabel("Select the difficulty level: ");
		panelSlider.add(labelDifficulty);
		JSlider slider1 = new JSlider(1, 10, 4);

		slider1.setMajorTickSpacing(1);
		slider1.setPaintTicks(true);
		slider1.setSnapToTicks(true);
		slider1.setPaintTrack(true);
		slider1.setPaintLabels(true);

		// listening slider1 to get the diffLevel value
		slider1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				diffLevel = slider1.getValue();
			}
		});

		panelSlider.add(slider1);

		// JSlider slider2
		JLabel labelBalance = new JLabel("Assign your skill points to looks and dancing skills");
		panelSlider.add(labelBalance);
		JSlider slider2 = new JSlider(0, 10, 5);

		Hashtable<Integer, JLabel> labelsSlider2 = new Hashtable<>();
		labelsSlider2.put(0, new JLabel("LOOKS"));
		labelsSlider2.put(10, new JLabel("DANCING SKILLS"));
		slider2.setLabelTable(labelsSlider2);

		slider2.setMajorTickSpacing(1);
		slider2.setPaintTicks(true);
		slider2.setSnapToTicks(true);
		slider2.setPaintTrack(true);
		slider2.setPaintLabels(true);

		// listening slider2 to get the tradeOff value

		slider2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				tradeOff = slider2.getValue();
			}
		});

		panelSlider.add(slider2);

		panelHost.add(panelSlider);

		// panelButton is for the two JButton components
		JPanel panelButton = new JPanel();
		JButton button1 = new JButton("High Scores");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HighScores.showScores();
			}
		});
		JButton button2 = new JButton("START");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MyGameFrame();
			}
		});
		JButton button3 = new JButton("Exit");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panelButton.add(button1);
		panelButton.add(button2);
		panelButton.add(button3);
		FlowLayout layoutButton = new FlowLayout();
		panelButton.setLayout(layoutButton);
		panelHost.add(panelButton);

		// labelBottom is added into the host panel
		JLabel labelBottom = new JLabel("Dance your way to the TOP!");
		panelHost.add(labelBottom);

		// panelHost and frame settings
		frame.setTitle("Dance With Stars£¡");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panelHost);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);

	}

}
