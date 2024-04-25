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

    @Test
    public void testStartGame() {
        gameLoop.startGame();
        assertTrue(gameLoop.getIsStarted()); // Verify game is started
        assertFalse(gameLoop.getIsPaused()); // Verify game is not paused
    }

    @Test
    public void testStopGame() {
        gameLoop.startGame();
        gameLoop.stopGame();
        assertFalse(gameLoop.getIsStarted()); // Verify game is stopped
    }

    @Test
    public void testResumeGame() {
        gameLoop.startGame();
        gameLoop.stopGame();
        gameLoop.resumeGame();
        System.out.println(gameLoop.getIsStarted());
        assertTrue(gameLoop.getIsStarted()); // Verify game is resumed
    }


    @Test
    public void testGameLogicExecution() {
        gameLoop.startGame();

        // Wait for some time to ensure the game logic has executed
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verify that the board has been updated
        assertNotEquals(mockGameLogic.getBoard(), mockGameLogic.getNewBoard());
    }
}
