import model.GameBoard;
import model.GameLogic;
import view.GameFrame;

import javax.swing.*;

/**
 * The {@code Main} class is the entry point for the Game of Life application.
 * It initializes the game board, game logic, and the main application window.
 */
public class Main {

    /**
     * The main method of the application.
     * Initializes the game board, game logic, and the main application window on the Event Dispatch Thread (EDT).
     *
     * @param args the command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        // Schedule the GUI code to be executed on the EDT
        SwingUtilities.invokeLater(() -> {
            GameBoard board = new GameBoard();
            GameLogic gameLogic = new GameLogic(board);
            GameFrame gameFrame = new GameFrame();
        });
    }
}
