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

    public boolean getIsStarted () {
        return this.isStarted;
    }
    public boolean getIsPaused () {
        return this.isPaused;
    }

    public void startGame() {
        if (!isStarted) {
            isStarted = true;
            isPaused = false;
            // starts the execution of the thread's run() method asynchronously
            start();
        }
        else return;
    }

    public void stopGame() {
        //isStarted = false;
        if (isStarted) {
            isStarted = false;
        }
        else return;
    }

    public void resumeGame() {
        if (!isStarted) {
            isStarted = true;
            isPaused = false;
        }
        else return;
    }

    @Override
    public void run() {
        while (isStarted && !Thread.currentThread().isInterrupted()) {
            gameLogic.getNextBoard();
            gameLogic.notifyObservers();

            // Check if all cells are either alive or dead
            if (allCellsAreSame(gameLogic.getNewBoard())
                    || boardsAreSame(gameLogic.getNewBoard(), gameLogic.getBoard())) {
                stopGame();
                interrupt();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // Restore interrupted status
                Thread.currentThread().interrupt();
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

