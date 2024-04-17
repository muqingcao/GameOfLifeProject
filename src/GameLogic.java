import java.util.Arrays;

public class GameLogic {
    private GameBoard board;
    private GameBoard newboard;

    private GameBoard boardPrev;
    private GameBoard boardCurr;



    public GameLogic(GameBoard board){
        // initial game: all cells are die
        this.board = board;
    }

    public void addCell(int x, int y){
        // user click cell and change the cell status
        this.board.cellChangeState(x,y);
    }

    public void getNextBoard(){
        Generation nextGen = new Generation(board);
        nextGen.newGeneration();
        newboard  = nextGen.getNewBoard();
    }

    public void newBoardContinue(){
        String prev = "null";
        String curr = this.board.toString();
        boardPrev = board;

        while(!prev.equals(curr)){
            Generation nextGen = new Generation(boardPrev);
            nextGen.newGeneration();
            boardCurr  = nextGen.getNewBoard();
            prev = curr;
            curr = this.boardCurr.toString();
            boardPrev = boardCurr;
        }

    }

    public GameBoard getNewboard(){
        return newboard;
    }

    public GameBoard getBoard(){
        return board;
    }

    public GameBoard getBoardCurr(){
        return boardCurr;
    }
    public GameBoard getBoardPrev(){
        return boardPrev;
    }


}
