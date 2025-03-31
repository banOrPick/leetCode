import java.util.ArrayList;
import java.util.List;

public class 子集78 {
    public static void main(String[] args) {
        subsets(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        getList(result, 0, nums, list);


        return result;
    }

    private static void getList(List<List<Integer>> result, int i, int[] nums, List<Integer> list) {
        if (i == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        getList(result, i+1, nums, list);
        list.remove(list.size() - 1);
        getList(result, i+1, nums, list);


    }
}
