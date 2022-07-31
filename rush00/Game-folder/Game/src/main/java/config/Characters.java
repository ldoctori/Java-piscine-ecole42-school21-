package config;

import java.util.Map;

public class Characters {
        
    private char enemy;
    private char player;
    private char wall;
    private char goal;
    private final char empty;

    public Characters(Map<String, String> config) {
        this.enemy = config.get("enemy.char").toCharArray()[0];
        this.player = config.get("player.char").toCharArray()[0];
        this.wall = config.get("wall.char").toCharArray()[0];
        this.goal = config.get("goal.char").toCharArray()[0];
        this.empty = config.get("empty.char").toCharArray()[0];
    }

    public char getEnemy() {
        return this.enemy;
    }

    public char getPlayer() {
        return this.player;
    }

    public char getWall() {
        return this.wall;
    }

    public char getGoal() {
        return this.goal;
    }

    public char getEmpty() {
        return this.empty;
    }
}
