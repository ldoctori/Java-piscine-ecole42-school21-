import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int number = 0;
        int count = 0;

        while (number != 42) {
            number = scanner.nextInt();
            if (number > 1 && ((number == 2) || isPrime(sumOfDigits(number)))) {
                count++;
            }
        }
        System.out.println("Count of coffe-request - " + count);
        scanner.close();
    }
   private static int sumOfDigits(int number) {

        int result = 0;

        while (number != 0) {
           result += number % 10;
           number /= 10;
        }
            return result;
    }
    private static boolean isPrime(int number) {
        int sqrt;
        int n;
        boolean prime;

        n = 2;
        sqrt = ftSqrt(number);
        prime = true;
        while (n <= sqrt) {
            if (number % n == 0) {
                prime = false;
                break;
            }
            n++;
        }
        return prime;
    }

    private static int ftSqrt(int input) {
        int start = 0;
        int end = input;
        int ret = 0;
        int mid = 0;

        while (start <= end) {
            mid = (start + end) / 2;
            if (input / mid == mid)
                return (mid);
            else if (mid < input / mid)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return mid;
    }
}
