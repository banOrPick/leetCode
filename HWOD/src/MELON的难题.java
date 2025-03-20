import java.util.Scanner;

public class MELON的难题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取雨花石的数量
        int n = scanner.nextInt();
        int[] stones = new int[n];
        int totalWeight = 0;

        // 读取每块雨花石的重量并计算总重量
        for (int i = 0; i < n; i++) {
            stones[i] = scanner.nextInt();
            totalWeight += stones[i];
        }

        // 如果总重量为奇数，无法均分
        if (totalWeight % 2 != 0) {
            System.out.println(-1);
            return;
        }

        int targetWeight = totalWeight / 2;
        // dp[i][j] 表示前 i 块雨花石达到重量 j 所需的最少雨花石数量
        int[][] dp = new int[n + 1][targetWeight + 1];

        // 初始化 dp 数组
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= targetWeight; j++) {
                dp[i][j] = n + 1;
            }
        }

        // 正向遍历进行动态规划
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= targetWeight; j++) {
                // 不选择第 i 块雨花石
                dp[i][j] = dp[i - 1][j];
                if (j >= stones[i - 1]) {
                    // 选择第 i 块雨花石
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - stones[i - 1]] + 1);
                }
            }
        }

        // 判断是否能达到目标重量
        if (dp[n][targetWeight] > n) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n][targetWeight]);
        }
    }
}
