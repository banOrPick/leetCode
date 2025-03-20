import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.*;

public class 跳马 {


    static class Horse {
        int x, y, maxSteps;

        public Horse(int x, int y, int maxSteps) {
            this.x = x;
            this.y = y;
            this.maxSteps = maxSteps;
        }
    }


    // 马可以移动的八个方向
    private static final int[][] DIRECTIONS = {
            {-2, -1}, {-2, 1}, {-1, -2}, {-1, 2},
            {1, -2}, {1, 2}, {2, -1}, {2, 1}
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取棋盘的行数和列数
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine(); // 消耗掉换行符

        // 存储马的位置和最大步数
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (!".".equals(line[j])) {
                    horses.add(new Horse(i, j, Integer.parseInt(line[j])));
                }
            }
        }
        scanner.close();

        // 初始化最小步数为最大值
        int minSteps = Integer.MAX_VALUE;

        // 遍历棋盘上的每个位置
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int steps = 0;
                boolean possible = true;

                // 遍历每个马
                for (Horse horse : horses) {
                    int horseSteps = bfs(horse, i, j, m, n);
                    if (horseSteps == -1) {
                        possible = false;
                        break;
                    }
                    steps += horseSteps;
                }

                // 如果所有马都能到达当前位置，则更新最小步数
                if (possible) {
                    minSteps = Math.min(minSteps, steps);
                }
            }
        }

        // 如果最小步数为最大值，则返回0，否则返回最小步数
        System.out.println(minSteps == Integer.MAX_VALUE ? 0 : minSteps);
    }

    // 广度优先搜索方法，计算马从当前位置到目标位置的最小步数
    private static int bfs(Horse horse, int targetX, int targetY, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        queue.offer(new int[]{horse.x, horse.y, 0});
        visited[horse.x][horse.y] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int steps = current[2];

            if (x == targetX && y == targetY) {
                return steps;
            }

            if (steps >= horse.maxSteps) {
                continue;
            }

            // 遍历马可以移动的八个方向
            for (int[] dir : DIRECTIONS) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY, steps + 1});
                    visited[newX][newY] = true;
                }
            }
        }
        return -1;
    }


//    public static int m;
//    public static int n;
//    public static int[][] array;
//    // 定义马的位置和步数的列表
//    private static LinkedList<int[]> horses = new LinkedList<>();
//    // 定义马能走的八个方向
//    private static int[][] dir = {{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String[] split = scanner.nextLine().split(" ");
//        m = Integer.parseInt(split[0]);
//        n = Integer.parseInt(split[1]);
//        array = new int[m][n];
//
//        for (int i = 0; i < m; i++) {
//            String[] split1 = scanner.nextLine().split(" ");
//            for (int j = 0; j < n; j++) {
//                if (!".".equals(split1[j])) {
//                    int[] ints = new int[3];
//                    ints[0] = i;
//                    ints[1] = j;
//                    ints[2] = Integer.parseInt(split1[j]);
//                    horses.add(ints);
//                }
//            }
//        }
//        System.out.println(bfs());
//    }
//
//    private static int bfs() {
//        int min = Integer.MAX_VALUE;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                boolean flag = true;
//                int sum = 0;
//                for (int[] horse : horses) {
//                    LinkedList<int[]> queue = new LinkedList<>();
//                    queue.offer(new int[]{horse[0], horse[1], 0});
//                    boolean[][] visits = new boolean[m][n];
//                    boolean found = false;
//                    while (!queue.isEmpty() && flag) {
//                        int[] poll = queue.poll();
//                        if (poll[0] == i && poll[1] == j) {
//                            sum += poll[2];
//                            found = true;
//                            break;
//                        }
//                        for (int k = 0; k < 8; k++) {
//                            int x = dir[k][0] + poll[0];
//                            int y = dir[k][1] + poll[1];
//                            if (x >= 0 && y >= 0 && x < m && y < n && !visits[x][y]) {
//                                visits[x][y] = true;
//                                queue.offer(new int[]{x, y, poll[2] + 1});
//                            }
//                        }
//                    }
//                    if (!found) {
//                        flag = false;
//                    }
//                }
//                if (flag) {
//                    min = Math.min(min, sum);
//                }
//            }
//        }
//        // 如果最小步数为最大值，则返回0，否则返回最小步数
//        return min == Integer.MAX_VALUE ? 0 : min;
//    }
}
