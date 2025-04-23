import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 约瑟夫环 {
    @Test
    public void test() {
        Joseph_circle(new int[]{0,3,1,2,4}, 3);
    }

    public int[] Joseph_circle(int[] nums, int m) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int[] result = new int[nums.length];
        result = remove(list, m, 0, result);
        return result;

    }

    private int[] remove(List<Integer> list, int m, int startIndex, int[] result) {
        if (list.size() == 1) {
            result[result.length-1] = list.get(0);
            return result;
        }
        int remove = (m+startIndex-1) % list.size();

        result[result.length - list.size()] = list.get(remove);
        list.remove(remove);
        return remove(list, m, remove, result);

    }
}
