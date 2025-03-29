import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 每日温度739 {
    public static void main(String[] args) {
        dailyTemperatures(new int[]{73,74,75,71,69,72,76,73});
    }

    //暴力破解
//    public static int[] dailyTemperatures(int[] temperatures) {
//        int[] res = new int[temperatures.length];
//        for (int i = 0; i < temperatures.length; i++) {
//            for (int j = i + 1; j < temperatures.length; j++) {
//                if (temperatures[j] > temperatures[i]) {
//                    res[i]=j-i;
//                    break;
//                }
//            }
//        }
//        return res;
//    }
    public static int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            int index = temperatures[i];
            while (!stack.isEmpty() && index > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return res;
    }
}
