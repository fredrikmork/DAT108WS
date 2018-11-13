
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.LineMetrics;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.*;

public class Plot {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Plot");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		String className = UIManager.getSystemLookAndFeelClassName();
		try {
			try {
				UIManager.setLookAndFeel(className);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (UnsupportedLookAndFeelException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JPanel commandPanel = new JPanel(new FlowLayout());
		JButton openButton = new JButton("Open  Ctrl-O");
		JButton plotButton = new JButton("Plot  Ctrl-P");
		JButton quitButton = new JButton("Quit  Ctrl-Q");
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		commandPanel.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		}, KeyStroke.getKeyStroke("control Q"), JComponent.WHEN_IN_FOCUSED_WINDOW);
		commandPanel.add(openButton);
		commandPanel.add(plotButton);
		commandPanel.add(quitButton);
		frame.getContentPane().add(commandPanel, "North");

		GraphPanel graphpanel = new GraphPanel(frame);
		plotButton.addActionListener(graphpanel);
		commandPanel.registerKeyboardAction(graphpanel, KeyStroke.getKeyStroke("control P"),
				JComponent.WHEN_IN_FOCUSED_WINDOW);

		openButton.addActionListener(graphpanel.getDataPanel());
		commandPanel.registerKeyboardAction(graphpanel.getDataPanel(), KeyStroke.getKeyStroke("control O"),
				JComponent.WHEN_IN_FOCUSED_WINDOW);

		frame.setVisible(true);
		frame.pack();
	}
}

class GraphPanel implements ActionListener {
	private DataPanel datapanel;
	private JFrame frame;
	private GraphicPanel panel;

	GraphPanel(JFrame newFrame) {
		frame = newFrame;
		panel = new GraphicPanel();
		panel.setDisplayPlot(false);
		datapanel = new DataPanel(frame);
		panel.setDataPanel(datapanel);
		frame.getContentPane().add(panel, "Center");
	}

	public void actionPerformed(ActionEvent e) {
		if (!datapanel.isInitialized()) {
			return;
		}
		datapanel.refreshData();
		panel.setDisplayPlot(true);
		panel.update(panel.getGraphics());
		frame.setSize(800, 1500);
		frame.setVisible(true);
		frame.pack();
	}

	ActionListener getDataPanel() {
		return datapanel;
	}
}
