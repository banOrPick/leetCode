import org.junit.Test;

public class 环形子数组的最大和918 {
    @Test
    public void test(){
        maxSubarraySumCircular(new int[]{5,-3,5});
    }
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int maxSum=nums[0];
        int currentMax=0;
        int minSum=nums[0];
        int currentMin=0;
        for(int num:nums){
            total+=num;
            currentMax=Math.max(currentMax+num,num);
            maxSum=Math.max(maxSum,currentMax);
            currentMin=Math.min(currentMin+num,num);
            minSum=Math.min(minSum,currentMin);
        }
        if(maxSum<0){
            return maxSum;
        }
        return Math.max(maxSum,total-minSum);


    }
}
