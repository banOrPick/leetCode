import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 计算疫情扩散时间 {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] split = nextLine.split(",");
        int n = (int) Math.sqrt(split.length);
        int[][] array = new int[n][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        int total = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = Integer.parseInt(split[i * n + j]);
                if (array[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                } else {
                    total++;
                }
            }
        }
        int result = 0;
        while (!queue.isEmpty() && total > 0) {
            int[] arr = queue.poll();
            int x = arr[0];
            int y = arr[1];
            result = array[x][y] + 1;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && array[newX][newY] == 0) {
                    total--;
                    array[newX][newY] = result;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        System.out.println(result - 1);

    }

}
