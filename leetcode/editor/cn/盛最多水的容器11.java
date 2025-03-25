public class 盛最多水的容器11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    public static int maxArea(int[] height) {
        if(height.length==0||height.length==1) return 0;
        int left = 0, right = height.length-1, max = 0;
        while (left !=right) {
            max = Math.max(max, Math.min(height[right], height[left]) * (right - left));
            if (height[right] > height[left]) {
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
