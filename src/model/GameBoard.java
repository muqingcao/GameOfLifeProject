package model;

public class GameBoard {
    // 2 dimensional array
    private Cell[][] grid;

    // the side length of the game board
    private int size;

    public GameBoard(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(this, i, j);
            }
        }
    }

    public int getSize() {
        return size;
    }
    public Cell[][] getGrid() {
        return grid;
    }
    public void update() {
        // call the function in model.GameLogic to update the gameBoard
    }
    public void reset() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.getGrid()[i][j].setStatus(false);
            }
        }
    }
}
