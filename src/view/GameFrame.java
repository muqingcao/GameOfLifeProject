package view;

import javax.swing.*;
import java.awt.*;
import model.*;

public class GameFrame extends JFrame {
    private GamePanel gamePanel;
    public GameFrame(GameBoard gameBoard, GameLogic gameLogic) {
        setTitle("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //sets the layout manager
        setLayout(new BorderLayout());
        gamePanel = new GamePanel(gameBoard);
        add(gamePanel, BorderLayout.CENTER);

    }
}
