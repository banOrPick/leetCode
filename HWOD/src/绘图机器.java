import java.util.Scanner;

public class 绘图机器 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxX = sc.nextInt();
        int result = 0;
        if (maxX == 0) {
            System.out.println(0);
            return;
        }
        int[] ints = new int[maxX];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int offsetY = sc.nextInt();
            ints[x] = offsetY;
        }
        int[] yints = new int[maxX];
        yints[0] = ints[0];
        for (int i = 1; i < maxX; i++) {
            yints[i] = ints[i] + yints[i - 1];
        }
        for (int i = 0; i < maxX; i++) {
            result = result + Math.abs(yints[i]);
        }
        System.out.println(result);

    }
}
