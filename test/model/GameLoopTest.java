/**
 * The {@code GameLoopTest} class contains unit tests for the {@code GameLoop} class.
 * It tests the various functionalities of the {@code GameLoop} class, including
 * starting and stopping the game loop, resuming the game loop, verifying the game's state,
 * checking if all cells are the same, and comparing game boards for equality.
 */
package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameLoopTest {

    private GameLoop gameLoop;
    private GameLogic mockGameLogic;

    @BeforeEach
    public void setUp() {
        mockGameLogic = new GameLogic(new GameBoard());
        gameLoop = new GameLoop(mockGameLogic);
    }

    /**
     * Tests starting the game loop.
     */
    @Test
    public void testStartGame() {
        gameLoop.startGame();
        assertTrue(gameLoop.getIsStarted());
        assertFalse(gameLoop.getIsPaused());
    }

    /**
     * Tests stopping the game loop.
     */
    @Test
    public void testStopGame() {
        gameLoop.startGame();
        gameLoop.stopGame();
        assertFalse(gameLoop.getIsStarted());
    }

    /**
     * Tests resuming the game loop.
     */
    @Test
    public void testResumeGame() {
        gameLoop.startGame();
        gameLoop.stopGame();
        gameLoop.resumeGame();
        System.out.println(gameLoop.getIsStarted());
        assertTrue(gameLoop.getIsStarted());
    }

    /**
     * Tests the run method of the game loop by stopping the game loop
     * when all cells in the board are the same.
     *
     * @throws InterruptedException if the thread is interrupted
     */
    @Test
    public void testRunMethod_StopGameWhenAllCellsAreSame() throws InterruptedException {
        for (int i = 0; i < mockGameLogic.getBoard().getSize(); i++) {
            for (int j = 0; j < mockGameLogic.getBoard().getSize(); j++) {
                mockGameLogic.getBoard().cellChangeState(i, j);
            }
        }

        gameLoop.start();
        Thread.sleep(2000);
        assertFalse(gameLoop.getIsStarted());
    }

    /**
     * Tests if all cells in the board are the same and all alive.
     */
    @Test
    public void testAllCellsAreSame_AllAlive() {
        GameBoard board = new GameBoard(2);
        board.cellChangeState(0, 0);

        assertFalse(gameLoop.allCellsAreSame(board));
    }

    /**
     * Tests if all cells in the board are the same and all dead.
     */
    @Test
    public void testAllCellsAreSame_AllDead() {
        GameBoard board = new GameBoard(2);

        assertTrue(gameLoop.allCellsAreSame(board));
    }

    /**
     * Tests if two game boards are identical.
     */
    @Test
    public void testBoardsAreSame_IdenticalBoards() {
        GameBoard board1 = new GameBoard(2);
        GameBoard board2 = new GameBoard(2);

        assertTrue(gameLoop.boardsAreSame(board1, board2));
    }

    /**
     * Tests if two game boards are different.
     */
    @Test
    public void testBoardsAreSame_DifferentBoards() {
        GameBoard board1 = new GameBoard(2);
        GameBoard board2 = new GameBoard(2);
        board2.cellChangeState(0, 0);

        assertFalse(gameLoop.boardsAreSame(board1, board2));
    }
}
