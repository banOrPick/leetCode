import java.util.*;

public class 周末爬山 {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int m;
    public static int n;
    public static int k;
    public static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        k = Integer.parseInt(split[2]);
        int[][] arr = new int[m][n];
        Set<Integer> list = new TreeSet<Integer>(Comparator.reverseOrder());
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
                list.add(arr[i][j]);
            }
        }
        for (int max : list) {
            boolean[][] visit = new boolean[m][n];
            visit[0][0] = true;
            minValue = Math.min(dfs(arr, 0, 0, visit, 0, max), minValue);
            if (minValue < m * n) {
                System.out.println(max + " " + minValue);
                break;
            }
        }
    }

    private static int dfs(int[][] arr, int i, int j, boolean[][] visit, int min, int max) {
        if (arr[i][j] == max) {
            minValue = Math.min(min, minValue);
            return minValue;
        }
        for (int l = 0; l < 4; l++) {
            int x = i + dir[l][0];
            int y = j + dir[l][1];
            if (x >= 0 && x < m && y >= 0 && y < n && !visit[x][y] && Math.abs(arr[x][y] - arr[i][j]) <= k) {
                visit[x][y] = true;
                min++;
                dfs(arr, x, y, visit, min, max);
                visit[x][y] = false;
                min--;
            }
        }
        return minValue;
    }




//    // 定义一个常量数组，表示上下左右四个方向的偏移量
//    private static final int[][] OFFSETS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // 读取输入的m, n, k
//        int m = sc.nextInt();
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//
//        // 初始化山地图矩阵
//        int[][] matrix = new int[m][n];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                matrix[i][j] = sc.nextInt();
//            }
//        }
//
//        // 初始化一个哈希表，用于存储到达不同高度的最短步数
//        HashMap<Integer, Integer> minStepToHeight = new HashMap<>();
//        minStepToHeight.put(matrix[0][0], 0);
//
//        // 初始化一个记忆化数组，用于记录已经访问过的位置和步数
//        int[][] memo = new int[m][n];
//        // 初始化一个布尔数组，用于记录已经访问过的位置
//        boolean[][] visited = new boolean[m][n];
//        // 调用深度优先搜索函数
//        dfs(0, 0, 0, minStepToHeight, matrix, m, n, k, memo, visited);
//
//        // 计算最高峰的高度和最短步数
//        int maxHeight = minStepToHeight.keySet().stream().max((a, b) -> a - b).orElse(0);
//        int minStep = minStepToHeight.get(maxHeight);
//
//        // 输出结果
//        System.out.println(maxHeight + " " + minStep);
//    }
//
//    // 深度优先搜索函数
//    public static void dfs(int x, int y, int step, HashMap<Integer, Integer> minStepToHeight, int[][] matrix, int m, int n, int k, int[][] memo, boolean[][] visited) {
//        // 获取当前位置的高度
//        int lastHeight = matrix[x][y];
//
//        // 遍历四个方向
//        for (int[] offset : OFFSETS) {
//            // 计算新的位置
//            int newX = x + offset[0];
//            int newY = y + offset[1];
//
//            // 检查新位置是否在矩阵范围内
//            if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
//
//            // 获取新位置的高度
//            int curHeight = matrix[newX][newY];
//
//            // 检查两个位置的高度差是否在k以内
//            if (Math.abs(curHeight - lastHeight) <= k) {
//                // 增加步数
//                step++;
//
//                // 更新到达新高度的最短步数
//                if (!minStepToHeight.containsKey(curHeight) || minStepToHeight.get(curHeight) > step) {
//                    minStepToHeight.put(curHeight, step);
//                }
//
//                // 检查记忆化数组，避免重复计算
//                if (memo[newX][newY] == 0 || memo[newX][newY] > step) {
//                    // 更新记忆化数组
//                    memo[newX][newY] = step;
//                    // 标记当前位置为已访问
//                    visited[x][y] = true;
//
//                    // 递归调用深度优先搜索
//                    dfs(newX, newY, step, minStepToHeight, matrix, m, n, k, memo, visited);
//
//                    // 回溯时，将当前位置标记为未访问
//                    visited[x][y] = false;
//                }
//
//                // 减少步数
//                step--;
//            }
//        }
}
