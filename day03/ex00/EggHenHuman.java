import java.util.Random;

public class EggHenHuman implements Runnable {

    private String str;
    private int count;
    private int sleepTime;

    public EggHenHuman(String str, int count, int sleepTime) {
        this.str = str;
        this.count = count;
        this.sleepTime = sleepTime;
    }
    @Override
    public void run() {
        
        for (int i = 0; i < count; i++) {
            System.out.println(this.str);
            if ((str.equals("Human") == false) && (sleepTime > 0)) {
                try {
                    Thread.sleep(sleepTime);   
                } catch (Exception e) {
                    System.out.println("Interrupted thread!");
                    System.exit(-1);
                }
            }
        }
    }

    
}