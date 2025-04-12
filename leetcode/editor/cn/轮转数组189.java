import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;

public class 轮转数组189 {
//    public void rotate(int[] nums, int k) {
//        int[] temp = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int index = (i + k) % nums.length;
//            temp[index] = nums[i];
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = temp[i];
//        }
//    }
    @Test
    public void test() {
        rotate(new int[]{1,2,3,4,5,6,7},3);
    }

    public void rotate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(i)) {
                num=map.get(i);
            }
            int index = (i + k) % nums.length;
            map.put(index, nums[index]);
            nums[index] = num;

        }
    }
}
