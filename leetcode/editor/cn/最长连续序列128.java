import java.util.*;
import java.util.stream.Collectors;

public class 最长连续序列128 {
    public static void main(String[] args) {
        int[] test=new int[]{0};
        System.out.println(longestConsecutive(test));
    }
    public static int longestConsecutive(int[] nums) {

        Set<Integer> num_set = new TreeSet<>();
        for (int num : nums) {
            num_set.add(num);
        }
        if (num_set.isEmpty()) {
            return 0;
        }
        if (num_set.size() == 1) {
            return 1;
        }
        List<Integer> list = num_set.stream().sorted().collect(Collectors.toList());
        int left = 0, right = 1;
        int max = 0;
        for (; left < list.size(); right++) {

            Integer tmp = list.get(right);
            if (tmp == list.get(left) + right-left) {
                max = Math.max(max, right - left+1);
                if (right==list.size()-1) {
                    return max;
                }
            } else {
                if (right>=list.size()-1) {
                    break;
                }
                left=right;
            }
        }
        return max;

    }
}
