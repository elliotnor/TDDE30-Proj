package se.liu.ellno907_elibe559;
import se.liu.jonkv82.annotations.BorrowedCode;

import javax.swing.*;
@BorrowedCode(source = "https://www.geeksforgeeks.org/runnable-interface-in-java/")
public class Game implements Runnable {
    public void run() {
	SwingUtilities.invokeLater((Runnable) new StartMenu());
    }

    public static void main(String[] args) {

	SwingUtilities.invokeLater(new Game());
    }
}

/**Left to do:
     * Projectplan
     * Checkmate
     * Fix graphics
     * Queen movement (getlinear och getdiagonal)
     */