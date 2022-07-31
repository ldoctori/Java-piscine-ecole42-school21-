package config;

import java.util.Map;

public class Colors {

    private String enemy;
    private String player;
    private String wall;
    private String goal;
    private String empty;

    public Colors(Map<String, String> config) {

        this.enemy = config.get("enemy.color");
        this.player = config.get("player.color");
        this.wall = config.get("wall.color");
        this.goal = config.get("goal.color");
        this.empty = config.get("empty.color");
    }

    public String getEnemy() {
        return this.enemy;
    }

    public String getPlayer() {
        return this.player;
    }

    public String getWall() {
        return this.wall;
    }

    public String getGoal() {
        return this.goal;
    }

    public String getEmpty() {
        return this.empty;
    }
    
}
