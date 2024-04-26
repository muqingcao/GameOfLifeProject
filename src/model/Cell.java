package model;

/**
 * Cell class represents a single cell in the Game of Life grid.
 * Each cell has a position, alive state, and a reference to the game board it belongs to.
 */
public class Cell {
    // the position in a game board
    private int x, y;

    // if the cell is alive
    private boolean alive;

    // reference of the game board
    private GameBoard gameBoard;

    /**
     * Constructs a Cell object with the specified game board and position.
     *
     * @param gameBoard the game board the cell belongs to
     * @param x         the x-coordinate of the cell
     * @param y         the y-coordinate of the cell
     */
    public Cell(GameBoard gameBoard, int x, int y) {
        this.gameBoard = gameBoard;
        this.x = x;
        this.y = y;
        this.alive = false;
    }

    /**
     * Gets the x-coordinate of the cell.
     *
     * @return the x-coordinate
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the y-coordinate of the cell.
     *
     * @return the y-coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Checks if the cell is alive.
     *
     * @return true if the cell is alive, false otherwise
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * Toggles the alive state of the cell.
     */
    public void switchState() {
        if (this.alive) this.alive = false;
        else this.alive = true;
    }

    /**
     * Sets the alive state of the cell.
     *
     * @param alive the alive state to set
     */
    public void setAlive(boolean alive){
        this.alive = alive;
    }

    /**
     * Returns a string representation of the cell.
     * Alive cell is represented as "1", and dead cell is represented as "0".
     *
     * @return string representation of the cell
     */
    public String toString(){
        if(alive == true){
            return "1";
        }else{
            return "0";
        }
    }
}
