/**
 * The {@code GameLogicTest} class contains unit tests for the {@code GameLogic} class.
 * It tests various functionalities of the {@code GameLogic} class, such as adding and removing observers,
 * notifying observers, adding cells by coordinates or object, getting the next board state,
 * setting the board state, and resetting the board state.
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import Interface.GameObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameLogicTest {

    private GameBoard board;
    private GameLogic gameLogic;

    @BeforeEach
    public void setUp() {
        board = new GameBoard();
        gameLogic = new GameLogic(board);
    }

    /**
     * Tests adding an observer to the {@code GameLogic} instance.
     */
    @Test
    public void testAddObserver() {
        TestGameObserver observer = new TestGameObserver();
        gameLogic.addObserver(observer);
        assertEquals(1, gameLogic.getObservers().size());
    }

    /**
     * Tests removing an observer from the {@code GameLogic} instance.
     */
    @Test
    public void testRemoveObserver() {
        TestGameObserver observer = new TestGameObserver();
        gameLogic.addObserver(observer);
        gameLogic.removeObserver(observer);
        assertEquals(0, gameLogic.getObservers().size());
    }

    /**
     * Tests notifying all observers of a change in the game board.
     */
    @Test
    public void testNotifyObservers() {
        TestGameObserver observer = new TestGameObserver();
        gameLogic.addObserver(observer);
        gameLogic.notifyObservers();
        assertTrue(observer.isNotified());
    }

    /**
     * Tests adding a cell to the game board by coordinates.
     */
    @Test
    public void testAddCellByCoordinates() {
        gameLogic.addCell(2, 3);
        assertTrue(gameLogic.getBoard().getGrid()[2][3].isAlive());
    }

    /**
     * Tests adding a cell to the game board by providing a cell object.
     */
    @Test
    public void testAddCellByObject() {
        Cell cell = new Cell(board, 2, 3);
        gameLogic.addCell(cell);
        assertTrue(gameLogic.getBoard().getGrid()[2][3].isAlive());
    }

    /**
     * Tests getting the next board state using the {@code getNextBoard} method.
     */
    @Test
    public void testGetNextBoard() {
        gameLogic.getNextBoard();
        assertNotNull(gameLogic.getNewBoard());
    }

    /**
     * Tests setting a new board state using the {@code setBoard} method.
     */
    @Test
    public void testSetBoard() {
        GameBoard newBoard = new GameBoard(10);
        gameLogic.setBoard(newBoard);
        assertEquals(newBoard, gameLogic.getBoard());
    }

    /**
     * Tests resetting the game board state using the {@code resetBoard} method.
     */
    @Test
    public void testResetBoard() {
        gameLogic.addCell(2, 3);
        gameLogic.resetBoard();
        assertFalse(gameLogic.getBoard().getGrid()[2][3].isAlive());
    }

    /**
     * A test observer implementation for testing the {@code GameLogic} class.
     */
    private static class TestGameObserver implements GameObserver {
        private boolean notified = false;

        @Override
        public void update(GameBoard gameBoard) {
            notified = true;
        }

        public boolean isNotified() {
            return notified;
        }
    }
}
