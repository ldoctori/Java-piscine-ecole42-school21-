import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Program {
    
    private static final String flagSize = "--arraySize";
    private static final String flagCount = "--threadsCount";
    private static int[] arr;
    private static int size;
    private static int count;
    
    public static void main(String[] args) throws IOException, InterruptedException {
    
        parseArgs(args);
        fillArray();
        SumCalculator calculator = new SumCalculator(arr);
        List<SubArray> subArrays = new ArrayList<SubArray>();
        List<Thread> threads = new ArrayList<Thread>();
        int finalSum = 0;

        int i;
        int delta = Math.round((float) size / (float) count);
        int begin = 0;
        int end;
        for (i = 0; i < count - 1; i++) {
            end = begin + delta - 1;
            subArrays.add(new SubArray(calculator, i + 1, begin, end));
            threads.add(new Thread(subArrays.get(i)));
            begin = end + 1;
        }
        subArrays.add(new SubArray(calculator, i + 1, begin, (size - 1)));
        threads.add(new Thread(subArrays.get(i)));

        for (Thread it : threads) {
            it.start();
        }
        for (Thread it : threads) {
            it.join();
        }
        for (SubArray it : subArrays) {
            finalSum += it.getSum();
        }
        System.out.println("Sum by threads: " + finalSum);

    }

    private static void fillArray() {
        arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
    }

    private static void parseArgs(String[] args) throws IOException{

        String[] parsedArg;
        String tmp;

        if (args.length != 2) {
            throw new IOException("Wrong arguments!");
        }
        parsedArg = args[0].split("=");
        if (parsedArg.length != 2) {
            throw new IOException("Wrong first argument!");
        }
        if (parsedArg[0].equals(flagSize) == true) {
            size = Integer.parseInt(parsedArg[1]);
        } else if (parsedArg[0].equals(flagCount)) {
            count = Integer.parseInt(parsedArg[1]);
        } else {
            throw new IOException("Wrong first flag!");
        }
        tmp = parsedArg[0];
        parsedArg = args[1].split("=");
        if (parsedArg.length != 2) {
            throw new IOException("Wrong second argument!");
        }
        if ((parsedArg[0].equals(flagSize) == true) && (parsedArg[0].equals(tmp) == false)) {
            size = Integer.parseInt(parsedArg[1]);
        } else if (parsedArg[0].equals(flagCount) && (parsedArg[0].equals(tmp) == false)) {
            count = Integer.parseInt(parsedArg[1]);
        } else {
            throw new IOException("Wrong second flag!");
        }

        if (size < 0 || count < 0 
            || size > 2000000 || count > size
            || size / count > 1000) {
            throw new IOException("Wrong arraySize or threadsCount or their ratio!");
            }
    }
}
