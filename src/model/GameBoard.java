package model;

/**
 * GameBoard class represents the game board for the Game of Life.
 * It contains a 2D array of Cell objects and provides methods to manipulate the board.
 */
public class GameBoard {
    // 2 dimensional array
    private Cell[][] grid;
    // the length size of the game board
    private int size = 50;

    /**
     * Default constructor that initializes a game board with a default size of 50x50.
     */
    public GameBoard() {
        grid = new Cell[this.size][this.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(this, i, j);
            }
        }
    }

    /**
     * Constructs a game board with the specified size.
     *
     * @param size the size of the game board
     */
    public GameBoard(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(this, i, j);
            }
        }
    }

    /**
     * Constructs a game board with the provided grid.
     *
     * @param newGrid the 2D array of cells to use for the game board
     */
    public GameBoard(Cell[][] newGrid){
        this.grid = newGrid;
        this.size = newGrid.length;
    }

    /**
     * Copies the state of the given cell to the corresponding position on the board.
     *
     * @param cell the cell to copy
     */
    public void copyCell(Cell cell){
        grid[cell.getX()][cell.getY()] = cell;
    }

    /**
     * Changes the state (alive or dead) of the cell at the specified position.
     *
     * @param x the x-coordinate of the cell
     * @param y the y-coordinate of the cell
     */
    public void cellChangeState(int x, int y){
        grid[x][y].switchState();
    }

    /**
     * Returns the size of the game board.
     *
     * @return the size of the game board
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the grid representing the game board.
     *
     * @return the 2D array of cells
     */
    public Cell[][] getGrid() {
        return grid;
    }

    /**
     * Returns a string representation of the game board.
     *
     * @return a string representation of the game board
     */
    public String toString(){
        StringBuilder stringGrid = new StringBuilder();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(grid[i][j].isAlive()){
                    stringGrid.append("1");
                }else{
                    stringGrid.append("0");
                }
                stringGrid.append("\t");
            }
            stringGrid.append("\n");
        }
        return stringGrid.toString();
    }
}
