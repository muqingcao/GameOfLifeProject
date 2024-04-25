package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerationTest {
    private Generation generation;
    private GameBoard board1;

    private Cell c1 = new Cell(board1,0,0);
    private Cell c2 =new Cell(board1,0,1);
    private Cell c3 =new Cell(board1,0,2);
    private Cell c4 = new Cell(board1,0,3);
    private Cell c5 = new Cell(board1,1,0);
    private Cell c6 = new Cell(board1,1,1);
    private Cell c7 = new Cell(board1,1,2);
    private Cell c8 = new Cell(board1,1,3);
    private Cell c9 = new Cell(board1,2,0);
    private Cell c10 = new Cell(board1,2,1);
    private Cell c11 = new Cell(board1,2,2);
    private Cell c12 = new Cell(board1,2,3);
    private Cell c13 = new Cell(board1,3,0);
    private Cell c14 =new Cell(board1,3,1);
    private Cell c15 = new Cell(board1,3,2);
    private Cell c16 = new Cell(board1,3,3);

    @Before
    public void setUp() {
        // Set up a GameBoard with a known initial state for testing
        c10.switchState();
        c11.switchState();
        c12.switchState();
        Cell[][] initialGrid = {
                {c1,c2,c3,c4},
                {c5,c6,c7,c8},
                {c9,c10,c11,c12},
                {c13,c14,c15,c16}
        };
        board1 = new GameBoard(initialGrid);

        // Create a Generation instance with the initial board
        generation = new Generation(board1);
    }

    // check if the method newGeneration() can simulate the correct pattern
    @Test
    public void testNewGeneration() {
        // Perform a new generation step
        generation.newGeneration();
        GameBoard newBoard = generation.getNewBoard();

        // Assert specific conditions after one generation
        String newBoardString = newBoard.toString();
        String expected = "0\t0\t0\t0\t\n" +
                "0\t0\t1\t0\t\n" +
                "0\t0\t1\t0\t\n" +
                "0\t0\t1\t0\t\n";
        assertEquals(newBoardString, expected);

    }

    // check if the method can get size correctly
    @Test
    public void testGetSize() {
        assertEquals(4, generation.getSize());
    }
}