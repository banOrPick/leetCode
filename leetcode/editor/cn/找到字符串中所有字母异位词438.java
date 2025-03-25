import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 找到字符串中所有字母异位词438 {
    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);
        String pString = new String(pCharArray);
        List<Integer> list = new ArrayList<>();
        int length = p.length();
        for (int i = 0; i <=s.length() - length; i++) {
            int right = i + length;
            String substring = s.substring(i, right);
            char[] charArray = substring.toCharArray();
            Arrays.sort(charArray);
            if (pString.equals(new String(charArray))) {
                list.add(i);
            }
        }
        return list;
    }
}
