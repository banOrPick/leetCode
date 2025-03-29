import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class 柱状图中最大的矩形84 {
    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }

//    public static int largestRectangleArea(int[] heights) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < heights.length; i++) {
//            set.add(heights[i]);
//        }
//        if (heights.length == 0) {
//            return 0;
//        }
//        if (heights.length == 1) {
//            return heights[0];
//        }
//        int maxArea = 0;
//        for(int height: set) {
//            int width = 0;
//            for (int j = 0; j < heights.length; j++) {
//                if (heights[j] >= height) {
//                    width++;
//                    maxArea = Math.max(maxArea, width * height);
//                } else {
//                    width = 0;
//                }
//            }
//        }
//        return maxArea;
//    }

    //单挑栈
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> mono_stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        mono_stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                mono_stack.pop();
            }
            right[i] = (mono_stack.isEmpty() ? n : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }


}
