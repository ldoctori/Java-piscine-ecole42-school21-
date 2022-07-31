import java.io.IOException;

class Program {

    private static final String str = "Human";
    private static final String flag = "--count";
    private static Integer count;
    public static void main(String[] args) throws IOException, InterruptedException {
        
        EggHenHuman egg;
        EggHenHuman hen;
        EggHenHuman human;
        Thread threadEgg;
        Thread threadHen;
        Integer sleepTime = parseSleepTime(args);

        if (args.length != 1 && args.length != 2) {
            throw new IOException("Wrong argument!");
        }
        count = parseArg(args[0]);
        egg = new EggHenHuman("Egg", count, sleepTime);
        hen = new EggHenHuman("Hen", count, sleepTime);
        threadEgg = new Thread(egg);
        threadHen = new Thread(hen);
        threadEgg.start();
        threadHen.start();
        threadEgg.join();
        threadHen.join();
        human = new EggHenHuman("Human", count, sleepTime);
        human.run();
    }

    private static Integer parseArg(String arg) throws IOException{

        String[] parsedArg = arg.split("=");
        if (parsedArg[0].equals(flag) == false) {
            throw new IOException("Wrong flag!");
        }
        Integer count = Integer.parseInt(parsedArg[1]);
        return count;
    }

    private static Integer parseSleepTime(String[] args) {

        Integer sleepTime;

        try {
            sleepTime = Integer.parseInt(args[1]);
        } catch (Exception e) {
            sleepTime = 0;
        }
        return sleepTime;

    }
}