/**
 * The {@code GamePanelTest} class contains unit tests for the {@code GamePanel} class.
 * It tests the initialization, update method, and mouse click functionality of the {@code GamePanel} class.
 */
package view;

import model.*;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.awt.event.MouseEvent;

import static org.junit.Assert.*;

public class GamePanelTest {
    private GamePanel gamePanel;

    @Before
    public void setUp() {
        gamePanel = new GamePanel();
    }

    /**
     * Tests the initialization of the {@code GamePanel} class.
     */
    @Test
    public void testInitialization() {
        assertNotNull(gamePanel);
        assertNotNull(gamePanel.getGameBoard());
        assertEquals(50, gamePanel.getGameBoard().getSize()); // Default board size should be 10
        assertEquals(800, gamePanel.getPreferredSize().width);
        assertEquals(800, gamePanel.getPreferredSize().height);
    }

    /**
     * Tests the update method of the {@code GamePanel} class.
     */
    @Test
    public void testUpdate() {
        GameBoard updatedBoard = new GameBoard(15); // Create a new board with size 15
        gamePanel.update(updatedBoard);
        assertEquals(updatedBoard, gamePanel.getGameBoard());
    }

    /**
     * Tests the mouse click functionality of the {@code GamePanel} class.
     */
    @Test
    public void testMouseClick() {
        Point clickPoint = new Point(50, 50); // Click at coordinates (50,50)
        gamePanel.getMouseListeners()[0].mouseClicked(new MouseEvent(
                gamePanel, MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(),
                0, clickPoint.x, clickPoint.y, 1, false));

        int cellSize = 800 / gamePanel.getGameBoard().getSize();
        int clickedCellX = clickPoint.x / cellSize;
        int clickedCellY = clickPoint.y / cellSize;
        assertTrue(gamePanel.getGameBoard().getGrid()[clickedCellX][clickedCellY].isAlive());
    }

}