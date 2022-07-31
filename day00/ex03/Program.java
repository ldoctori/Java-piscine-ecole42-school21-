import java.util.Scanner;

public class Program {

    private static final String WEEK = "Week ";
    private static final String TERM = "42";
    private static long all_grades = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String  in_week = sc.nextLine();
        int     week_num = 1;

        while ((week_num <= 18) && (!TERM.equals(in_week))) {
            if (!in_week.equals(WEEK + week_num)) {
                System.err.println("IllegalArgument");
                System.exit(-1);
            }
            all_grades = all_grades * 10 +  minForWeek(sc);
            in_week = sc.nextLine();
            week_num++;
        }
        makeGraph(all_grades);
        sc.close();
    }

    private static int minForWeek(Scanner sc) {

        int grade = sc.nextInt();
        int min = grade;
        for (int i = 0; i < 4; i++){
            grade = sc.nextInt();
            min = (min > grade) ? grade : min;
        }
        sc.nextLine();
        return (min);
    }

    private static void makeGraph(long all_grades) {
        long    buff = all_grades;
        int     power = 1;
        int     week_num = 1;

        while (buff != 0){
            buff /= 10;
            power *= 10;
        }
        power /= 10;
        while (power != 0)
        {
            System.out.print(WEEK + week_num + " ");
            for (int i = 0; i < all_grades / power; i++) {
                System.out.print("=");
            }
            System.out.println(">");
            all_grades %= power;
            power  /= 10;
            week_num++;
        }
    }
}
