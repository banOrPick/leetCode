import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 导师请吃火锅 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[2];
            tmp[0] = scanner.nextInt();
            tmp[1] = tmp[0] + scanner.nextInt();
            list.add(tmp);
        }
        list.sort(Comparator.comparingInt(a -> a[1]));
        int lastEnd =  list.get(0)[1];
        int sum = 1;
        for (int i = 1; i < list.size(); i++) {
            int start = list.get(i)[0];
            int end = list.get(i)[1];
            if (start >= lastEnd + m) {
                sum++;
                lastEnd = end;
            }
        }
        System.out.println(sum);

    }


//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);  // 创建Scanner对象用于获取用户输入
//        int n = scanner.nextInt();  // 读取菜的个数n
//        int m = scanner.nextInt();  // 读取手速m，即每次捞菜后必须等待的时间
//
//        List<Integer> times = new ArrayList<>();  // 用于存储每道菜煮熟的时间点
//        for (int i = 0; i < n; i++) {
//            int start = scanner.nextInt();  // 读取开始时间
//            int duration = scanner.nextInt();  // 读取持续时间
//            times.add(start + duration);  // 计算并存储每道菜的煮熟时间
//        }
//
//        int[] nums = new int[getMax(times) + 1];  // 创建一个数组，用于标记每个时间点是否有菜
//        for (int t : times) {
//            nums[t] = 1;  // 将有菜的时间点标记为1
//        }
//
//        List<Integer> dp = new ArrayList<>();  // 用于存储不同策略下吃到的菜的数量
//
//        dfs(1, new ArrayList<>(), nums, dp, m);  // 从时间点1开始，使用深度优先搜索
//
//        int max = 0;
//        for (int count : dp) {
//            max = Math.max(max, count);  // 找出能吃到最多菜的策略
//        }
//
//        System.out.println(max);  // 输出最多能吃到的菜的数量
//    }

//    private static void dfs(int t, List<Integer> data, int[] nums, List<Integer> dp, int m) {
//        if (t >= nums.length) {  // 如果时间点超出范围，计算当前策略的总菜数
//            int sum = 0;
//            for (int count : data) {
//                sum += count;  // 统计吃到的菜的总数
//            }
//            dp.add(sum);  // 将结果加入dp列表
//            return;
//        }
//
//        if (nums[t] == 1) {  // 当前时间点有菜
//            List<Integer> newData = new ArrayList<>(data);  // 创建一个新的策略列表
//            newData.add(1);  // 添加吃到的菜
//            dfs(t + m, newData, nums, dp, m);  // 选择捞菜后跳过m个时间点继续搜索
//            dfs(t + 1, data, nums, dp, m);  // 不捞菜，继续搜索下一个时间点
//        } else {
//            dfs(t + 1, data, nums, dp, m);  // 如果当前时间点没有菜，直接搜索下一个时间点
//        }
//    }
//
//    private static int getMax(List<Integer> list) {
//        int max = Integer.MIN_VALUE;
//        for (int num : list) {
//            max = Math.max(max, num);  // 找出列表中的最大值
//        }
//        return max;
//    }
}
