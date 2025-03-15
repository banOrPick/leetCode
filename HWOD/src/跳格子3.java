import java.util.Scanner;

public class 跳格子3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            scores[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = scores[i];
            }else{
                int tmpMax=Integer.MIN_VALUE;
                int j=Math.max(0, i-k);
                for (; j < i; j++) {
                    tmpMax = Math.max(dp[j], tmpMax);
                }
                dp[i] = tmpMax+scores[i];
            }
        }
        System.out.println(dp[n-1]);
    }
}
