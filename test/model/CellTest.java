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

    @Test
    public void testGetX() {
        assertEquals(2, cell.getX());
    }

    @Test
    public void testGetY() {
        assertEquals(3, cell.getY());
    }

    @Test
    public void testIsAliveInitiallyFalse() {
        assertFalse(cell.isAlive());
    }

    @Test
    public void testSwitchStateFromFalseToTrue() {
        cell.switchState();
        assertTrue(cell.isAlive());
    }

    @Test
    public void testSwitchStateFromTrueToFalse() {
        cell.setAlive(true);
        cell.switchState();
        assertFalse(cell.isAlive());
    }

    @Test
    public void testSetAliveTrue() {
        cell.setAlive(true);
        assertTrue(cell.isAlive());
    }

    @Test
    public void testSetAliveFalse() {
        cell.setAlive(false);
        assertFalse(cell.isAlive());
    }

    @Test
    public void testToStringAlive() {
        cell.setAlive(true);
        assertEquals("1", cell.toString());
    }

    @Test
    public void testToStringDead() {
        cell.setAlive(false);
        assertEquals("0", cell.toString());
    }
}
