public class 移动零283 {
    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(nums);
    }

    public static void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;

            }
            right++;
        }
    }
}
