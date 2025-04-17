import com.sun.xml.internal.ws.util.StringUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class 反转字符串中的单词151 {
    @Test
    public void test() {
        System.out.println(reverseWords("a good   example"));
    }
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        List<String> list = Arrays.asList(split);
        List<String> list1 = list.stream().map(String::trim).filter(trim ->
                !trim.isEmpty()
        ).collect(Collectors.toList());
        Collections.reverse(list1);
        return String.join(" ", list1).trim();
    }
}
