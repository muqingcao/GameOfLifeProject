package Interface;

import model.GameBoard;

/**
 * GameObserver interface provides a contract for classes that want to observe changes in a GameBoard.
 */
public interface GameObserver {

    /**
     * Updates the observer with the new state of the game board.
     *
     * @param gameBoard the updated GameBoard object
     */
    void update(GameBoard gameBoard);
}
