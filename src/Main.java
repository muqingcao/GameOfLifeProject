public class Main {
    public static void main(String[] args) {
       GameBoard board = new GameBoard(8);
        GameLogic game = new GameLogic(board);

        //Cell c1 = new Cell(board, 1,1);

        game.addCell(1,1);
        game.addCell(1,2);
        game.addCell(1,3);
        System.out.print(game.getBoard().toString());
        System.out.print("------\n");
        game.getNewBoard();
        System.out.print(game.getNewboard().toString())
    }
}
