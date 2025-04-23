import org.junit.Test;

public class 搜索插入位置35 {
    @Test
    public void test() {
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
    }
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return left;
    }
}
