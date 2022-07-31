package charactersObhects;


public class GameState {

    public enum STATE {
        CONTINUE,
        WIN,
        LOSE
    }
    private static STATE gameState;
    private static GameState instance;

    private GameState() {
        gameState = STATE.CONTINUE;
    }

    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public static STATE getState() {
        return gameState;
    }

    public static void setState(STATE newState) {
        gameState = newState;
    }

}
