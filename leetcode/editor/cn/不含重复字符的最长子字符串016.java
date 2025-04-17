import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 不含重复字符的最长子字符串016 {
    @Test
    public void test() {
        System.out.println(lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Queue<Character> stack = new LinkedList<>();
        int left = 0, right = 1;
        int max = 0;
        stack.offer(s.charAt(0));
        while (left < s.length()) {
            while (stack.contains(s.charAt(right))) {
                left++;
                stack.poll();
            }
            stack.offer(s.charAt(right));
            max = Math.max(max, right - left + 1);
            if (right < s.length() - 1) {
                right++;
            }
        }

        return max;
    }
}
