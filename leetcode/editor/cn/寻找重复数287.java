import org.junit.Test;

import java.util.HashSet;

public class 寻找重复数287 {
    @Test
    public void test() {
        findDuplicate(new int[]{1, 3, 4, 2, 4});
    }
//    public int findDuplicate(int[] nums) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int num : nums) {
//            if (set.contains(num)) {
//                return num;
//            } else {
//                set.add(num);
//            }
//        }
//        return -1;
//    }

    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
