public class SubArray implements Runnable {

    private SumCalculator calculator;
    private int num;
    private int begin;
    private int end;
    private int sum;


    public SubArray(SumCalculator calculator, int num, int begin, int end){
        this.calculator = calculator;
        this.num = num;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        this.sum = calculator.calculateSum(num, begin, end);
    }

    public int getSum()
    {
        return this.sum;
    }
    
}
