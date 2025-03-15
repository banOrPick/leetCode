import java.util.Scanner;

public class 特殊的加密算法 {
    static int n, m; // 分别用于存储明文的长度和密码本的尺寸
    static int[][] book; // 用于存储密码本，是一个二维数组
    static int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}}; // 表示四个搜索方向：右、下、左、上
    static String minPath = ""; // 用于存储找到的字典序最小的密文路径
    static boolean found = false; // 标记是否找到了至少一种加密方式

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt(); // 读取明文的长度
        int[] data = new int[n]; // 创建数组存储明文数字
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt(); // 读取每个明文数字
        }

        m = scanner.nextInt(); // 读取密码本的尺寸
        book = new int[m][m]; // 初始化密码本数组
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                book[i][j] = scanner.nextInt(); // 填充密码本内容
            }
        }

        boolean[][] visited = new boolean[m][m]; // 标记密码本中的数字是否已经被访问过
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (book[i][j] == data[0]) { // 从找到的第一个数字开始搜索
                    dfs(data, 0, i, j, visited, ""); // 使用深度优先搜索找到所有可能的加密路径
                }
            }
        }

        System.out.println(found ? minPath.trim() : "error"); // 如果找到至少一种加密方式，输出最小字典序的密文；否则，输出"error"
    }

    public static void dfs(int[] data, int index, int x, int y, boolean[][] visited, String path) {
        if (index == n) { // 如果已经处理完所有明文数字
            if (!found || path.compareTo(minPath) < 0) { // 如果找到的是第一种加密方式，或者字典序比之前的小
                minPath = path; // 更新最小字典序密文路径
            }
            found = true; // 标记找到了加密方式
            return;
        }

        if (x < 0 || y < 0 || x >= m || y >= m || visited[x][y] || book[x][y] != data[index]) {
            // 如果坐标越界，或该位置已访问，或该位置数字与明文不匹配，则返回
            return;
        }

        visited[x][y] = true; // 标记当前位置已访问
        String newPath = path + x + " " + y + " "; // 更新路径字符串

        if (index == n - 1 || book[x][y] == data[index]) {
            dfs(data, index + 1, x, y, visited, newPath); // 继续搜索下一个明文数字
        }

        for (int[] dir : directions) { // 遍历四个方向
            int newX = x + dir[0];
            int newY = y + dir[1];
            dfs(data, index + 1, newX, newY, visited, newPath); // 在新方向上搜索下一个明文数字
        }

        visited[x][y] = false; // 回溯，撤销当前位置的访问标记
    }
}
