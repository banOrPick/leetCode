import java.util.*;

public class 计算网络信号信号强度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] ints = new int[n][m];
        Queue<int[]> list = new LinkedList<int[]>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ints[i][j] = scanner.nextInt();
                if (ints[i][j] > 0) {
                    int[] tmp = new int[2];
                    tmp[0] = i;
                    tmp[1] = j;
                    list.offer(tmp);
                }
            }
        }
        while (!list.isEmpty()) {
            int[] tmp = list.poll();
            if (ints[tmp[0]][tmp[1]] == 1) {
                break;
            }
            int[][] dirs =  {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : dirs) {
                int i = tmp[0] + dir[0];
                int j = tmp[1] + dir[1];
                if (i >= 0 && i < n && j >= 0 && j < m && ints[i][j] == 0) {
                    ints[i][j] = ints[tmp[0]][tmp[1]] - 1;
                    int[] tmp2 = new int[2];
                    tmp2[0] = i;
                    tmp2[1] = j;
                    list.offer(tmp2);
                }
            }

        }
        int result = ints[scanner.nextInt()][scanner.nextInt()];
        System.out.println(result);
    }
}
