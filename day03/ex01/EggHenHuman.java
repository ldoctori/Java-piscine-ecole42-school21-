import java.util.Random;

enum Type {
    PRODUCER,
    CONSUMER
}

public class EggHenHuman implements Runnable {

    private String str;
    private int count;
    private Printer printer;
    private Type type;

    public EggHenHuman(String str, int count, Printer printer) {
        this.str = str;
        this.count = count;
        this.printer = printer;
        if (str.equals("Egg") == true) {
            this.type = Type.CONSUMER;
        } else {
            this.type = Type.PRODUCER;
        }
    }
    @Override
    public void run() {
        
        for (int i = 0; i < count; i++) {
           try {
				printer.printMessage(this.str, this.type);
            } catch (InterruptedException e) {
            	e.printStackTrace();
            }
        }
    }
}