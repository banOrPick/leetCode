import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 数组拼接 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Integer length = Integer.parseInt(scanner.nextLine());
        Integer n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> ints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] split = input.split(",");
            List<Integer> nums = Arrays.stream(split).map(Integer::parseInt).collect(Collectors.toList());
            ints.add(nums);
        }
        StringBuffer result = new StringBuffer();
        int i = 0;
        getResult(length, i, ints, result);
        System.out.println(result.toString().trim());
        scanner.close();

    }

    private static void getResult(int length, int i, List<List<Integer>> ints, StringBuffer result) {
        for (int j = 0; j < ints.size(); j++) {
            List<Integer> nums = ints.get(j);
            List<Integer> subNums = new ArrayList<>();
            if (i > nums.size()) {
                break;
            }
            if ((i + length) < nums.size()) {
                subNums = nums.subList(i, i + length);
            } else {
                subNums = nums.subList(i, nums.size());
                ints.remove(nums);
                j--;
            }
            subNums.stream().forEach(p -> {
                result.append(p).append(",");
            });
        }
        i = i + length;
        if (ints.size() > 0) {
            getResult(length, i, ints, result);
        }
    }
}
