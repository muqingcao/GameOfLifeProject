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
    public void switchState() {
        if (this.alive) this.alive = false;
        else this.alive = true;
    }

    // count the number of alive neighbors
    public int countNeighbors() {
        int boardSize = gameBoard.getSize();
        int result = 0;
        //todo: different scenarios for 2/3/4 neighbors
        return result;
    }
}
