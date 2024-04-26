/**
 * The {@code GameFrameTest} class contains unit tests for the {@code GameFrame} class.
 * It tests the initialization and getter methods of the {@code GameFrame} class.
 */
package view;

import model.GameBoard;
import model.GameLogic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GameFrameTest {

    private GameFrame gameFrame;

    @BeforeEach
    void setUp() {
        GameBoard gameBoard = new GameBoard();
        GameLogic gameLogic = new GameLogic(gameBoard);

        gameFrame = new GameFrame();
    }

    /**
     * Tests the initialization of the {@code GameFrame} class.
     */
    @Test
    void testGameFrameInitialization() {
        assertEquals("Game of Life", gameFrame.getTitle());
        assertEquals(JFrame.EXIT_ON_CLOSE, gameFrame.getDefaultCloseOperation());
        assertTrue(gameFrame.getLayout() instanceof BorderLayout);
        assertTrue(gameFrame.isVisible());
    }

    /**
     * Tests the getter methods of the {@code GameFrame} class.
     */
    @Test
    void testGetters() {
        assertNotNull(gameFrame.getGamePanel());
        assertNotNull(gameFrame.getControlPanel());
    }

}