import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.LinkedList;
import java.util.Scanner;

public class 跳马 {
    public static int m;
    public static int n;
    public static int[][] array;
    // 定义马的位置和步数的列表
    private static LinkedList<int[]> horses = new LinkedList<>();
    // 定义马能走的八个方向
    private static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        m = Integer.parseInt(split[0]);
        n = Integer.parseInt(split[1]);
        array = new int[m][n];

        for (int i = 0; i < m; i++) {
            String[] split1 = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (!".".equals(split1[j])) {
                    int[] ints = new int[3];
                    ints[0] = i;
                    ints[1] = j;
                    ints[2] = Integer.parseInt(split1[j]);
                    horses.add(ints);
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                int sum = 0;
                for (int[] horse : horses) {
                    LinkedList<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{horse[0], horse[1], 0});
                    boolean[][] visits = new boolean[m][n];
                    boolean found = false;
                    while (!queue.isEmpty() && flag) {
                        int[] poll = queue.poll();
                        if (poll[0] == i && poll[1] == j) {
                            sum += poll[2];
                            found = true;
                            break;
                        }
                        for (int k = 0; k < 8; k++) {
                            int x = dir[k][0] + poll[0];
                            int y = dir[k][1] + poll[1];
                            if (x >= 0 && y >= 0 && x < m && y < n && !visits[x][y]) {
                                visits[x][y] = true;
                                queue.offer(new int[]{x, y, poll[2] + 1});
                            }
                        }
                    }
                    if (!found) {
                        flag = false;
                    }
                }
                if (flag) {
                    min = Math.min(min, sum);
                }
            }
        }
        // 如果最小步数为最大值，则返回0，否则返回最小步数
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
