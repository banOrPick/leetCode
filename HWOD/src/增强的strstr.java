import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 增强的strstr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String input2 = sc.nextLine();
        String prefix = input2.substring(0, input2.indexOf("["));
        String[] str = input2.substring(input2.indexOf("[") + 1, input2.indexOf("]")).split("");
        List<String> strList = new ArrayList<>();
        Arrays.asList(str).forEach(x -> strList.add(prefix + x));
        for (int i = 0; i < input.length(); i++) {
            String needFind = input.substring(i, i + prefix.length() + 1);
            if (strList.contains(needFind)) {
                System.out.println(i);
                break;
            }
        }

    }
}
