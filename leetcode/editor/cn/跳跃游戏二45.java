public class 跳跃游戏二45 {
    public static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        System.out.println(jump(new int[]{1, 2, 3}));
    }

    public static int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
//递归
//    public static int jump(int[] nums) {
//        int currentIndex = 0;
//        int min = 0;
//        if (nums.length == 1) {
//            return 0;
//        }
//        return jump2(nums, currentIndex, min);
//    }
//
//    private static int jump2(int[] nums, int currentIndex, int min) {
//        int maxIndex = Math.min(nums[currentIndex] + currentIndex, nums.length - 1);
//        if (maxIndex >= nums.length - 1) {
//            result= Math.min(result,min+1);
//            return result;
//        }
//
//        for (int i = currentIndex+1; i <= maxIndex; i++) {
//            jump2(nums,i,min+1);
//        }
//        return result;
//    }
}
