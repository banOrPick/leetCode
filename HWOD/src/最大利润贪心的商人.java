import java.util.Scanner;

public class 最大利润贪心的商人 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int days = scanner.nextInt();
        int[] maxDays = new int[number];
        int[][] itemPrice = new int[number][days];
        int[] maxLiRun = new int[number];
        for (int i = 0; i < number; i++) {
            maxDays[i] = scanner.nextInt();
        }
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < days; j++) {
                itemPrice[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < number; i++) {
            int max = 0;
            for (int j = 1; j < days; j++) {
                max += Math.max(0, itemPrice[i][j] - itemPrice[i][j - 1]) * maxDays[i];
            }
            maxLiRun[i] = max;
        }
        int result = 0;
        for (int i = 0; i < number; i++) {
            result += maxLiRun[i];
        }
        System.out.println(result);
    }
}
