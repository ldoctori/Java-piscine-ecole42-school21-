package map;

import config.Configuration;

public class Map {

    private MapGenerator mapGenerator;
    private MapPrinter mapPrinter;

    public Map(Configuration config, int size, int wallsCount, int enemiesCount){

        this.mapGenerator = new MapGenerator(config, size, wallsCount, enemiesCount);
        this.mapPrinter = new MapPrinter(mapGenerator.getMap(), config);
    }

    public MapPrinter getMapPrinter() {
        return  this.mapPrinter;
    }

    public  MapGenerator getMapGenerator() {
        return  this.mapGenerator;
    }
}
