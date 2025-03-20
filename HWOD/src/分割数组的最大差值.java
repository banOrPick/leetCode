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

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        // 输入数组长度
//        int length = Integer.parseInt(scanner.nextLine());
//
//        // 输入数字序列
//        long[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToLong(Long::parseLong).toArray();
//
//        // 计算前缀和
//        long[] prefixSum = new long[length];
//        prefixSum[0] = numbers[0];
//        for (int i = 1; i < length; i++) {
//            prefixSum[i] = prefixSum[i-1] + numbers[i];
//        }
//
//        // 差值的最大取值
//        long maxDifference = 0;
//
//        // 计算差值的最大取值
//        for (int i = 0; i < length - 1; i++) {
//            long leftSum = prefixSum[i];
//            long rightSum = prefixSum[length-1] - prefixSum[i];
//            long difference = Math.abs(leftSum - rightSum);
//            maxDifference = Math.max(maxDifference, difference);
//        }
//
//        // 输出差值的最大取值
//        System.out.println(maxDifference);
//    }
}
