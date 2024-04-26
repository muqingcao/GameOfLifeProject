package control;

import model.GameBoard;
import model.GameLogic;
import model.GameLoop;
import view.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * ControlPanel class represents the control panel for the Game of Life application.
 * It provides user interface components to interact with the game, such as resizing the grid,
 * starting, stopping, resuming, and resetting the game.
 */
public class ControlPanel extends JPanel {
    private GamePanel gamePanel;
    private GameLogic gameLogic;
    private GameLoop gameLoop;

    private JLabel boardSizeLabel;
    private JTextField boarsSizeField;
    private JButton resizeButton;
    private JButton startButton;
    private JButton stopButton;
    private JButton resumeButton;
    private JButton resetButton;

    /**
     * Constructs a new ControlPanel with the specified GamePanel.
     *
     * @param gamePanel the GamePanel to associate with this ControlPanel
     */
    public ControlPanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        this.boardSizeLabel = new JLabel("Enter board size:");
        this.boarsSizeField = new JTextField(3);
        this.resizeButton = new JButton("Resize");
        this.startButton = new JButton("Start");
        this.stopButton = new JButton("Stop");
        this.resumeButton = new JButton("Resume");
        this.resetButton = new JButton("Reset");

        JPanel panel = new JPanel(new FlowLayout());
        panel.add(boardSizeLabel);
        panel.add(boarsSizeField);
        panel.add(resizeButton);
        panel.add(startButton);
        panel.add(stopButton);
        panel.add(resumeButton);
        panel.add(resetButton);
        add(panel);

        resizeButton.addActionListener(e -> resizeGrid());
        startButton.addActionListener(e -> startGame());
        stopButton.addActionListener(e -> stopGame());
        resumeButton.addActionListener(e -> resumeGame());
        resetButton.addActionListener(e -> resetGame());
    }

    public JTextField getBoarsSizeField() {
        return boarsSizeField;
    }

    public GameLoop getGameLoop() {
        return gameLoop;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * Resizes the game grid based on the input from the user.
     * If the input is empty, a default-sized board is created.
     * If the input is invalid, an error message is displayed.
     */
    public void resizeGrid() {
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

    /**
     * Starts the game by initializing the game logic and game loop.
     */
    public void startGame() {
        if (gameLoop != null && gameLoop.getIsStarted()) {
            return;
        }
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

    /**
     * Stops the game loop.
     */
    public void stopGame() {
        gameLoop.stopGame();
    }

    /**
     * Resumes the game if it's not already running.
     */
    public void resumeGame() {
        if (!gameLoop.getIsStarted()) {
            GameBoard board = this.gamePanel.getGameBoard();
            this.gameLogic = new GameLogic(board);
            this.gameLoop = new GameLoop(gameLogic);

            this.gameLogic.addObserver(this.gamePanel);
            gameLoop.startGame();
        }
        else return;
    }

    /**
     * Resets the game by stopping the game loop and creating a new game board.
     */
    public void resetGame() {
        stopGame();
        GameBoard board = new GameBoard();
        this.gamePanel.setGameBoard(board);
        this.gamePanel.repaint();

        this.gameLogic = new GameLogic(board);
        this.gameLoop = new GameLoop(gameLogic);

        this.gameLogic.addObserver(this.gamePanel);
        this.gamePanel.setGameBoard(board);
    }
}

