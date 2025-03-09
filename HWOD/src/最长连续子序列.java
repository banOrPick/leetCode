import java.util.Arrays;
import java.util.Scanner;

public class 最长连续子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int sum = Integer.parseInt(scanner.nextLine());
        int left = 0, right = 0;
        int max = -1;
        for (; right < input.length; right++) {
            int tempSum = getSum(left, right, input);
            if (tempSum == sum) {
                max = Math.max(max, right - left + 1);
            }
            if (tempSum > sum) {
                left++;
            }
        }
        System.out.println(max);
    }

    private static int getSum(int left, int right, int[] input) {
        int tempSum = 0;
        for (int i = left; i <= right; i++) {
            tempSum += input[i];
        }
        return tempSum;
    }
}
