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

    // count the number of alive neighbors
    public int countNeighbors(GameBoard gameBoard) {
        int boardSideLength = gameBoard.getSize();
        int[][] calculateNeighbor
                = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int neighborX = this.x + calculateNeighbor[i][0];
            int neighborY = this.y + calculateNeighbor[i][1];
            if ((neighborX < boardSideLength && neighborX >= 0)
                    && (neighborY < boardSideLength && neighborY >= 0)
                    && (gameBoard.getGrid()[neighborX][neighborY]).isAlive()) count++;
        }
        return count;
    }
}
