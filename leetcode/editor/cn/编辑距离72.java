import org.junit.Test;

public class 编辑距离72 {

    @Test
    public void test() {
        minDistance("horse", "ros");
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 0;
                } else if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    int temp=dp[i - 1][j - 1];
                    if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                        temp = temp + 1;
                    }
                    dp[i][j] = Math.min(temp, Math.min(dp[i - 1][j], dp[i][j - 1]) + 1);

                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
