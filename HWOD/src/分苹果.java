import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 分苹果 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        int result = 0;
        for (int i = 0; i < total; i++) {
            int a = scanner.nextInt();
            sum = sum ^ a;
            list.add(a);
            result += a;
        }

        if (sum != 0) {
            System.out.println(-1);
        } else {
            list = list.stream().sorted().collect(Collectors.toList());
            int min = list.get(0);
            result = result - min;
            System.out.println(result);
        }

    }
}


