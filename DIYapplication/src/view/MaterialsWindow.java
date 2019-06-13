/*
 * TCSS 360 - Spring 2019
 */

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import model.Materials;

/**
 * The materials window to be displayed when viewing materials from
 * NewEditProjectWindow.
 * 
 * @author Gordon McCreary
 * @version May 30, 2019
 */
public class MaterialsWindow {

	/* The NewEditProjectWindow JFrame this was called from. */
	private JFrame myHost;

	/* The materials. */
	private Materials myMaterials;

	/* The JFrame for this window. */
	private JFrame myFrame;

	/* The NewEditProjectWindow this was called from. */
	private NewEditProjectWindow myWindow;

	/**
	 * Material window constructor to display project materials.
	 * 
	 * @author Gordon McCreary
	 * @param theHost      The JFrame this is being called from.
	 * @param theMaterials The Materials.
	 * @param theWindow    The NewEditProjectWindow this was called from.
	 */
	public MaterialsWindow(final JFrame theHost, final Materials theMaterials, final NewEditProjectWindow theWindow) {
		if (theMaterials.getMaterialMap().size() < 1) {
			theHost.setEnabled(true);
			JOptionPane.showMessageDialog(null, "There are no materials to view!", "No Materials",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			myHost = theHost;
			myHost.setEnabled(false);
			myMaterials = theMaterials;
			myWindow = theWindow;
			JPanel panel = new JPanel();
			buildPanel(panel);

			// Finish up and show frame.
			myFrame = new JFrame("Manage Materials");
			myFrame.add(panel);
			myFrame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(final WindowEvent theEvent) {
					myHost.setEnabled(true);
				}
			});
			showFrame(myFrame);
		}
	}

	/**
	 * Builds the panel by adding all the labels, fields, buttons, etc.
	 * 
	 * @author Gordon McCreary
	 * @param thePanel The panel to add the components to.
	 */
	private void buildPanel(final JPanel thePanel) {
		thePanel.setLayout(new BoxLayout(thePanel, BoxLayout.Y_AXIS));
		for (String name : myMaterials.getMaterialMap().keySet()) {
			thePanel.add(new Mat(name, myMaterials.getMaterialMap().get(name)));
		}
	}

	/**
	 * Shows the frame.
	 * 
	 * @author Gordon McCreary
	 * @param theFrame The frame to be shown.
	 */
	private void showFrame(final JFrame theFrame) {
		theFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		theFrame.pack();
		theFrame.setLocationRelativeTo(null);
		theFrame.setResizable(false);
		theFrame.setVisible(true);
	}

	/**
	 * Mat class extends JPanel to display a material.
	 * 
	 * @author Gordon McCreary
	 * @version May 30, 2019
	 */
	class Mat extends JPanel {

		/* Default. */
		private static final long serialVersionUID = 1L;

		/**
		 * Mat constructor.
		 * 
		 * @author Gordon McCreary
		 * @param theName The name of the project.
		 * @param theCost The cost of the project.
		 */
		public Mat(final String theName, final double theCost) {
			super(new BorderLayout());
			JPanel tempPanel = new JPanel(new BorderLayout());
			tempPanel.add(new JLabel(theName), BorderLayout.WEST);
			tempPanel.add(new JLabel(String.format("$%.2f", theCost)), BorderLayout.EAST);
			tempPanel.setPreferredSize(new Dimension(250, 50));
			this.add(tempPanel, BorderLayout.WEST);
			JButton delete = new JButton("X");
			delete.setBackground(new Color(226, 61, 61));
			delete.addActionListener(theEvent -> {
				myMaterials.deleteMaterial(theName);
				myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
				new MaterialsWindow(myHost, myMaterials, myWindow);
				myWindow.updateMatLabel();
			});
			this.add(delete, BorderLayout.EAST);
			this.setPreferredSize(new Dimension(300, 25));
			this.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		}
	}
}