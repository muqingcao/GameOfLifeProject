package model;
import Interface.GameObserver;

import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private GameBoard board;
    private GameBoard newBoard;
    private List<GameObserver> observers = new ArrayList<>();

    public void addObserver(GameObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(GameObserver observer) {
        observers.remove(observer);
    }

    public List<GameObserver> getObservers() {
        return observers;
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

    public void setBoard(GameBoard newBoard){
        this.board = newBoard;
    }

    public GameBoard getNewBoard(){
        return newBoard;
    }

    public GameBoard getBoard(){
        return board;
    }

    public void resetBoard(){
        for(int i = 0; i < board.getSize(); i++){
            for(int j = 0; j < board.getSize(); j++){
                board.getGrid()[i][j].setAlive(false);
            }
        }
    }
}
