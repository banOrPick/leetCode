import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 最大报酬 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 工作时长
        int n = scanner.nextInt(); // 工作数量
        int[][] works = new int[n][2];
        for (int i = 0; i < n; i++) {
            works[i][0] = scanner.nextInt();
            works[i][1] = scanner.nextInt();
        }
        int minTime=Integer.MAX_VALUE;
        for (int[] work:works){
            minTime = Math.min(minTime,work[0]);
        }
        int[][] dp = new int[n + 1][T + 1]; // 动态规划数组
        for (int i = 1; i <= n; i++) {
            for (int j = minTime; j <= T; j++) {
                int last = dp[i - 1][j]; // 不选当前工作
                int current = works[i - 1][0] > j ? 0 : works[i - 1][1] + dp[i - 1][j - works[i - 1][0]]; // 选当前工作
                dp[i][j] = Math.max(last, current); // 取最大值
            }
        }
        System.out.print(dp[n][T]);
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
