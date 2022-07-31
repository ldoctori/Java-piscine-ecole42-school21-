package map;

import config.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapGenerator {

    private Random random;
    private final int size;
    private final int wallsCount;
    private final int enemiesCount;
    private final Configuration config;
    private List<ArrayList<Character>> map;
    public MapGenerator(Configuration config, int size, int wallsCount, int enemiesCount) {

        this.random = new Random();
        this.size = size;
        this.wallsCount = wallsCount;
        this.enemiesCount = enemiesCount;
        this.config = config;
        map = new ArrayList<>();
        createEmptyMap();
        setRandomWalls();
        setRandomGoal();
    }

    private void createEmptyMap() {

        for (int i = 0; i < size; i++) {
            map.add(new ArrayList<Character>());
            for (int j = 0; j < size; j++) {
                map.get(i).add(config.getCharacters().getEmpty());
            }
        }
    }
    private void setRandomWalls() {

        int x, y;
        for (int i = 0; i < wallsCount; i++) {
            x = random.nextInt(size);
            y = random.nextInt(size);
            if (map.get(y).get(x) != config.getCharacters().getEmpty()) {
                i--;
                continue;
            }
            map.get(y).set(x, config.getCharacters().getWall());
        }
    }

    private void setRandomGoal() {

        int x = random.nextInt(size);
        int y = random.nextInt(size);

        while (map.get(y).get(x) != config.getCharacters().getEmpty()) {
            x = random.nextInt(size);
            y = random.nextInt(size);
        }
        map.get(y).set(x, config.getCharacters().getGoal());
    }
    public List<ArrayList<Character>> getMap() {
        return this.map;
    }

}
