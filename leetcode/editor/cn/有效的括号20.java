import java.util.*;

public class 有效的括号20 {
    public static void main(String[] args) {
        System.out.println(isValid("["));
    }

    public static boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            if (map.containsKey(c)) {
                stack.push(map.get(c));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if (!peek.equals(c)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
}
