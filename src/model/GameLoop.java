package model;

public class GameLoop extends Thread {
    private GameLogic gameLogic;
    // let the game start/finish
    private volatile boolean isStarted;
    // let the game pause/resume
    private volatile boolean isPaused;
    public GameLoop(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }
    public void startGame() {
        isStarted = true;
        // starts the execution of the thread's run() method asynchronously
        start();
    }

    public void stopGame() {
        isStarted = false;
    }

    public void pauseGame() {
        isPaused = true;
    }

    public void resumeGame() {
        isPaused = false;
    }

    @Override
    public void run() {
        while (isStarted) {
            if(isPaused == true){
                return;
            }
            gameLogic.getNextBoard();
            gameLogic.notifyObservers();

            // Check if all cells are either alive or dead
            if (allCellsAreSame(gameLogic.getNewBoard())
                    || boardsAreSame(gameLogic.getNewBoard(), gameLogic.getBoard())) {
                stopGame();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameLogic.setBoard(gameLogic.getNewBoard());
        }

    }
    private boolean allCellsAreSame(GameBoard board) {
        boolean allAlive = true;
        boolean allDead = true;

        Cell[][] grid = board.getGrid();
        for (Cell[] row : grid) {
            for (Cell cell : row) {
                if (cell.isAlive()) {
                    allDead = false;
                } else {
                    allAlive = false;
                }
            }
        }
        return allAlive || allDead;
    }

    private boolean boardsAreSame(GameBoard board1, GameBoard board2) {
        Cell[][] grid1 = board1.getGrid();
        Cell[][] grid2 = board2.getGrid();

        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                if (grid1[i][j].isAlive() != grid2[i][j].isAlive()) {
                    return false;
                }
            }
        }
        return true;
    }

}

