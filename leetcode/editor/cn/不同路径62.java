import org.junit.Test;

public class 不同路径62 {
    public int m;
    public int n;
    public int result = 0;
    public int[][] dir = new int[][]{{1, 0}, {0, 1}};


    @Test
    public void test1() {
        System.out.println(uniquePaths(3, 2));
    }

    public int uniquePaths(int m, int n) {
        this.m = m;
        this.n = n;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    //dfs
//    public int uniquePaths(int m, int n) {
//        this.m = m;
//        this.n = n;
//        boolean[][] visit = new boolean[m][n];
//        dfs(0, 0, visit);
//        return result;
//    }
//
//    private void dfs(int i, int j, boolean[][] visit) {
//        if (i == m - 1 && j == n - 1) {
//            result++;
//            return;
//        }
//        for (int k = 0; k < dir.length; k++) {
//            int x = i + dir[k][0];
//            int y = j + dir[k][1];
//            if (x < m && y < n && !visit[x][y]) {
//                visit[x][y] = true;
//                dfs(x, y, visit);
//                visit[x][y] = false;
//            }
//
//        }
//    }
}
