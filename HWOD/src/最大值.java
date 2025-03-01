import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 最大值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        list.sort((a, b) ->
            (b + a).compareTo(a + b)
        );
        StringBuffer result = new StringBuffer();
        for (String s : list) {
            result.append(s);
        }
        System.out.println(result);
    }
}
