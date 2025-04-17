import org.junit.Test;

public class 找出字符串中第一个匹配项的下标 {
    @Test
    public void test() {
        strStr("a","a");
    }
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        for (int i = 0; i <= haystack.length()-n; i++) {
            if (haystack.substring(i, i+n).equals(needle)) {
                return i;
            }
        }
        return -1;

    }
}
