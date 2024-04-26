package model;

/**
 * GameLoop class manages the game loop for the Game of Life.
 * It controls the game's start, stop, pause, and resume functionality.
 */
public class GameLoop extends Thread {
    private GameLogic gameLogic;
    // let the game start/finish
    private volatile boolean isStarted;
    // let the game pause/resume
    private volatile boolean isPaused;

    /**
     * Constructs a GameLoop object with the given GameLogic instance.
     *
     * @param gameLogic the GameLogic instance to manage the game logic
     */
    public GameLoop(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    /**
     * Retrieves the status indicating whether the game loop is started.
     *
     * @return true if the game loop is started, otherwise false
     */
    public boolean getIsStarted () {
        return this.isStarted;
    }

    /**
     * Retrieves the status indicating whether the game loop is paused.
     *
     * @return true if the game loop is paused, otherwise false
     */
    public boolean getIsPaused () {
        return this.isPaused;
    }

    /**
     * Starts the game loop.
     */
    public void startGame() {
        if (!isStarted) {
            isStarted = true;
            isPaused = false;
            // starts the execution of the thread's run() method asynchronously
            start();
        }
        else return;
    }

    /**
     * Stops the game loop.
     */
    public void stopGame() {
        //isStarted = false;
        if (isStarted) {
            isStarted = false;
        }
        else return;
    }

    /**
     * Resumes the game loop.
     */
    public void resumeGame() {
        if (!isStarted) {
            isStarted = true;
            isPaused = false;
        }
        else return;
    }

    /**
     * Runs the game loop.
     */
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

    /**
     * Checks if all cells in the given board are the same state.
     *
     * @param board the game board to check
     * @return true if all cells are either alive or dead, otherwise false
     */
    public boolean allCellsAreSame(GameBoard board) {
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

    /**
     * Checks if two game boards have the same state for all cells.
     *
     * @param board1 the first game board
     * @param board2 the second game board
     * @return true if the boards have the same state for all cells, otherwise false
     */
    public boolean boardsAreSame(GameBoard board1, GameBoard board2) {
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

