import java.util.Scanner;

public class Program {

    private static String []arr = new String[65535];
    private static final int MAX_HYSTO_HEIGHT = 10;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        char []in = input.toCharArray();
        parse_input(in);
        int k = 0;
        while (arr[k] != null) {
            k++;
        }
        stringSort(0, k - 1);
        stringLexSort(k);
        drawHysto();
    }

    private static void parse_input(char []in) {

        int k = 0;
        
        for (int i = 0; i < in.length; i++) {
            k = findInArr(in[i]);
            if (arr[k] == null) {
                arr[k] = in[i] + "";
            } else {
                arr[k] += in[i];
            }
        }
    }

    private static int findInArr(char ch){

        int i = 0;
        for (; arr[i] != null; i++) {
            if (ch == arr[i].toCharArray()[0]) {
                return i;
            }
        }
        return i;
    }

    private static void stringLexSort(int size)
    {
        for (int i = 0; i < size - 1; i++)
        {
            if ((arr[i].length() == arr[i + 1].length())
                && (arr[i].toCharArray()[0] - arr[i + 1].toCharArray()[0] > 0)) {   
                String tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
    }

    private static void stringSort(int low, int high)
    {
        if (low >= high) {
            return;
        }         
    
        int middle = low + (high - low) / 2;
        String opora = arr[middle];
        int i = low, j = high;
        boolean eq;

        while (i <= j) {
            while (arr[i].length() > opora.length()) {
                i++;
            }
            while (arr[j].length() < opora.length()) {
                j--;
            }
            if (i <= j) {
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (low < j) {
                stringSort(low, j);
        }
        if (high > i) {
            stringSort(i, high);
        }
    }

    private static int spaceNum(int n) {
        int k = 0;
        while (n > 0) {
            n /= 10;
            k++;
        }
        return (k - 1);
    }

    private static void drawHysto() {
        int max_length = 0;
        int length;
        int member;
        int space_num;

        max_length = arr[0].length();
        space_num = spaceNum(arr[1].length());
        
        for (int i = MAX_HYSTO_HEIGHT + 1; i >= 1; i--) {
            for (int j = 0; arr[j] != null; j++) {
                length = arr[j].length();
                member = (int) ((((double) length / max_length)) * MAX_HYSTO_HEIGHT + 1);
                if ((length > 1) && (member == i)) {
                    if (space_num > spaceNum(length)) {
                        for (int z = 0; z < space_num - spaceNum(length); z++) {
                            System.out.print(" ");
                        }
                    }
                    System.out.print(length + "  ");
                    continue ;
                }
                if (member > i) {
                    for (int k = 0; k < space_num; k++) {
                        System.out.print(" ");
                    }
                    System.out.print("#  ");
                }
            }
            System.out.println();
        } 
        for(int i = 0; arr[i] != null; i++) {
            if (arr[i].length() == 1) {
                break ;
            }
            for (int j = 0; j < space_num; j++) {
                    System.out.print(" ");
            }
            System.out.print(arr[i].toCharArray()[0] + "  ");
        }
        System.out.println();    
    
    }
}