public class 跳跃游戏55 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,0,8,2,0,0,1};
        canJump(nums);
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0 && nums.length > 1) return false;
        int[] dp = new int[nums.length];
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(nums[i] + i,max);
            dp[i] = max;
        }
        for (int i = 0; i < dp.length; i++) {
            if (i >= dp[i]) {
                return false;
            }
            if (dp[i] >= nums.length-1) return true;
        }
        return false;
    }
}
