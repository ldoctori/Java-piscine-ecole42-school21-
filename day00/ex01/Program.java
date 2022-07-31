import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        int in_number;
        Scanner console;
        int sqrt;
        int exit_code;

        console = new Scanner(System.in);
        in_number = console.nextInt();
        if (in_number <= 1) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
        if (in_number == 2) {
           System.out.println(true + " " + 1);
           System.exit(0);
        }
        isPrime(in_number);
        console.close();
        
    }

    private static void isPrime(int number) {
        int sqrt;
        int n;
        int count;
        boolean prime;

        n = 2;
        count = 1;
        sqrt = ftSqrt(number);
        prime = true;
        while (n <= sqrt) {
            if (number % n == 0) {
                prime = false;
                break;
            }
            count++;
            n++;
        }
        System.out.println(prime + " " + count);
    }

    private static int ftSqrt(int input) {
        int start = 0;
        int end = input;
        int ret = 0;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (input / mid == mid) {
                return (mid);
            } else if (mid < input / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return mid;
    }
}
