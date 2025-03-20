import java.util.Scanner;

public class 特殊的加密算法 {
    // 存储明文的长度
    private static int n;
    // 存储密码本的尺寸
    private static int m;
    // 存储密码本的二维数组
    private static int[][] book;
    // 存储字典序最小的密文路径
    private static String minPath = "";
    // 标记是否找到至少一种加密方式
    private static boolean found = false;
    // 搜索方向：右、下、左、上
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
        readInput();
        int[] plaintext = getPlaintext();
        boolean[][] visited = new boolean[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (book[i][j] == plaintext[0]) {
                    dfs(plaintext, 0, i, j, visited, "");
                }
            }
        }
        System.out.println(found ? minPath.trim() : "error");
    }

    // 读取输入
    private static void readInput() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        book = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                book[i][j] = scanner.nextInt();
            }
        }
        scanner.close();
    }

    // 获取明文数组
    private static int[] getPlaintext() {
        Scanner scanner = new Scanner(System.in);
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    // 深度优先搜索方法
    private static void dfs(int[] data, int index, int x, int y, boolean[][] visited, String path) {
        if (isEncryptionComplete(index)) {
            updateMinPath(path);
            return;
        }
        if (!isValid(x, y, index, data, visited)) {
            return;
        }
        visited[x][y] = true;
        path = updatePath(path, x, y);
        for (int[] dir : DIRECTIONS) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            dfs(data, index + 1, newX, newY, visited, path);
        }
        visited[x][y] = false;
    }

    // 检查是否完成加密
    private static boolean isEncryptionComplete(int index) {
        return index == n;
    }

    // 更新最小字典序密文路径
    private static void updateMinPath(String path) {
        if (!found || path.compareTo(minPath) < 0) {
            minPath = path;
        }
        found = true;
    }

    // 检查坐标是否有效
    private static boolean isValid(int x, int y, int index, int[] data, boolean[][] visited) {
        return x >= 0 && x < m && y >= 0 && y < m && !visited[x][y] && book[x][y] == data[index];
    }

    // 更新路径
    private static String updatePath(String path, int x, int y) {
        return path + x + " " + y + " ";
    }
}
