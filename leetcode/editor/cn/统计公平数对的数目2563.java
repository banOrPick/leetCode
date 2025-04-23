import java.util.Arrays;

public class 统计公平数对的数目2563 {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((nums[j] + nums[i]) <= upper && (nums[j] + nums[i]) >= lower) {
                    count++;
                }
            }
        }
        return count;
    }


}
