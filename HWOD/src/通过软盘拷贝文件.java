import java.util.Scanner;

public class 通过软盘拷贝文件 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] files = new int[n];
        int total = 1474560 / 512;
        for (int i = 0; i < n; i++) {
            int input = scanner.nextInt();
            files[i] = input;
        }
        int[] dp = new int[total + 1];
        for (int i = 0; i < n; i++) {
            int input = files[i];
            int temp;
            if (input % 512 != 0) {
                temp = input / 512 + 1;
            } else {
                temp = input / 512;
            }
            for (int j = total; j >=0; j--) {
                if (j < temp) {
                    continue;
                } else {
                    dp[j] = Math.max(dp[j], dp[j - temp] + input);
                }
            }
        }
        System.out.println(dp[total]);
    }
}
