import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 服务器广播需要广播的服务器数量 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strings = scanner.nextLine().split(" ");
        int n = strings.length;
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            arr[0][i] = Integer.parseInt(strings[i]);
        }
        // 读取剩下的 n-1 行，并逐行存入 arr 矩阵
        for (int i = 1; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        int result = 0;// 计数器，记录连通分量的数量（即需要广播的服务器数量）
        // 使用队列来记录访问过的节点（服务器）
        List<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!queue.contains(i)) {
                dfs(arr, queue, i);
                result++;
            }

        }
        System.out.println(result);


    }

    private static void dfs(int[][] arr, List<Integer> queue, int index) {
        queue.add(index);
        for (int i = index+1; i < arr.length; i++) {
            if (arr[index][i]==1&&!queue.contains(i)) {
                dfs(arr, queue, i);
            }
        }
    }

/**
 1 0 0 0
 0 1 0 1
 0 0 1 0
 0 1 0 1


 1 0 0 0
 0 1 0 0
 0 0 1 0
 0 0 0 1
 */

}
