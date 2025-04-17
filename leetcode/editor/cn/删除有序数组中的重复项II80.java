import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 删除有序数组中的重复项II80 {
    public int removeDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int result = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                if (integer == 2) {
                    result--;
                } else {
                    list.add(num);
                    map.put(num, integer + 1);
                }
            } else {
                list.add(num);
                map.put(num, 1);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return result;

    }
}
