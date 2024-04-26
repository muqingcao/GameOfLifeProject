/**
 * The {@code GenerationTest} class contains unit tests for the {@code Generation} class.
 * It tests the various functionalities of the {@code Generation} class, including
 * generating a new game board based on the rules of the Game of Life and
 * retrieving the size of the game board.
 */
package model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenerationTest {
    private Generation generation;
    private GameBoard board1;

    // Cells representing the initial state of the game board
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

        generation = new Generation(board1);
    }

    /**
     * Tests the {@code newGeneration()} method to ensure it generates a new board
     * based on the Game of Life rules.
     */
    @Test
    public void testNewGeneration() {
        generation.newGeneration();
        GameBoard newBoard = generation.getNewBoard();

        String newBoardString = newBoard.toString();
        String expected = "0\t0\t0\t0\t\n" +
                "0\t0\t1\t0\t\n" +
                "0\t0\t1\t0\t\n" +
                "0\t0\t1\t0\t\n";
        assertEquals(newBoardString, expected);

    }

    /**
     * Tests the {@code getSize()} method to ensure it returns the correct size of the board.
     */
    @Test
    public void testGetSize() {
        assertEquals(4, generation.getSize());
    }
}