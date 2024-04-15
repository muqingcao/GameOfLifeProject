public class Generation {

    // old game board
    private Cell[][] oldGird;
    private int size;

    private Cell[][] newGird;
    private GameBoard nextGird;


    // new game board
    public Generation(GameBoard board){
        this.size = board.getSize();
        this.oldGird = board.getGrid();
        newGird = new Cell[board.getSize()][board.getSize()];


    }

    public void newGeneration(){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){

                // step one: find the number of neighbours
                // column(k): i - 1 & i+1; row(h): j - 1 & j+1
                int neighbours = 0;
                for(int k = -1 ; k < 2; k++){
                    for(int h = -1 ; h < 2; h++) {
                        if((i+k >= 0 && i+k < size) && (j + h >= 0 && j+h < size)){
                            if(oldGird[i+k][j+h].isAlive() == true){
                                neighbours += 1;
                            }
                        }

                    }
                }
                if(oldGird[i][j].isAlive()){
                    neighbours -=1;
                }

                // set new Board
                Cell temp = new Cell(nextGird, i,j);
                temp.setAlive(oldGird[i][j].isAlive());
                newGird[i][j] = temp;

                // situation 1: if the cell will die in the next generation (more than 3 neighbours  or less than 2 neighbours)
                if((neighbours > 3 || neighbours < 2 ) && oldGird[i][j].isAlive() == true){
                    newGird[i][j].switchState();

                }


                // situation 3: a new cell born in an empty cell that has exactly 3 neighbours
                else if(neighbours == 3 && oldGird[i][j].isAlive() == false){
                    newGird[i][j].switchState();
                    //System.out.println("i" + i + "\t,"+ "j: "+j);


                }

            }
        }

    }
    public GameBoard getNewBoard(){
        nextGird = new GameBoard(this.newGird);
        return nextGird;
    }

    public int getSize(){
        return size;
    }

    public Cell[][] getNewGird() {
        return newGird;
    }
}
