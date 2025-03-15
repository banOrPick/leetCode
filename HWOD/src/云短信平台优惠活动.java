import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class 云短信平台优惠活动 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int money = Integer.parseInt(scanner.nextLine());
        int[] prices = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] dp = new int[money + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j <= money; j++) {
                dp[j] = Math.max(dp[j], dp[j - (i + 1)] + prices[i]);
            }
        }
        System.out.println(dp[money]);

    }
}
