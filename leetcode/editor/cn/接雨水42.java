public class 接雨水42 {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{2,0,2}));
    }

    public static int trap(int[] height) {
        int n = height.length;
        if (n == 0) {
            return 0;
        }

        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return ans;
    }


//    public static int trap(int[] height) {
//        int result = 0;
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < height.length; i++) {
//            max = Math.max(max, height[i]);
//        }
//        for (int i = 1; i <= max; i++) {
//            int left = 0, right = height.length - 1;
//            int tmp = i - 1;
//            while (height[left] <= tmp&&left<right) {
//                left++;
//            }
//            while (height[right] <= tmp&&left<right) {
//                right--;
//            }
//            while (left < right ) {
//                left++;
//                if (height[left] <= tmp) {
//                    result++;
//                }
//            }
//        }
//        return result;
//    }
}
