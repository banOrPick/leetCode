import org.junit.Test;

public class 长度最小的子数组209 {
    @Test
    public void test() {
        minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3});
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        int right = 0;

        while (right < nums.length ) {
            sum += nums[right];
            while (target <= sum) {
                min = Math.min(min, right - left+1);
                sum -= nums[left];
                left++;


            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
