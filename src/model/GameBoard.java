package model;

public class GameBoard {
    // 2 dimensional array
    private Cell[][] grid;
    // the length size of the game board
    private int size = 10;

    public GameBoard() {
        grid = new Cell[this.size][this.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(this, i, j);
            }
        }
    }

    public GameBoard(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                grid[i][j] = new Cell(this, i, j);
            }
        }
    }

    public GameBoard(Cell[][] newGird){
        this.grid = newGird;
        this.size = newGird.length;
    }

    public void copyCell(Cell cell){
        grid[cell.getX()][cell.getY()] = cell;
    }

    public void cellChangeState(int x, int y){
        grid[x][y].switchState();
    }

    public int getSize() {
        return size;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void reset() {
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                this.getGrid()[i][j].setAlive(false);
            }
        }
    }

    public String toString(){
        StringBuilder stringGird = new StringBuilder();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(grid[i][j].isAlive()){
                    stringGird.append("1");
                }else{
                    stringGird.append("0");
                }
                stringGird.append("\t");
            }
            stringGird.append("\n");
        }
        return stringGird.toString();
    }

}
