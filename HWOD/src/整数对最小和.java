import java.util.*;
import java.util.stream.Collectors;

public class 整数对最小和 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.nextLine();
        String input2 = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        String[] split = input1.split(" ");
        List<Integer> resultList = getIntegers(input2, split);
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += resultList.get(i);
        }
        System.out.println(result);
        scanner.close();
    }

    private static List<Integer> getIntegers(String input2, String[] split) {
        String[] split2 = input2.split(" ");
        List<Integer> resultList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 1; i < split.length; i++) {
            list1.add(Integer.parseInt(split[i]));
        }
        for (int i = 1; i < split2.length; i++) {
            list2.add(Integer.parseInt(split2[i]));
        }
        int sum = 0;
        for (Integer value : list1) {
            for (Integer integer : list2) {
                resultList.add(value + integer);
            }
        }
        return resultList.stream().sorted().collect(Collectors.toList());
    }

}

