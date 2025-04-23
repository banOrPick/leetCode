import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 最小栈155 {
    class MinStack {
        Deque<Integer> stack = new LinkedList<>();
        Deque<Integer> minStack = new LinkedList<>();

        public MinStack() {
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(Math.min(val, minStack.peek()));
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {

            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
