import model.GameBoard;
import model.GameLogic;
import view.GameFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameBoard board = new GameBoard();
            GameLogic gameLogic = new GameLogic(board);
            GameFrame gameFrame = new GameFrame(board, gameLogic);
        });



        /*
        System.out.print("---game one ---\n");
        GameBoard board = new GameBoard(8);
        GameLogic game = new GameLogic(board);

        game.addCell(1, 1);
        game.addCell(1, 2);
        game.addCell(1, 3);
        System.out.print(game.getBoard().toString());
        System.out.print("------\n");
        game.getNextBoard();
        System.out.print(game.getNewBoard().toString());

        System.out.print("---game two ---\n\n");

        GameBoard board1 = new GameBoard(8);
        GameLogic game1 = new GameLogic(board1);

        game1.addCell(1, 1);
        game1.addCell(1, 2);
        game1.addCell(1, 3);
        game1.addCell(1, 4);
        System.out.print(game1.getBoard().toString());
        System.out.print("------\n");
        game1.getNextBoard();
        System.out.print(game1.getNewBoard().toString());
        // print every generation
        game1.newBoardContinue();
        */
    }
}
