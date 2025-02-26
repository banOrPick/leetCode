import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 分割数组的最大差值 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(m -> Integer.parseInt(m)).collect(Collectors.toList());
        int maxResult = 0;
        List<Integer> leftList;
        List<Integer> rightList;
        for (int i = 1; i < n; i++) {
            leftList = nums.subList(0, i);
            rightList = nums.subList(i, n);
            int leftSumValue = leftList.stream().mapToInt(Integer::intValue).sum();
            int rightSumValue = rightList.stream().mapToInt(Integer::intValue).sum();
            maxResult = Math.max(maxResult, Math.abs(leftSumValue - rightSumValue));
        }
        System.out.println(maxResult);


    }
}
