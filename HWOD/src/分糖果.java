import java.util.Scanner;

public class 分糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        for (int i = n; i != 1; i = i / 2) {
            if (i == 3) {
                result = result + 2;
                break;
            }
            if (i % 2 != 0) {
                if ((i + 1) / 2 % 2 == 0) {
                    i = i + 1;
                    result = result + 1;
                } else {
                    i = i - 1;
                    result = result + 1;
                }
            }
            result = result + 1;
        }
        System.out.println(result);
    }
}
