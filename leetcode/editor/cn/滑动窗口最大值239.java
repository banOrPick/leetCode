import java.util.*;

public class 滑动窗口最大值239 {

    public static void main(String[] args) {
        int[] a = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(maxSlidingWindow(a, k));
    }

//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int[] res = new int[nums.length - k + 1];
//        int left = 0;
//        int right = left + k;
//        while (left <= nums.length - k) {
//
//            res[left] = Integer.MIN_VALUE;
//            for (int i = left; i < right; i++) {
//                res[left] = Math.max(res[left], nums[i]);
//            }
//            left++;
//            right = left + k;
//
//        }
//        return res;
//    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) ->
                pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]
        );
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
