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
    private JButton resizeButton;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;
    private JButton pauseButton;
    private JButton resumeButton;

    public ControlPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.boardSizeLabel = new JLabel("Enter board size:");
        this.boarsSizeField = new JTextField(3);
        this.resizeButton = new JButton("Resize");
        this.startButton = new JButton("Start");
        this.stopButton = new JButton("Stop");
        this.resetButton = new JButton("Reset");
        this.pauseButton = new JButton("Pause");
        this.resumeButton = new JButton("Resume");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(boardSizeLabel);
        panel.add(boarsSizeField);
        panel.add(resizeButton);
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(resetButton);
        panel.add(pauseButton);
        panel.add(resumeButton);
        add(panel);

        resizeButton.addActionListener(e -> resizeGrid());
        startButton.addActionListener(e -> startGame());
        stopButton.addActionListener(e -> stopGame());
        resetButton.addActionListener(e -> resetGame());
        pauseButton.addActionListener(e -> pauseGame());
        resumeButton.addActionListener(e -> resumeGame());
    }

    private void resizeGrid() {
        String input = boarsSizeField.getText();
        GameBoard board;
        if (input.isEmpty()) {
            board = new GameBoard();
        }
        else {
            int boardSize;
            try {
                boardSize = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            board = new GameBoard(boardSize);
        }
        this.gamePanel.setGameBoard(board);
        this.gamePanel.repaint();
    }
    private void startGame() {
        GameBoard board = new GameBoard(this.gamePanel.getGameBoard().getSize());
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (this.gamePanel.getGameBoard().getGrid()[i][j].isAlive()) {
                    board.getGrid()[i][j].setAlive(true);
                }
            }
        }
        this.gamePanel.setGameBoard(board);
        this.gamePanel.repaint();

        this.gameLogic = new GameLogic(board);
        this.gameLoop = new GameLoop(gameLogic);

        this.gameLogic.addObserver(this.gamePanel);
        this.gamePanel.setGameBoard(board);
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

