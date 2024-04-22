package view;
import Interface.GameObserver;

import model.GameBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GamePanel extends JPanel implements GameObserver {
    private GameBoard gameBoard;
    private int cellSize;
    private boolean isMousePressed = false;

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

            @Override
            public void mousePressed(MouseEvent e) {
                isMousePressed = true;
                handleMouseClick(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                isMousePressed = false;
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                if (isMousePressed) {
                    handleMouseClick(e);
                }
            }
        });
    }

    private void handleSingleClick(MouseEvent e) {
        int x = e.getX() / cellSize;
        int y = e.getY() / cellSize;

        if (isValidCoordinate(x, y)) {
            gameBoard.getGrid()[x][y].setAlive(true);
            repaint();
        }
    }

    private void handleMouseClick(MouseEvent e) {
        int x = e.getX() / cellSize;
        int y = e.getY() / cellSize;

        if (isValidCoordinate(x, y)) {
            gameBoard.getGrid()[x][y].setAlive(true);
            repaint();
        }
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < gameBoard.getGrid().length && y >= 0 && y < gameBoard.getGrid()[0].length;
    }

    @Override
    public void update(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        repaint();
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    @Override
    // override the paintComponent function from Swing
    // utilize the abstract class Graphics to simplify the paint
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
}
