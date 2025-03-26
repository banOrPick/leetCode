public class 和为的子数组560 {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3};
        int k = 3;
        subarraySum(a, k);
    }

    public static int subarraySum(int[] nums, int k) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    result++;
                }
            }
        }
        return result;
    }
}
