public class Program {

    public static void main(String[] args) {
        int number;
        int result;

        number = 479598;
        result = 0;
        while (number != 0) {
            result += number % 10;
            number /= 10;
        }
        System.out.println(result);
    }
}