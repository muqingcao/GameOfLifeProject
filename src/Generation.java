public class Generation {

    // old game board
    private Cell[][] oldGird;
    private int size;

    private Cell[][] nextGird;


    // new game board
    public Generation(GameBoard board){
        this.size = board.getSize();
        this.oldGird = board.getGrid();
    }

    public void NewGeneration(){
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
                neighbours -= 1;

                // situation 1: if the cell will die in the next generation (more than 3 neighbours  or less than 2 neighbours)
                if((neighbours > 3 || neighbours < 2 ) && oldGird[i][j].isAlive() == true){
                    oldGird[i][j].switchState();
                    nextGird[i][j] = oldGird[i][j];

                }


                // situation 3: a new cell born in an empty cell that has exactly 3 neighbours
                else if(neighbours == 3 && oldGird[i][j].isAlive() == false){
                    oldGird[i][j].switchState();
                    nextGird[i][j] = oldGird[i][j];

                }
                // situation 4: alive in the next situtaion
                else if((neighbours == 3 || neighbours == 2) && oldGird[i][j].isAlive() == true){
                    nextGird[i][j] = oldGird[i][j];
                }

                //  no change
                else{
                    nextGird[i][j] = oldGird[i][j];
                }

            }
        }

    }








}
