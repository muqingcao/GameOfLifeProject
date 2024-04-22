package view;
import javax.swing.*;
import java.awt.*;

import control.ControlPanel;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    private ControlPanel controlPanel;

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

    public GamePanel getGamePanel() {
        return this.gamePanel;
    }

    public ControlPanel getControlPanel() {
        return this.controlPanel;
    }
}