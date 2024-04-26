package view;

import Interface.GameObserver;
import model.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * GamePanel class represents the panel where the Game of Life is displayed.
 * It also handles mouse events to allow users to interact with the game board.
 */
public class GamePanel extends JPanel implements GameObserver {
    private GameBoard gameBoard;
    private int cellSize;

    /**
     * Constructs a new GamePanel with default settings and a new GameBoard.
     */
    public GamePanel() {
        // build a gameBoard with fault size 50
        this.gameBoard = new GameBoard();
        // window size
        this.setPreferredSize(new Dimension(800, 800));
        this.cellSize = 800 / gameBoard.getSize();

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleSingleClick(e);
            }
        });
    }

    /**
     * Overrides the {@code paintComponent} method from the {@code JPanel} class
     * to customize the rendering of the game board.
     *
     * @param g the {@code Graphics} object used for rendering
     */
    @Override
    public void paintComponent(Graphics g) {
        // clean the board for new paint
        super.paintComponent(g);
        // calculate the size of a cell
        for (int i = 0; i < gameBoard.getSize(); i++) {
            for (int j = 0; j < gameBoard.getSize(); j++) {
                if (gameBoard.getGrid()[i][j].isAlive()) g.setColor(Color.BLACK);
                else g.setColor(Color.WHITE);
                g.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
                g.setColor(Color.GRAY);
                g.drawRect(i * cellSize, j * cellSize, cellSize, cellSize);
            }
        }
    }

    /**
     * Handles a single mouse click event to toggle cell state.
     *
     * @param e the MouseEvent object
     */
    private void handleSingleClick(MouseEvent e) {
        int x = e.getX() / cellSize;
        int y = e.getY() / cellSize;

        if (isValidCoordinate(x, y)) {
            gameBoard.getGrid()[x][y].setAlive(true);
            repaint();
        }
    }

    /**
     * Checks if the given coordinates are valid for the game board.
     *
     * @param x the x-coordinate
     * @param y the y-coordinate
     * @return true if the coordinates are valid, false otherwise
     */
    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < gameBoard.getGrid().length && y >= 0 && y < gameBoard.getGrid()[0].length;
    }

    /**
     * Updates the game board displayed on the panel.
     *
     * @param gameBoard the new game board state
     */
    @Override
    public void update(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        repaint();
    }

    /**
     * Retrieves the current game board.
     *
     * @return the current game board
     */
    public GameBoard getGameBoard() {
        return gameBoard;
    }

    /**
     * Sets a new game board to be displayed on the panel.
     *
     * @param gameBoard the new game board
     */
    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }


}
