import java.util.Scanner;

public class 水仙花数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        double start = Math.pow(10, n - 1);
        double end = Math.pow(10, n);
        int k = 0;
        double currentResult = 0;
        if(n<3||n>7){
            System.out.println(-1);
        }
        for (double i = start; i < end; i++) {
            if (isShuixianhua(i, n)) {
                currentResult = i;
                k++;
                if (k == m+1) {
                    System.out.println((int)currentResult);
                    break;
                }
            }
            if (i == end - 1) {
                System.out.println((int)currentResult * m);
            }
        }
        scanner.close();


    }

    private static boolean isShuixianhua(double i, int n) {
        int num = 0;
        String numStr = String.valueOf(i);
        for (int j = 0; j < n; j++) {
            num = (int) Math.pow(Integer.parseInt(numStr.substring(j, j + 1)), n) + num;
        }
        return num == i;
    }
}
