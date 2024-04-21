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
            if (!isPaused) {
                gameLogic.getNextBoard();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
