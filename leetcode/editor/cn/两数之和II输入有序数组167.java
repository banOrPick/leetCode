import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 两数之和II输入有序数组167 {

    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], i+1);
        }
        for (int i = 0; i < numbers.length; i++) {
            int complement = target - numbers[i];
            if (map.get(complement) != null) {
                return new int[]{i+1, map.get(complement)};
            }
        }
        return null;
    }
}
