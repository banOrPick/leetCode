import java.util.Arrays;

public class 寻找旋转排序数组中的最小值153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] <= nums[right]) {
               right = mid ;
            }else{
               left = mid + 1;
            }
        }
        return nums[left];
    }
}
