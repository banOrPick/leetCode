import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 划分为k个相等的子集698 {
    @Test
    public void test(){
        System.out.println(canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1},4));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return dfs(visited,target,nums,k,0,0,0);


    }

    private boolean dfs(boolean[] visited, int target, int[] nums, int k,int start,int currentSum,int deep) {
        if (deep == k-1) {
            return true;
        }
        if(currentSum == target) {
            return dfs(visited,target,nums,k,0,0,deep+1);
        }
        for (int i = start; i < nums.length; i++) {
            if (!visited[i]&&currentSum + nums[i] <= target) {
                visited[i] = true;
                if (dfs(visited,target,nums,k,i+1,currentSum+nums[i],deep)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}
