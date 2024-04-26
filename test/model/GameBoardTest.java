/**
 * The {@code GameBoardTest} class contains unit tests for the {@code GameBoard} class.
 * It tests the various functionalities of the {@code GameBoard} class, such as constructors,
 * copying cells, changing cell states, and converting to string.
 */
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

    /**
     * Tests the default constructor of the {@code GameBoard} class.
     */
    @Test
    public void testDefaultConstructor() {
        assertEquals(50, gameBoard.getSize());
    }

    /**
     * Tests the parameterized constructor of the {@code GameBoard} class.
     */
    @Test
    public void testParameterizedConstructor() {
        GameBoard customGameBoard = new GameBoard(10);
        assertEquals(10, customGameBoard.getSize());
    }

    /**
     * Tests copying a cell's state to the game board using the {@code copyCell} method.
     */
    @Test
    public void testCopyCell() {
        Cell cell = new Cell(gameBoard, 2, 3);
        cell.setAlive(true);
        gameBoard.copyCell(cell);
        assertTrue(gameBoard.getGrid()[2][3].isAlive());
    }

    /**
     * Tests changing a cell's state on the game board using the {@code cellChangeState} method.
     */
    @Test
    public void testCellChangeState() {
        Cell cell = gameBoard.getGrid()[2][3];
        boolean initialState = cell.isAlive();
        gameBoard.cellChangeState(2, 3);
        assertNotEquals(initialState, gameBoard.getGrid()[2][3].isAlive());
    }

    /**
     * Tests converting the game board state to a string representation using the {@code toString} method.
     */
    @Test
    public void testToString() {
        GameBoard customGameBoard = new GameBoard(5);
        String expected = "0\t0\t0\t0\t0\t\n0\t0\t0\t0\t0\t\n0\t0\t0\t0\t0\t\n0\t0\t0\t0\t0\t\n0\t0\t0\t0\t0\t\n";
        String actual = customGameBoard.toString();
        assertEquals(expected, actual.substring(0, expected.length()));
    }
}
