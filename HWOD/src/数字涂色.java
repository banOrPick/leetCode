import java.util.*;
import java.util.stream.Collectors;

public class 数字涂色 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        List<Integer> nums = Arrays.stream(sc.nextLine().split(" ")).collect(Collectors.toList()).stream().map(Integer::parseInt).sorted().collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        nums.stream().forEach(num -> {
            if (result.size() == 0) {
                result.add(num);
            } else {
                boolean match = result.stream().anyMatch(r ->
                        num % r == 0
                );
                if (!match) {
                    result.add(num);
                }
            }
        });
        System.out.println(result.size());
        sc.close();
    }
}
