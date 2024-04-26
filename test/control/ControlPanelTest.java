/**
 * ControlPanelTest class is responsible for testing the ControlPanel functionality.
 * It contains test cases to validate the behavior of the ControlPanel methods.
 *
 */
package control;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import view.GamePanel;

import static org.junit.jupiter.api.Assertions.*;

public class ControlPanelTest {

    private ControlPanel controlPanel;
    private GamePanel gamePanel;

    /**
     * Sets up the initial state for each test case.
     * Creates a new GamePanel and a new ControlPanel with the GamePanel.
     */
    @BeforeEach
    public void setUp() {
        gamePanel = new GamePanel();
        controlPanel = new ControlPanel(gamePanel);
    }

    /**
     * Tests the resizeGrid method with valid input.
     * Verifies that the game grid size is updated correctly.
     */
    @Test
    public void testResizeGridWithValidInput() {
        controlPanel.getBoarsSizeField().setText("10");
        controlPanel.resizeGrid();
        assertEquals(10, controlPanel.getGamePanel().getGameBoard().getSize());
    }

    /**
     * Tests the startGame method.
     * Verifies that the game loop is started correctly.
     */
    @Test
    public void testStartGame() {
        controlPanel.getBoarsSizeField().setText("5");
        controlPanel.resizeGrid();
        controlPanel.startGame();
        assertTrue(controlPanel.getGameLoop().getIsStarted());
    }

    /**
     * Tests the stopGame method.
     * Verifies that the game loop is stopped correctly.
     */
    @Test
    public void testStopGame() {
        controlPanel.startGame();
        controlPanel.stopGame();
        assertFalse(controlPanel.getGameLoop().getIsStarted());
    }

    /**
     * Tests the resumeGame method.
     * Verifies that the game loop is resumed correctly.
     */
    @Test
    public void testResumeGame() {
        controlPanel.startGame();
        controlPanel.stopGame();
        controlPanel.resumeGame();
        assertTrue(controlPanel.getGameLoop().getIsStarted());
    }

    /**
     * Tests the resetGame method.
     * Verifies that the game loop is stopped and the game board is reset correctly.
     */
    @Test
    public void testResetGame() {
        controlPanel.startGame();
        controlPanel.resetGame();
        assertFalse(controlPanel.getGameLoop().getIsStarted());
        assertEquals(50, controlPanel.getGamePanel().getGameBoard().getSize());
    }
}