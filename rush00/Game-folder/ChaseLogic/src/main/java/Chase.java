import algorithm.WaveAlgorithm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Chase {

    private static List<ArrayList<Integer>> mapInt;
    public static void main(String[] args) {

    }

    public static int[] printHello(List<ArrayList<Character>> map,
                                                      List<Character> playerGoalWallEnemy,
                                                      int x, int y) throws IOException, InterruptedException {

        mapInt = new ArrayList<>();
        int playerX = -1;
        int playerY = -1;
        int i = 0;
        int j;
        for (List<Character> it : map) {
            mapInt.add(new ArrayList<Integer>());
            j = 0;
            for (Character ch : it) {
                if (i == y && j == x) {
                    mapInt.get(i).add(0);
                } else if (ch == playerGoalWallEnemy.get(0)) {
                    playerY = i;
                    playerX = j;
                  mapInt.get(i).add(-3);
                } else if (ch == playerGoalWallEnemy.get(1)) {
                    mapInt.get(i).add(-1);
                } else if (ch == playerGoalWallEnemy.get(2)
                            || ch == playerGoalWallEnemy.get(3)) {
                    mapInt.get(i).add(-1);
                } else {
                    mapInt.get(i).add(-2);
                }
                j++;
            }
            i++;
        }
        if (playerX< 0 || playerY < 0) {
            throw new IOException("WHERE IS THE PLAYER!?");
        }
        WaveAlgorithm waveAlgorithm = new WaveAlgorithm(mapInt, playerGoalWallEnemy, playerX, playerY);
        waveAlgorithm.reCalculateMap();
        return waveAlgorithm.findNextStepCoordinates();
    }
}
