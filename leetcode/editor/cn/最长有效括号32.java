import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 最长有效括号32 {
    @Test
    public void test() {
        System.out.println(longestValidParentheses(")()())"));
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        char[] charArray = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(') {
                stack.push(i);
            }else{
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                }else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;

    }
}
