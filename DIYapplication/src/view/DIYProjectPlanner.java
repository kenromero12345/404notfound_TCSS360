package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;

/**
 * Main Application
 * @author
 * @author Ken Gil Romero
 * @version Spring 19
 */
public class DIYProjectPlanner extends JFrame {

    /**
     * A generated serial version UID for object Serialization.
     * http://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html
     */
	private static final long serialVersionUID = -131614090848525596L;
	
	private static final String VERSION = "0.0.1";
	    
    /**
     * The add button to add projects and its panel
     */
    public JButton myAddJButton;
    
    /**
     * The left panel where the projects are
     */
    public ProjectsScrollPane myJPanelLeft;
    
    /** The model for reference. */
	private Controller myController;
	
	/**
	 * JMenuItem for saving the projects
	 */
	public JMenuItem mySave;
	
	/**
	 * JMenuItem for opening a file
	 */
	public JMenuItem myOpen;
	
	/**
	 * The left component of the application where the project panels are
	 */
	public JScrollPane myProjectsScrollPane;

	public DIYProjectPlanner(final Controller theController) {
		super("DIY Project Planner");
		super.setIconImage((new ImageIcon("./Images/iconDIY.png")).getImage());
		myController = theController;
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500, 400));
		
		createAndShowGUI();
	}

	public void createAndShowGUI() {
		setUpComponents();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	/**
	 * Sets up the components of the GUI.
	 */
	private void setUpComponents() {
		setJMenuBar(createMenuBar());
		myProjectsScrollPane = new ProjectsScrollPane();
        add(myProjectsScrollPane, BorderLayout.WEST);
        
        //TODO: Description
        final JPanel jPanelRight = new JPanel();
        add(jPanelRight, BorderLayout.EAST);
	}
	
	public JMenuBar createMenuBar() {
		final JMenuBar bar = new JMenuBar();

		bar.add(createFileMenu());
		bar.add(createHelpMenu());

		return bar;
	}

	private JMenu createFileMenu() {
		final JMenu menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_F);

		final JMenuItem make = new JMenuItem("New...");
		make.addActionListener(theEvent -> myController.createNewProject());
		myOpen = new JMenuItem("Open...");
		mySave = new JMenuItem("Save...");
		final JMenuItem exit = new JMenuItem("Exit");
		exit.addActionListener(theEvent -> System.exit(0));

		menu.add(make);
		menu.add(myOpen);
		menu.add(mySave);
		menu.add(exit);

		return menu;
	}
	
	private JMenu createHelpMenu() {
		final JMenu menu = new JMenu("Help");
		menu.setMnemonic(KeyEvent.VK_H);

		final JMenuItem about = new JMenuItem("About...");
		about.addActionListener(theEvent -> showAboutDialog());
		menu.add(about);

		return menu;
	}

	private void showAboutDialog() {
		JOptionPane.showMessageDialog(null,
				String.format(
						"Created by:\nMatthew Chan\nZhe Li\nGordon McCreary\nKen Gil Romero\nTammy Vo\n\nVersion: %s",
						VERSION),
				"About", JOptionPane.INFORMATION_MESSAGE);
	}
}
