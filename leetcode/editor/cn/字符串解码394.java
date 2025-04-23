import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class 字符串解码394 {
    @Test
    public void test() {
        System.out.println(decodeString("3[a]2[bc]"));
    }

    //递归解法
    public String decodeString(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '[') {
                int start = i -1;
                while(start>=0&&Character.isDigit(s.charAt(start))) {
                    start--;
                }
                int digit = Integer.parseInt(s.substring(start+1, i));
                for (int j = i + 1; j < s.length(); j++) {
                    if (s.charAt(j) == ']') {
                        String temp = s.substring(i+1, j);
                        String pre = s.substring(0,start+1);
                        String  last= s.substring(j+1);
                        StringBuilder result = new StringBuilder();
                        result.append(pre);
                        for (int k = 0; k < digit; k++) {
                            result.append(temp);
                        }
                        result.append(last);
                        return decodeString(result.toString());
                    }
                }
            }
        }
        return s;
    }
}
