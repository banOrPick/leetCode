import java.util.*;

public class 智能驾驶 {
    private static final int[][] xy = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter(",|\\s+");
        // 读取地图的行数和列数
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];
        boolean[][] visit = new boolean[m][n];
        // 填充地图数组，读取每个单元的值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
                visit[i][j] = false;
            }
        }
        int init = 100;
        int result = Integer.MIN_VALUE;
        Queue<int[]> list = new LinkedList<>();
        list.offer(new int[]{0, 0});
        minValue = Math.min(bfs(arr, init, result, m, n, list, visit), minValue);
        System.out.println(minValue > 100 ? -1 : minValue);

    }

    private static int bfs(int[][] arr, int init, int result, int m, int n, Queue<int[]> list, boolean[][] visit) {


        while (!list.isEmpty()) {
            int[] poll = list.poll();
            int xIndex = poll[0];
            int yIndex = poll[1];
            visit[xIndex][yIndex] = true;
            if (xIndex == m - 1 && yIndex == n - 1 && init >= arr[xIndex][yIndex]) {
                minValue = Math.min(result < 0 ? 100 - (init - arr[xIndex][yIndex]) : result, minValue);
            }
            if (arr[xIndex][yIndex] != -1) {
                init = init - arr[xIndex][yIndex];
            }
            if (init > 0) {
                for (int i = 0; i < 4; i++) {
                    int x = xIndex + xy[i][0];
                    int y = yIndex + xy[i][1];

                    if (x >= 0 && x < m && y >= 0 && y < n && init > arr[x][y] && arr[x][y] != 0 && !visit[x][y]) {
                        list.offer(new int[]{x, y});
                        if (arr[x][y] == -1) {
                            if (result < 0) {
                                result = 100 - init;
                            }
                            init = 100;
                        }
                        bfs(arr, init, result, m, n, list, visit);
                    }
                }
            }
        }
        return minValue;
    }
}
