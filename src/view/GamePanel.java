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
    public GamePanel() {
        // build a gameBoard with fault size 10
        this.gameBoard = new GameBoard();
        // window size
        this.setPreferredSize(new Dimension(600, 600));
        this.cellSize = 600 / gameBoard.getSize();
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / cellSize;
                int y = e.getY() / cellSize;
                gameBoard.getGrid()[x][y].setAlive(true);
                repaint();
            }
        });
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
