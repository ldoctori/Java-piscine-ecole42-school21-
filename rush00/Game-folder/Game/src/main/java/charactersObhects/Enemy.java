package charactersObhects;

import config.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy {

    private List<ArrayList<Character>> map;
    private Configuration config;
    private int size;
    private int x;
    private int y;
    private GameState gameState;

    public Enemy(List<ArrayList<Character>> map, Configuration config, int size, GameState gameState) {

        this.map = map;
        this.config = config;
        this.size = size;
        this.gameState = gameState;
        startPosition();
    }

    private void startPosition() {

        Random random = new Random();
        x = random.nextInt(size);
        y = random.nextInt(size);

        while (map.get(y).get(x) != config.getCharacters().getEmpty()) {
            x = random.nextInt(size);
            y = random.nextInt(size);
        }
        map.get(y).set(x, config.getCharacters().getEnemy());
    }

    public int getX()
    {
        return this.x;
    }
    public int getY()
    {
        return this.y;
    }
    public void moveEnemy(int[] coordinatesOfNextStep) {

        if (coordinatesOfNextStep[0] == -1 && coordinatesOfNextStep[1] == -1) {
            return ;
        }

        map.get(this.y).set(this.x, config.getCharacters().getEmpty());
        this.y = coordinatesOfNextStep[0];
        this.x = coordinatesOfNextStep[1];
        if (map.get(this.y).get(this.x) == config.getCharacters().getPlayer()) {
            gameState.setState(GameState.STATE.LOSE);
        }
        map.get(this.y).set(this.x, config.getCharacters().getEnemy());
    }
}
