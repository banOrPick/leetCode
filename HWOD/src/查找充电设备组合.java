import java.util.Scanner;

public class 查找充电设备组合 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] powers = new int[n];
        for (int i = 0; i < n; i++) {
            powers[i] = scanner.nextInt();
        }
        int maxPower = scanner.nextInt();
        int[][] dp = new int[n + 1][maxPower + 1];
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= maxPower; j++) {
                if (powers[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], powers[i-1] + dp[i - 1][j - powers[i - 1]]);
                }

            }
        }
        System.out.println(dp[n][maxPower]);
    }
}
