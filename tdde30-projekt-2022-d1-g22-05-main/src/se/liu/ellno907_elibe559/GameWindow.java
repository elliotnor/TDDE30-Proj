package se.liu.ellno907_elibe559;

import javax.swing.*;
import java.awt.*;
/**
 * A class that shows the game on the screen
 */
public class GameWindow {
    private JFrame gameWindow;
    private Board board;

    public GameWindow(String bName, String wName) {
	//Configure window properties
	gameWindow = new JFrame("Chess XD");
	gameWindow.setLocation(100, 100);
	gameWindow.setLayout(new BorderLayout(220, 20));
	gameWindow.setSize(gameWindow.getPreferredSize());
	gameWindow.setResizable(false);

	//Configure the board
	this.board = new Board(this);
	gameWindow.add(board,BorderLayout.CENTER); //Position the board in the middle, hence CENTER

	//Show the window
	gameWindow.pack();
	gameWindow.setVisible(true);
	gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}