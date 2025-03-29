import java.util.Arrays;

public class 数组中的第K个最大元素215 {
    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
