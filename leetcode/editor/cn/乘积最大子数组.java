import java.util.Arrays;

public class 乘积最大子数组 {
    public static void main(String[] args) {
        maxProduct(new int[]{-3, -1, -1});
    }

    public static int maxProduct(int[] nums) {
        long maxF = nums[0], minF = nums[0];
        int ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            long mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            if(minF<-1<<31){
                minF=nums[i];
            }
            ans = Math.max((int)maxF, ans);
        }
        return ans;
    }

//    public static int maxProduct(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] >= 0) {
//                dp[i] = Math.max(nums[i] * dp[i - 1],nums[i]);
//            }else{
//                if(dp[i-1] < 0){
//                    dp[i] = nums[i] * dp[i - 1];
//                }else{
//                    dp[i]=nums[i];
//                }
//            }
//
//        }
//        Arrays.sort(dp);
//        return dp[nums.length - 1];
//    }
}
