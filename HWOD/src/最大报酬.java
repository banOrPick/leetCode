import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 最大报酬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取工作时长 T
        int T = scanner.nextInt();
        // 读取工作数量 n
        int n = scanner.nextInt();

        // 存储每项工作的耗时和报酬
        int[][] tasks = new int[n][2];
        for (int i = 0; i < n; i++) {
            // 读取第 i 项工作的耗时
            tasks[i][0] = scanner.nextInt();
            // 读取第 i 项工作的报酬
            tasks[i][1] = scanner.nextInt();
        }

        // 创建动态规划数组 dp，dp[i][j] 表示前 i 项工作在 j 时间内的最大报酬
        int[][] dp = new int[n + 1][T + 1];

        // 动态规划过程
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= T; j++) {
                // 如果当前工作的耗时大于当前可用时间 j，则不选择该工作
                if (tasks[i - 1][0] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 选择该工作和不选择该工作的报酬取最大值
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - tasks[i - 1][0]] + tasks[i - 1][1]);
                }
            }
        }

        // 输出在指定工作时长内的最大报酬
        System.out.println(dp[n][T]);
        scanner.close();

//        Scanner scanner = new Scanner(System.in);
//        int T = scanner.nextInt(); // 工作时长
//        int n = scanner.nextInt(); // 工作数量
//        ArrayList<Work> list = new ArrayList<Work>();
//        int[][] works = new int[n][2]; // 工作清单，每个工作包含耗时和报酬
//        for (int i = 0; i < n; i++) {
//            Work work = new Work(scanner.nextInt(), scanner.nextInt());
//            list.add(work);
//        }
//        int max = 0;
//        for (int i = 0; i < n; i++) {
//            Work[] result= getMax(i, works, new Work[i]);
//            max = Math.max(, max);
//
//        }
//
//
//    }
//
//
//    static class Work {
//        int time;
//        int price;
//
//        public Work(int time, int price) {
//            this.price = price;
//            this.time = time;
//        }
//
//        public static Work[] getMax(int num, List<Work> listworks, Work[] works) {
//
//            for (int i = num; i < listworks.size(); i++) {
//                works[num - 1] = listworks.get(i - 1);
//                listworks.remove(works[num - 1]);
//                if (num > 1) {
//                    getMax(num - 1, listworks, works);
//                } else {
//                    return works;
//                }
//            }
//            return works;
//        }

    }
}
