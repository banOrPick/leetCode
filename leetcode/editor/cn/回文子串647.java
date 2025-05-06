import org.junit.Test;

public class 回文子串647 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); ++i) {
            count += getCount(s, i, i);
            count += getCount(s, i, i + 1);
        }
        return count;
    }

    private static int getCount(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right <= s.length()-1 && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}
