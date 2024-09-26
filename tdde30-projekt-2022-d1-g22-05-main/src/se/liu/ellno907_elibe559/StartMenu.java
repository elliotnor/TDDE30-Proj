package se.liu.ellno907_elibe559;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

/**
 * A class that handles the structure and usability of the start menu.
 */

public class StartMenu implements Runnable {
    public void run(){
	final JFrame startWindow = new JFrame("Chess XD - Starting menu");

	startWindow.setLocation(300,100);
	startWindow.setResizable(false);
	startWindow.setSize(260,240);

	Box components = Box.createVerticalBox();
	final JPanel titlePanel = new JPanel();
	final JLabel titleLabel = new JLabel("***Welcome to Chess XD!***");
	components.add(titlePanel);
	titlePanel.add(titleLabel);
	startWindow.add(components);

	/**Overall player selects**/
	//Black player select
	final JPanel blackPanel = new JPanel();
	components.add(blackPanel, BorderLayout.EAST);
	final JLabel blackPiece = new JLabel();
	URL blkPath = ClassLoader.getSystemResource("images/bp.png");
	if (blkPath != null){
	    blackPiece.setIcon(new ImageIcon(blkPath));
	    blackPanel.add(blackPiece);
	}

	//White player select
	final JPanel whitePanel = new JPanel();
	components.add(whitePanel);
	final JLabel whitePiece = new JLabel();
	URL whitePath = ClassLoader.getSystemResource("images/wp.png");
	if (whitePath != null){
	    whitePiece.setIcon(new ImageIcon(whitePath));
	    whitePanel.add(whitePiece);
	}

	final JTextField blackInput = new JTextField("Black", 10);
	blackPanel.add(blackInput);
	final JTextField whiteInput = new JTextField("White", 10);
	whitePanel.add(whiteInput);

	//Misc and buttons
	Box buttons = Box.createHorizontalBox();
	final JButton quitButton = new JButton("Quit game");

	quitButton.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent event){
		System.out.println("The game has ended!");
		startWindow.dispose();
	    }
	});

	final JButton startButton = new JButton("Start game");
	startButton.addActionListener(new ActionListener(){
	    public void actionPerformed(ActionEvent event){
		String blackName = blackInput.getText();
		String whiteName = whiteInput.getText();
		new GameWindow(blackName, whiteName);
		System.out.println("The game has started!");
		startWindow.dispose();
	    }
	});

	buttons.add(startButton);
	buttons.add(Box.createHorizontalStrut(10));
	buttons.add(quitButton);
	buttons.add(Box.createHorizontalStrut(10));
	components.add(buttons);

	startWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	startWindow.setVisible(true);
    }
}

