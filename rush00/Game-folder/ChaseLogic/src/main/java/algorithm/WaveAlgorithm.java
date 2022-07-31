package algorithm;

import java.util.ArrayList;
import java.util.List;

public class WaveAlgorithm {

    private static List<ArrayList<Integer>> mapInt;
    private static Integer[] coordinates;
    private List<Character> playerGoalWallEnemy;
    private int playerX;
    private int playerY;

    private int pathX;
    private int pathY;

    private boolean goOn;
    private int enemy;
    public WaveAlgorithm(List<ArrayList<Integer>> mapInt, List<Character> playerGoalWallEnemy, int playerX, int playerY) {
        this.mapInt = mapInt;
        this.playerGoalWallEnemy = playerGoalWallEnemy;
        this.playerX = playerX;
        this.playerY = playerY;
        this.coordinates = new Integer[2];
    }

    public int[] findNextStepCoordinates() throws InterruptedException {

        int[] coordinatesOfNextStepYX = findCoordinatesOfSmaller();
        int y = coordinatesOfNextStepYX[0];
        int x = coordinatesOfNextStepYX[1];
        int[] dx = new int[4];
        int[] dy = new int[4];
        int k = 0;
        int d = mapInt.get(y).get(x);
        delta(dx, dy);
        if (d < 0) {
            coordinatesOfNextStepYX[0] = -1;
            coordinatesOfNextStepYX[1] = -1;
            return coordinatesOfNextStepYX;
        }
        if (d == 0) {
            while (k < 4) {
                if ((y + dy[k] < mapInt.size() && x + dx[k] < mapInt.size())
                   && (y + dy[k] >= 0 && x + dx[k] >= 0)) {
                    if (mapInt.get(y + dy[k]).get(x + dx[k]) == -3) {
                        x += dx[k];
                        y += dy[k];
                        d--;
                        break;
                    }
                }
                k++;
            }
            coordinatesOfNextStepYX[0] = y;
            coordinatesOfNextStepYX[1] = x;
            return coordinatesOfNextStepYX;
        }
        if (d == 1) {
            return coordinatesOfNextStepYX;
        }
        while (d != 1)
        {
            k = 0;
            while (k < 4) {
                if (y + dy[k] < mapInt.size() && x + dx[k] < mapInt.size()
                        && y + dy[k] >= 0 && x + dx[k] >= 0) {
                    if (mapInt.get(y + dy[k]).get(x + dx[k]) == d - 1) {
                        x += dx[k];
                        y += dy[k];
                        d--;
                        break;
                    }
                }
                k++;
            }
        }
        coordinatesOfNextStepYX[0] = y;
        coordinatesOfNextStepYX[1] = x;
        return coordinatesOfNextStepYX;
    }

    private int[] findCoordinatesOfSmaller() {
        int[] dx = new int[4];
        int[] dy = new int[4];
        int[] coordinatesYX = new int[2];
        int k = 0;
        int d;

        d = mapInt.get(playerY).get(playerX);
        delta(dx, dy);
        while (k < 4) {
            if (playerY + dy[k] < mapInt.size() && playerY + dy[k] >= 0
                    && playerX + dx[k] < mapInt.get(playerY).size() && playerX + dx[k] >= 0
                    && mapInt.get(playerY + dy[k]).get(playerX + dx[k]) >= 0) {
                d = mapInt.get(playerY + dy[k]).get(playerX + dx[k]);
                coordinatesYX[0] = playerY + dy[k];
                coordinatesYX[1] = playerX + dx[k];
                break;
            }
            k++;
        }
        k = 0;
        while (k < 4) {
            if (playerY + dy[k] < mapInt.size() && playerX + dx[k] < mapInt.get(playerY).size()
                    && playerY + dy[k] >= 0 && playerX + dx[k] >= 0
                    && d > mapInt.get(playerY + dy[k]).get(playerX + dx[k])
                    && mapInt.get(playerY + dy[k]).get(playerX + dx[k]) >= 0) {
                coordinatesYX[0] = playerY + dy[k];
                coordinatesYX[1] = playerX + dx[k];
                d = mapInt.get(playerY + dy[k]).get(playerX + dx[k]);
            }
            k++;
        }
        return coordinatesYX;
    }

    public void reCalculateMap() {

        goOn = true;
        enemy = 0;
        pathX = 0;
        pathY = 0;

        while ((goOn == true) && mapInt.get(playerY).get(playerX) == -3) {

            goOn = false;
            pathY = 0;
            while (pathY < mapInt.size()) {
                pathX = 0;
                while (pathX < mapInt.get(pathY).size()) {
                    if (mapInt.get(pathY).get(pathX) == enemy) {
                        pathFinder();
                    }
                    pathX++;
                }
                pathY++;
            }
            enemy++;
        }
    }

    private void pathFinder() {

        int	k;
        int[] dx = new int[4];
        int[] dy = new int[4];

        delta(dx, dy);
        k = 0;
        while (k < 4)
        {
            if (pathY + dy[k] >= 0 && pathY + dy[k] < mapInt.size()
                    && pathX + dx[k] >= 0 && pathX + dx[k] < mapInt.get(pathY).size()
                    && mapInt.get(pathY + dy[k]).get(pathX + dx[k]) == -2)
            {
                mapInt.get(pathY + dy[k]).set(pathX + dx[k], enemy + 1);
                goOn = true;
            }
            k++;
        }
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



}
