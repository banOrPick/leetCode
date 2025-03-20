import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
题目描述
近些年来，我国防沙治沙取得显著成果。某沙漠新种植N棵胡杨（编号1-N），排成一排。

一个月后，有M棵胡杨未能成活。

现可补种胡杨K棵，请问如何补种（只能补种，不能新种），可以得到最多的连续胡杨树？

输入描述
N 总种植数量，1 <= N <= 100000

M 未成活胡杨数量，M 个空格分隔的数，按编号从小到大排列，1 <= M <= N

K 最多可以补种的数量，0 <= K <= M

输出描述
最多的连续胡杨棵树

示例1
输入

5
2
2 4
1

输出

3

说明

补种到2或4结果一样，最多的连续胡杨棵树都是3。

示例2
输入

10
3
2 4 7
1

输出

6

说明

种第7棵树，最多连续胡杨树棵数位6（5，6，7，8，9，10）
 */
public class 补种未成活胡杨 {
    //    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        List<Integer> nList = new ArrayList<>();
//        List<Integer> mList = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            nList.add(0);
//        }
//        int m = scanner.nextInt();
//        // 根据输入，将未成活的树的位置标记为1
//        for (int i = 0; i < m; i++) {
//            int deadTreeIndex = scanner.nextInt();
//            nList.remove(deadTreeIndex);
//            nList.add(deadTreeIndex - 1, 1);
//            mList.add(deadTreeIndex);
//        }
//        int k = scanner.nextInt();
//        int sumRight = 0;
//        int sumLeft = 0;
//        int maxLength = 0;
//        int left = 0;
//        for (int right = 0; right < nList.size(); right++) {
//            sumRight = nList.get(right) + sumRight;
//            while (sumRight - sumLeft > k) {
//                sumLeft += nList.get(left);
//                left++;
//            }
//            maxLength = Math.max(maxLength, right - left + 1);
//        }
//        System.out.println(maxLength);
//    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取输入数据
        int total = scanner.nextInt();
        int deadCount = scanner.nextInt();
        int[] treeStatus = initializeTreeStatus(total, deadCount, scanner);
        int supplementCount = scanner.nextInt();
        // 计算最大连续成活区域的长度
        int maxLength = findMaxSurvivalLength(treeStatus, supplementCount);
        System.out.println(maxLength);
        scanner.close();
    }

    // 初始化树的状态数组
    private static int[] initializeTreeStatus(int total, int deadCount, Scanner scanner) {
        int[] treeStatus = new int[total];
        for (int i = 0; i < deadCount; i++) {
            int deadTreeIndex = scanner.nextInt();
            treeStatus[deadTreeIndex - 1] = 1;
        }
        return treeStatus;
    }

    // 使用滑动窗口算法计算最大连续成活区域的长度
    private static int findMaxSurvivalLength(int[] treeStatus, int supplementCount) {
        int left = 0;
        int maxLength = 0;
        int deadTreeCountLeft = 0;
        int deadTreeCountRight = 0;
        int totalTrees = treeStatus.length;

        for (int right = 0; right < totalTrees; right++) {
            deadTreeCountRight += treeStatus[right];
            while (deadTreeCountRight - deadTreeCountLeft > supplementCount) {
                deadTreeCountLeft += treeStatus[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }


}
