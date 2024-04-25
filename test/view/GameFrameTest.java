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
        // Mock or initialize dependencies (e.g., GameBoard, GameLogic)
        GameBoard gameBoard = new GameBoard();
        GameLogic gameLogic = new GameLogic(gameBoard);

        // Create a new GameFrame instance with mocked/initialized dependencies
        gameFrame = new GameFrame();
    }

    // test initialization method
    @Test
    void testGameFrameInitialization() {
        // Test that the title is correctly set
        assertEquals("Game of Life", gameFrame.getTitle());

        // Test that the default close operation is set to exit on close
        assertEquals(JFrame.EXIT_ON_CLOSE, gameFrame.getDefaultCloseOperation());

        // Test that the layout manager is set to BorderLayout
        assertTrue(gameFrame.getLayout() instanceof BorderLayout);

        // Test visibility of the frame
        assertTrue(gameFrame.isVisible());
    }

    // test get methods
    @Test
    void testGetters() {
        // Test the getGamePanel() method
        assertNotNull(gameFrame.getGamePanel());

        // Test the getControlPanel() method
        assertNotNull(gameFrame.getControlPanel());
    }

}