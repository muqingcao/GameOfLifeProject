package view;
import javax.swing.*;
import java.awt.*;

import control.ControlPanel;

/**
 * GameFrame class represents the main frame of the Game of Life application.
 * It contains a GamePanel for displaying the game board and a ControlPanel for user controls.
 */
public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    private ControlPanel controlPanel;

    /**
     * Constructs a new GameFrame with a GamePanel and a ControlPanel.
     */
    public GameFrame() {
        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the layout manager
        setLayout(new BorderLayout());

        gamePanel = new GamePanel();
        this.add(gamePanel, BorderLayout.CENTER);

        controlPanel = new ControlPanel(this.gamePanel);
        this.add(controlPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Retrieves the GamePanel instance.
     *
     * @return the GamePanel instance
     */
    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    /**
     * Retrieves the ControlPanel instance.
     *
     * @return the ControlPanel instance
     */
    public ControlPanel getControlPanel() {
        return this.controlPanel;
    }
}