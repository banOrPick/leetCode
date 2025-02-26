import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 高矮个子排队 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        String[] strings = inputStr.split(" ");
        List<Integer> list = Arrays.stream(strings).map(m -> Integer.parseInt(m)).collect(Collectors.toList());
        Boolean flag = true;
        for (int i = 0; i < list.size() - 1; i++) {
            Integer left = list.get(i);
            Integer right = list.get(i + 1);
            if (flag && left < right) {
                list.set(i, right);
                list.set(i + 1, left);

            }
            if (!flag && left > right) {
                list.set(i, right);
                list.set(i + 1, left);

            }
            flag = !flag;
        }
        StringBuffer result = new StringBuffer();
        list.stream().forEach(s->
            result.append(s).append(" ")
        );
        System.out.println(result.toString().trim());
    }
}
