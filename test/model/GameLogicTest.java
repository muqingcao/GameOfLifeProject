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

    @Test
    public void testAddObserver() {
        TestGameObserver observer = new TestGameObserver();
        gameLogic.addObserver(observer);
        assertEquals(1, gameLogic.getObservers().size());
    }

    @Test
    public void testRemoveObserver() {
        TestGameObserver observer = new TestGameObserver();
        gameLogic.addObserver(observer);
        gameLogic.removeObserver(observer);
        assertEquals(0, gameLogic.getObservers().size());
    }

    @Test
    public void testNotifyObservers() {
        // Create TestGameObserver
        TestGameObserver observer = new TestGameObserver();

        // Add observer to GameLogic
        gameLogic.addObserver(observer);

        // Call notifyObservers method directly
        gameLogic.notifyObservers();

        // Verify observer was notified
        assertTrue(observer.isNotified());
    }

    @Test
    public void testAddCellByCoordinates() {
        gameLogic.addCell(2, 3);
        assertTrue(gameLogic.getBoard().getGrid()[2][3].isAlive());
    }

    @Test
    public void testAddCellByObject() {
        Cell cell = new Cell(board, 2, 3);
        gameLogic.addCell(cell);
        assertTrue(gameLogic.getBoard().getGrid()[2][3].isAlive());
    }

    @Test
    public void testGetNextBoard() {
        // Assuming the logic for Generation is implemented
        gameLogic.getNextBoard();
        assertNotNull(gameLogic.getNewBoard());
    }

    @Test
    public void testSetBoard() {
        GameBoard newBoard = new GameBoard(10);
        gameLogic.setBoard(newBoard);
        assertEquals(newBoard, gameLogic.getBoard());
    }

    @Test
    public void testResetBoard() {
        gameLogic.addCell(2, 3);
        gameLogic.resetBoard();
        assertFalse(gameLogic.getBoard().getGrid()[2][3].isAlive());
    }

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
