/**
 * The {@code CellTest} class contains unit tests for the {@code Cell} class.
 * It tests the various functionalities of the {@code Cell} class, such as getting coordinates,
 * checking the initial state, switching the state, setting the state, and converting to string.
 */
package model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CellTest {

    private GameBoard gameBoard;
    private Cell cell;

    @BeforeEach
    public void setUp() {
        gameBoard = new GameBoard(5); // Assuming GameBoard constructor takes width and height
        cell = new Cell(gameBoard, 2, 3);
    }

    /**
     * Tests the {@code getX} method of the {@code Cell} class.
     */
    @Test
    public void testGetX() {
        assertEquals(2, cell.getX());
    }

    /**
     * Tests the {@code getY} method of the {@code Cell} class.
     */
    @Test
    public void testGetY() {
        assertEquals(3, cell.getY());
    }

    /**
     * Tests the initial state of the cell using the {@code isAlive} method.
     */
    @Test
    public void testIsAliveInitiallyFalse() {
        assertFalse(cell.isAlive());
    }

    /**
     * Tests switching the state of the cell from false to true using the {@code switchState} method.
     */
    @Test
    public void testSwitchStateFromFalseToTrue() {
        cell.switchState();
        assertTrue(cell.isAlive());
    }

    /**
     * Tests switching the state of the cell from true to false using the {@code switchState} method.
     */
    @Test
    public void testSwitchStateFromTrueToFalse() {
        cell.setAlive(true);
        cell.switchState();
        assertFalse(cell.isAlive());
    }

    /**
     * Tests setting the state of the cell to true using the {@code setAlive} method.
     */
    @Test
    public void testSetAliveTrue() {
        cell.setAlive(true);
        assertTrue(cell.isAlive());
    }

    /**
     * Tests setting the state of the cell to false using the {@code setAlive} method.
     */
    @Test
    public void testSetAliveFalse() {
        cell.setAlive(false);
        assertFalse(cell.isAlive());
    }

    /**
     * Tests converting the alive state of the cell to a string representation using the {@code toString} method.
     */
    @Test
    public void testToStringAlive() {
        cell.setAlive(true);
        assertEquals("1", cell.toString());
    }

    /**
     * Tests converting the dead state of the cell to a string representation using the {@code toString} method.
     */
    @Test
    public void testToStringDead() {
        cell.setAlive(false);
        assertEquals("0", cell.toString());
    }
}
