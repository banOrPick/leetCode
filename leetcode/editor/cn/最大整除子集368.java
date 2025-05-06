import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最大整除子集368 {

    @Test
    public void test() {
        int[] nums = { 2, 4,7,8,9,12};
        List<Integer> list = largestDivisibleSubset(nums);
        System.out.println(list);
    }
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        int[] dp = new int[n];
        int[] pre = new int[n];
        Arrays.fill(pre,-1);
        dp[0]=1;
        int maxLen=1;
        int maxIndex=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0&&dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    pre[i]=j;
                }
            }
            if(dp[i]>maxLen){
                maxLen=dp[i];
                maxIndex=i;
            }
        }
        while(maxIndex!=-1){
            list.add(nums[maxIndex]);
            maxIndex=pre[maxIndex];
        }
        return list;
    }
}
