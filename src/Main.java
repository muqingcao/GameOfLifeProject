public class Main {
    public static void main(String[] args) {
        System.out.print("---game one ---\n");
        GameBoard board = new GameBoard(8);
        GameLogic game = new GameLogic(board);

        Cell c1 = new Cell(board, 1,1);
        Cell c2 = new Cell(board, 1,2);
        Cell c3 = new Cell(board, 1,3);

        game.addCell(c1);
        game.addCell(c2);
        game.addCell(c3);
        System.out.print(game.getBoard().toString());
        System.out.print("------\n");
        game.getNextBoard();
        System.out.print(game.getNewBoard().toString());

        System.out.print("---game two ---\n\n");

        //Cell c1 = new Cell(board, 1,1);
        GameBoard board1 = new GameBoard(8);
        GameLogic game1 = new GameLogic(board1);

        Cell d1 = new Cell(board1, 1,1);
        Cell d2 = new Cell(board1, 1,2);
        Cell d3 = new Cell(board1, 1,3);
        Cell d4 = new Cell(board1, 1,4);

        game1.addCell(d1);
        game1.addCell(d2);
        game1.addCell(d3);
        game1.addCell(d4);
        System.out.print(game1.getBoard().toString());
        System.out.print("------\n");
        game1.newBoardContinue();
    }
}
