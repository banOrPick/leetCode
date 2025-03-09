import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 爱吃蟠桃的孙悟空 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] split = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = split.length;
        int h = Integer.parseInt(scanner.nextLine());
        Integer maxK = Arrays.stream(split).max().getAsInt();
        if (n > h) {
            System.out.println(0);
            return;
        }
        for (int i = 1; i <= maxK; i++) {
            int temHour = 0;
            for (int j = 0; j < n; j++) {
                if (split[j] < i) {
                    temHour++;
                } else {
                    temHour = temHour + split[j] / i;
                    if (split[j] % i != 0) {
                        temHour++;
                    }
                }

            }
            if (temHour <= h) {
                System.out.println(i);
                break;
            }

        }
    }
}
