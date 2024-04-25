package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameBoardTest {

    private GameBoard gameBoard;

    @BeforeEach
    public void setUp() {
        gameBoard = new GameBoard();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals(50, gameBoard.getSize());
    }

    @Test
    public void testParameterizedConstructor() {
        GameBoard customGameBoard = new GameBoard(10);
        assertEquals(10, customGameBoard.getSize());
    }

    @Test
    public void testCopyCell() {
        Cell cell = new Cell(gameBoard, 2, 3);
        cell.setAlive(true);
        gameBoard.copyCell(cell);
        assertTrue(gameBoard.getGrid()[2][3].isAlive());
    }

    @Test
    public void testCellChangeState() {
        Cell cell = gameBoard.getGrid()[2][3];
        boolean initialState = cell.isAlive();
        gameBoard.cellChangeState(2, 3);
        assertNotEquals(initialState, gameBoard.getGrid()[2][3].isAlive());
    }

    @Test
    public void testToString() {
        GameBoard customGameBoard = new GameBoard(5);
        String expected = "0\t0\t0\t0\t0\t\n0\t0\t0\t0\t0\t\n0\t0\t0\t0\t0\t\n0\t0\t0\t0\t0\t\n0\t0\t0\t0\t0\t\n";
        String actual = customGameBoard.toString();
        assertEquals(expected, actual.substring(0, expected.length()));
    }
}
