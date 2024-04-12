public class GameBoard {
    // 2 dimensional array
    private Cell[][] grid;
    // the length size of the game board
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

}
