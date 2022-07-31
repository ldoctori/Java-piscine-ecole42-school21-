public class SumCalculator {
    
    private int[] arr;
    
    public SumCalculator(int[] arr) {
        this.arr = arr;
    }

    public synchronized int calculateSum(int num, int begin, int end) {
        
        int sum = 0;

        for (int i = begin; i <= end; i++) {
            sum += arr[i];
        }
        System.out.println("Thread " + num + ": from " + begin + " to " + end + " sum is " + sum);
        return sum;
    }

}
