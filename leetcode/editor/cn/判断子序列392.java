import org.junit.Test;

public class 判断子序列392 {
    @Test
    public void test() {
        isSubsequence("", "ahbgdc");
    }

    public boolean isSubsequence(String s, String t) {
        int tIndex = 0;
        int sIndex = 0;

        while (tIndex < t.length() && sIndex < s.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }


        return s.length() == sIndex;
    }
}
