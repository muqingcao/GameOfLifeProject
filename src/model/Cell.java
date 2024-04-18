package model;

public class Cell {
    // the position in a game board
    private int x, y;

    // the side length of a cell
    private int size;

    // if the cell is alive
    private boolean alive;

    // reference of the game board
    private GameBoard gameBoard;
    public Cell(GameBoard gameBoard, int x, int y) {
        this.gameBoard = gameBoard;
        this.x = x;
        this.y = y;
        this.alive = false;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getSize() {
        return size;
    }
    public boolean isAlive() {
        return alive;
    }
    public void setStatus(boolean status) {
        this.alive = status;
    }
    
    public void switchState() {
        if (this.alive) this.alive = false;
        else this.alive = true;
    }
    
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    
    public String toString(){
        if(alive == true){
            return "1";
        }else{
            return "0";
        }
    }
}