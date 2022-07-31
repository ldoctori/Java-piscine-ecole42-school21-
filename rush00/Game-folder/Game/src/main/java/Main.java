import charactersObhects.CharactersFacade;
import charactersObhects.Enemy;
import charactersObhects.GameState;
import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.Attribute;
import config.*;
import map.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameters;
import com.beust.jcommander.Parameter;



@Parameters (separators = "=")
public class Main {

    @Parameter (names = {"--enemiesCount", "-e"})
    private static int enemiesCount;
    @Parameter (names = {"--wallsCount", "-w"})
    private static int wallsCount;
    @Parameter (names = {"--size", "-s"})
    private static int size;
    @Parameter (names = {"--profile", "-p"})
    private static String profile;
    private static final String APP_CONFIG_PROD_PATH = "/props/application-production.properties";
    private static final String APP_CONFIG_DEV_PATH = "/props/application-dev.properties";
    private static CharactersFacade charactersFacade;
    private static List<Character> playerGoalWallEnemy;

    public static void main(String[] args) throws IOException, InterruptedException {
        
        JCommander.newBuilder()
                    .addObject(new Main())
                    .build()
                    .parse(args);
        checkInput();
        Configuration config;
        if (profile.equals("production")) {
           config = new Configuration(APP_CONFIG_PROD_PATH);
        } else {
            config = new Configuration(APP_CONFIG_DEV_PATH);
        }

        playerGoalWallEnemy = new ArrayList<Character>();
        playerGoalWallEnemy.add(config.getCharacters().getPlayer());
        playerGoalWallEnemy.add(config.getCharacters().getGoal());
        playerGoalWallEnemy.add(config.getCharacters().getWall());
        playerGoalWallEnemy.add(config.getCharacters().getEnemy());
        Map map = new Map(config, size, wallsCount, enemiesCount);
        charactersFacade = new CharactersFacade(map.getMapGenerator().getMap(), config, size, enemiesCount);
        Scanner sc = new Scanner(System.in);
        String line;

        map.getMapPrinter().printMap();
        line = sc.nextLine();
        while (line.equals("9") == false) {
            if (charactersFacade.getPlayer().movePlayer(line) == false) {
                clearOrNot();
                map.getMapPrinter().printMap();
                line = sc.nextLine();
                continue;
            }
            checkGameState();
            clearOrNot();
            map.getMapPrinter().printMap();
            for (Enemy en : charactersFacade.getEnemyList()) {
                en.moveEnemy(Chase.printHello(map.getMapGenerator().getMap(),
                        playerGoalWallEnemy, en.getX(), en.getY()));
                checkGameState();
            }
            System.out.println();
            clearOrNot();
            map.getMapPrinter().printMap();
            charactersFacade.getPlayer().checkCanMove();
            checkGameState();
            line = sc.nextLine();
        }
    }

    private static void checkGameState() {
        if (charactersFacade.getGameState().getState() == GameState.STATE.WIN) {
            System.out.println(Ansi.colorize("We have a WINNER! And this is YOU! CONGRATULATIONS!", Attribute.GREEN_TEXT()));
            System.exit(0);
        } else if (charactersFacade.getGameState().getState() == GameState.STATE.LOSE) {
            System.out.println(Ansi.colorize("We have a WINNER! And this is YOUR ENEMY! YOU LOSE!", Attribute.RED_TEXT()));
            System.exit(0);
        }
    }

    private static void checkInput() throws IllegalParametersException {
        if (enemiesCount + wallsCount >= size * size - 2
            || enemiesCount < 0 || wallsCount < 0
            || size <= 1) {
            throw new IllegalParametersException();
        }
        if ((profile.equals("dev") == false) && (profile.equals("production") == false)) {
            throw new IllegalParametersException();
        }
    }

    private static void clearOrNot() {
        if (profile.equals("production") == true) {
            System.out.print("\033[H\033[J");
        }
    }
}