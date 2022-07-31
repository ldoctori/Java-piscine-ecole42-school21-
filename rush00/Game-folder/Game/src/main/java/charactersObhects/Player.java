package charactersObhects;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import config.Configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {

    private static Player player;
    private static List<ArrayList<Character>> map;
    private static Configuration config;
    private static int size;
    private static GameState gameState;
    private int x;
    private int y;

    private Player(List<ArrayList<Character>> map, Configuration config, int size, GameState gameState) {

        this.map = map;
        this.config = config;
        this.size = size;
        this.gameState = gameState;
        startPosition();
    }

    private boolean checkStep(int x, int y) throws  IndexOutOfBoundsException{

        try {
            if (map.get(this.y + y).get(this.x + x) != config.getCharacters().getWall()) {
                map.get(this.y).set(this.x, config.getCharacters().getEmpty());
                this.x += x;
                this.y += y;
                if (map.get(this.y).get(this.x) == config.getCharacters().getGoal()) {
                    gameState.setState(GameState.STATE.WIN);
                } else if (map.get(this.y).get(this.x) == config.getCharacters().getEnemy()) {
                    gameState.setState(GameState.STATE.LOSE);
                } else {
                    map.get(this.y).set(this.x, config.getCharacters().getPlayer());
                }
                return true;
            } else {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

    }

    public void checkCanMove() {

        int[] dx = new int[4];
        int[] dy = new int[4];
        int k = 0;

        delta(dx, dy);
        while (k < 4)
        {
            if (y + dy[k] >= 0 && y + dy[k] < map.size()
                    && x + dx[k] >= 0 && x + dx[k] < map.get(y).size()
                    && map.get(y + dy[k]).get(x + dx[k]) == config.getCharacters().getEmpty())
            {
                return ;
            }
            k++;
        }
        gameState.setState(GameState.STATE.LOSE);

    }

    private void	delta(int[] dx, int[] dy)
    {
        dx[0] = 1;
        dx[1] = 0;
        dx[2] = -1;
        dx[3] = 0;
        dy[0] = 0;
        dy[1] = 1;
        dy[2] = 0;
        dy[3] = -1;
    }

    public boolean movePlayer(String line) {
        switch (line) {
            case "w":
                return checkStep(0, -1);
            case "a":
                return checkStep(-1, 0);
            case "s":
                return checkStep(0, 1);
            case "d":
                return checkStep(1, 0);
        }
        System.out.println(Ansi.colorize("You can move using ", Attribute.RED_TEXT())
                + Ansi.colorize("w,a,s,d", Attribute.GREEN_TEXT())
                + Ansi.colorize(" keys", Attribute.RED_TEXT()));
        return false;
    }

    public static Player getPlayer(List<ArrayList<Character>> map, Configuration config, int size, GameState gameState){
        if(player == null) {
            player = new Player(map, config, size, gameState);
        }
        return player;
    }

    private void startPosition() {

        Random random = new Random();
        int[] dx = new int[4];
        int[] dy = new int[4];
        int k = 0;
        x = random.nextInt(size);
        y = random.nextInt(size);

        while (map.get(y).get(x) != config.getCharacters().getEmpty()) {
            x = random.nextInt(size);
            y = random.nextInt(size);
        }
        delta(dx, dy);
        while (k < 4)
        {
            if (y + dy[k] >= 0 && y + dy[k] < map.size()
                    && x + dx[k] >= 0 && x + dx[k] < map.get(y).size()
                    && map.get(y + dy[k]).get(x + dx[k]) == config.getCharacters().getEmpty())
            {
                map.get(y).set(x, config.getCharacters().getPlayer());
                return ;
            }
            k++;
        }
        startPosition();
    }
}

