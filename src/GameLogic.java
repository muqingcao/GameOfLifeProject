public class GameLogic {
    private GameBoard board;
    private GameBoard newboard;

    public GameLogic(GameBoard board){
        // initial game: all cells are die
        this.board = board;
    }

    public void addCell(int x, int y){
        // user click cell and change the cell status
        this.board.cellChangeState(x,y);
    }

    public void getNewBoard(){
        Generation nextGen = new Generation(board);
        nextGen.newGeneration();
        newboard  = nextGen.getNewBoard();
    }

    public GameBoard getNewboard(){
        return newboard;
    }

    public GameBoard getBoard(){
        return board;
    }



}
