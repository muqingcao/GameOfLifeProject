package control;

import model.GameBoard;
import model.GameLogic;
import model.GameLoop;
import view.GameFrame;
import view.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.AWTEventMulticaster.add;

public class ControlPanel extends JPanel {
    private GamePanel gamePanel;
    private GameLogic gameLogic;
    private GameLoop gameLoop;

    private JLabel boardSizeLabel;
    private JTextField boarsSizeField;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JButton pauseButton;
    private JButton resumeButton;

    public ControlPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.boardSizeLabel = new JLabel("Enter board size:");
        this.boarsSizeField = new JTextField(3);
        this.startButton = new JButton("Start");
        this.stopButton = new JButton("Stop");
        this.resetButton = new JButton("Reset");
        this.pauseButton = new JButton("Pause");
        this.resumeButton = new JButton("Resume");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(boardSizeLabel);
        panel.add(boarsSizeField);
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(resetButton);
        panel.add(pauseButton);
        panel.add(resumeButton);
        add(panel);

        startButton.addActionListener(e -> startGame());
        stopButton.addActionListener(e -> stopGame());
        resetButton.addActionListener(e -> resetGame());
        pauseButton.addActionListener(e -> pauseGame());
        resumeButton.addActionListener(e -> resumeGame());
    }

    private void startGame() {
        int boardSize = Integer.parseInt(boarsSizeField.getText());
        GameBoard board = new GameBoard(boardSize);

        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (this.gamePanel.getGameBoard().getGrid()[i][j].isAlive()) {
                    board.getGrid()[i][j].setAlive(true);
                }
            }
        }
        this.gameLogic = new GameLogic(board);
        this.gameLoop = new GameLoop(gameLogic);
        gameLoop.startGame();
    }


    private void stopGame() {
        // todo: Stop the game
    }

    private void resetGame() {
        // todo: reset the game
    }

    private void pauseGame() {
        // todo: pause the game
    }


    private void resumeGame() {
        // todo: resume the game
    }
}

