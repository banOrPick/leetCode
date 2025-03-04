import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
public class 最多的连续胡杨树数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> nList = new ArrayList<>();
        List<Integer> mList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nList.add(0);
        }
        int m = scanner.nextInt();
        // 根据输入，将未成活的树的位置标记为1
        for (int i = 0; i < m; i++) {
            int deadTreeIndex = scanner.nextInt();
            nList.remove(deadTreeIndex);
            nList.add(deadTreeIndex - 1, 1);
            mList.add(deadTreeIndex);
        }
        int k = scanner.nextInt();
        int sumRight = 0;
        int sumLeft = 0;
        int maxLength = 0;
        int left = 0;
        for (int right = 0; right < nList.size(); right++) {
            sumRight = nList.get(right) + sumRight;
            while (sumRight - sumLeft > k) {
                sumLeft += nList.get(left);
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);


    }
}
