package edu.cmu.cs.cs214.hw4.gui;

import edu.cmu.cs.cs214.hw4.core.GameSystemImp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

/**
 * A small start game window used to input how many players total.
 */
public class StartGamePanel extends JPanel {
    private JFrame parentFrame;
    private int playerNum;

    /**
     * Constructor of the start game pane.
     * @param frame frame contain the pane
     */
    public StartGamePanel(JFrame frame) {
        parentFrame = frame;

        JLabel label = new JLabel("Number of players:");

        final JTextField playerNumText = new JTextField(20);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton startGameButton = new JButton("Start Game");
        panel.add(label);
        panel.add(playerNumText);
        panel.add(startGameButton);

        ActionListener startGameListener = e -> {

            String number = playerNumText.getText().trim();
            try {
                int num = Integer.parseInt(number);
                if (num > 7 || num < 2) {
                    playerNumText.setText("Player number should between 2 and 7");
                    return;
                }
                startGame(num);
                System.out.println("new game started");
            } catch (NumberFormatException nfe) {
                playerNumText.setText("Please Input a integer number");
            }
        };

        startGameButton.addActionListener(startGameListener);
        playerNumText.addActionListener(startGameListener);
        setLayout(new FlowLayout());
        add(panel);
        setVisible(true);
    }

    private void startGame(int num) {
        parentFrame.dispose();
        parentFrame = null;

        GameSystemImp game = new GameSystemImp(num);

        JFrame frame = new JFrame("Carcassonne");
        GamePanel gamePanel = new GamePanel(game, num);

        frame.add(gamePanel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
    }
}
