package model;
import Interface.GameObserver;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private GameBoard board;
    private GameBoard newBoard;
    private GameBoard boardPrev;
    private GameBoard boardCurr;
    private List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (GameObserver observer : observers) {
            observer.update(newBoard);
        }
    }

    public GameLogic(GameBoard board){
        // initial game: all cells are die
        this.board = board;

    }

    // the method is designed for using location to change the cell status
    public void addCell(int x, int y){
        this.board.cellChangeState(x,y);
    }

    // the method is designed for using cell object to change the cell status
    public void addCell(Cell cell){
        this.board.cellChangeState(cell.getX(),cell.getY());
    }

    public void getNextBoard(){
        Generation nextGen = new Generation(board);
        nextGen.newGeneration();
        newBoard  = nextGen.getNewBoard();
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

    public GameBoard getNewBoard(){
        return newBoard;
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
