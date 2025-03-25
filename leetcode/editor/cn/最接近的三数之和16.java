import java.util.Arrays;

public class 最接近的三数之和16 {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1, 2, 1, -4}, 1));

    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            if (left >= right) {
                break;
            }
            while (left < right) {
                int tmp = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum - target) > Math.abs(tmp - target)) {
                    sum = tmp;
                }
                if (nums[i] + nums[left] + nums[right] < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return sum;
    }
}
