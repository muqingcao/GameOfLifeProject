package view;

import model.GameBoard;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private GameBoard gameBoard;
    public GamePanel(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
        // todo: why set this size
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    // override the paintComponent function from Swing
    // utilize the abstract class Graphics to simplify the paint
    public void paintComponent(Graphics g) {
        // clean the board for new paint
        super.paintComponent(g);
        // calculate the size of a cell
        int cellSize = 600 / gameBoard.getSize();
        for (int i = 0; i < gameBoard.getSize(); i++) {
            for (int j = 0; j < gameBoard.getSize(); j++) {
                if (gameBoard.getGrid()[i][j].isAlive()) g.setColor(Color.BLACK);
                else g.setColor(Color.WHITE);
                // todo: set color
            }
        }
    }
}
