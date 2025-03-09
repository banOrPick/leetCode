import java.util.Scanner;

public class MELON的难题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stones = new int[n];

        for (int i = 0; i < n; i++) {
            stones[i] = sc.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += stones[i];
        }
        if (sum % 2 != 0) {
            System.out.println("-1");
        } else {
            int weight = sum / 2;
            int[] weights = new int[weight + 1];
            for (int i = 1; i <= weight; i++) {
                weights[i] = n;
            }
            for (int i = 1; i < n; i++) {
                int tmp = stones[i - 1];
                for (int j = weight; j >= tmp; j--) {
                    weights[j] = Math.min(weights[j], weights[j - tmp] + 1);
                }
            }
            if (weights[weight] == 0) {
                System.out.println(-1);
            } else {
                System.out.println(weights[weight]);
            }
        }
    }
}
