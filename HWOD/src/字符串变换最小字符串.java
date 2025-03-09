import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 字符串变换最小字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputList = input.split("");
        List<Character> list = Arrays.stream(inputList).map(a -> a.charAt(0)).sorted().collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != inputList[i].charAt(i)) {
                char c = list.get(i);
                char tmpChar = inputList[i].charAt(i);
                int swapIndex = 0;
                for (int j = i + 1; j < inputList.length; j++) {
                    if (inputList[j].charAt(0) == c) {
                        swapIndex = j;
                    }

                }
                inputList[i] = String.valueOf(c);
                inputList[swapIndex] = String.valueOf(tmpChar);

            }
            break;
        }
        StringBuilder builder = new StringBuilder();
        Arrays.stream(inputList).forEach(builder::append);
        System.out.println(builder.toString());
    }
}
