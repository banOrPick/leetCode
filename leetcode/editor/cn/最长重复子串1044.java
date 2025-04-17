import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class 最长重复子串1044 {
    @Test
    public void test() {
        longestDupSubstring("banana");
    }
    public String longestDupSubstring(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                map.put(sub, map.getOrDefault(sub, 0) + 1);
            }
        }
        List<String> list = map.entrySet().stream().filter(e -> e.getValue() >1).map(Map.Entry::getKey).sorted((a,b)->
            b.length()-a.length()
        ).collect(Collectors.toList());

        if (list.isEmpty()) {
            return "";
        }else{
            return list.get(0);
        }
    }
}
