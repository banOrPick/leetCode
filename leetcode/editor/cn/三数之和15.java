import java.util.*;

public class 三数之和15 {
    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4});

    }

    public static List<List<Integer>> threeSum(int[] nums) {


        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = nums.length - 1;
            if (left >= right) {
                break;
            }

            getResult(res, left, right, i, nums);

        }
        return res;
    }

    private static void getResult(List<List<Integer>> res, int left, int right, int index, int[] nums) {
        while (left < right) {
            int tmp = nums[left];
            if (nums[left] + nums[right] + nums[index] == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[left]);
                list.add(nums[right]);
                list.add(nums[index]);
                res.add(list);
            }
            if (nums[left] + nums[right] + nums[index] <= 0) {
                while (nums[left] == tmp && left < right) {
                    left++;
                }
            } else {
                right--;
            }

        }
    }
}
