import org.junit.Test;

public class 完全平方数279 {
    @Test
    public void test() {
        numSquares(12);
    }

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int result = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                result = Math.min(result, dp[i - j * j] + 1);
            }
            dp[i] = result;
        }
        return dp[n];
    }
}
