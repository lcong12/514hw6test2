package edu.cmu.cs.cs214.hw4.gui;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Main class to run the game.
 */
public class MockMain {
    /**
     * Called when start game.
     * @param args empty
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(new StartGamePanel(frame));

        frame.pack();
        frame.setVisible(true);
    }
}
