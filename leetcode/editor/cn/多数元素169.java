import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class 多数元素169 {
    //hash
//    public int majorityElement(int[] nums) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//        }
//        AtomicInteger result = new AtomicInteger();
//        map.forEach((k, v) -> {
//            if (map.get(k) > nums.length / 2) {
//                result.set(k);
//            }
//        });
//        return result.get();
//    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];

    }


}
