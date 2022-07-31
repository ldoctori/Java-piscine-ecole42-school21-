package charactersObhects;

import config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class CharactersFacade {

    private List<Enemy> enemies;
    private Player player;

    private GameState gameState;

    public CharactersFacade(List<ArrayList<Character>> map, Configuration config, int size, int enemiesCount) {

        this.enemies = new ArrayList<Enemy>();
        this.gameState = GameState.getInstance();
        this.player = Player.getPlayer(map,config,size, this.gameState);

        for (int i = 0; i < enemiesCount; i++) {
            enemies.add(new Enemy(map, config, size, gameState));
        }
    }

    public Player getPlayer() {
        return this.player;
    }
    public GameState getGameState() {
        return this.gameState;
    }
    public List<Enemy> getEnemyList() {
        return this.enemies;
    }

}
