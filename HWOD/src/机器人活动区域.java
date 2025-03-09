import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 机器人活动区域 {

    private static final int[][] xy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int count = 0;
        int[][] visit = new int[m][n];
        for (int k = 0; k < m; k++) {
            for (int l = 0; l < n; l++) {
                count = Math.max(count, getCount(visit, arr, k, l, m, n));


            }

        }
        System.out.println(count);
    }

    private static int getCount(int[][] visit, int[][] arr, int i, int j, int m, int n) {
        visit[i][j] = 1;
        int result = 1;
        for (int k = 0; k < 4; k++) {
            int x = i + xy[k][0];
            int y = j + xy[k][1];
            if (x >= 0 && x < m && y >= 0 && y < n && visit[x][y] != 1 && Math.abs(arr[x][y] - arr[i][j]) <= 1) {
                result += getCount(visit, arr, x, y, m, n);
            }
        }
        return result;
    }
}
