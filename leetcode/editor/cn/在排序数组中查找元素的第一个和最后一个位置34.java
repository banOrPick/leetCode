import org.junit.Test;

public class 在排序数组中查找元素的第一个和最后一个位置34 {

    @Test
    public void test() {
        System.out.println(
                searchRange(new int[]{1}, 0)
        );

    }
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearch(nums, target, true);
        int rightIdx = binarySearch(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    public int binarySearch(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
//    public int[] searchRange(int[] nums, int target) {
//        int[] result = new int[2];
//        result[0] = -1;
//        result[1] = -1;
//        if (nums.length == 0) return result;
//        if (nums.length == 1){
//            if (nums[0] == target){
//                result[0] = 0;
//                result[1] = 0;
//            }
//            return result;
//        }
//        int low = 0, high = nums.length - 1;
//        while (low <= high) {
//            int mid = (high - low + 1) / 2 + low;
//            if (nums[mid] <= target) {
//                low = mid + 1;
//            }
//            if (nums[mid] > target) {
//                high = mid - 1;
//            }
//        }
//        if (nums[high] == target) {
//            result[1] = high;
//        }
//
//        int start = 0, end = nums.length - 1;
//        while (start <= end) {
//            int mid = (end - start + 1) / 2 + start;
//            if (nums[mid] >= target) {
//                end = mid - 1;
//            }
//            if (nums[mid] < target) {
//                start = mid + 1;
//            }
//
//        }
//        if (nums[start] == target) {
//            result[0] = start;
//        }
//
//        return result;
//
//    }
}
