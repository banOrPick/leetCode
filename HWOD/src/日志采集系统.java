import java.util.Arrays;
import java.util.Scanner;

public class 日志采集系统 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] split = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = 0;
        int count = 0;
        for (int i = 0; i < split.length; i++) {
            int num = split[i];
            count += num;
            max = Math.max(getScore(i, split, count), max);
            if (count >= 100) {
                break;
            }
        }
        System.out.println(max);

    }

    private static int getScore(int i, int[] split, int count) {
        int score = 0;
        for (int j = 0; j <= i; j++) {
            score = score - (i - j) * split[j] + split[j];
        }
        if (count >= 100) {
            score = score - (count - 100);
        }
        return score;
    }
}
