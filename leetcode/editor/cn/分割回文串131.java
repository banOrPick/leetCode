import java.util.ArrayList;
import java.util.List;

public class 分割回文串131 {
    public static void main(String[] args) {
        System.out.println(partition("a"));
    }

    public static List<List<String>> result = new ArrayList<List<String>>();
    public static List<String> str = new ArrayList<String>();

    public static List<List<String>> partition(String s) {
        dfs(0, s);
        return result;

    }

    public static void dfs(int i, String s) {
        if (i == s.length()) {
            result.add(new ArrayList<>(str));
        }
        for (int j = i; j < s.length(); j++) {
            if (isTrue(s.substring(i, j + 1))) {
                str.add(s.substring(i, j + 1));
                dfs(j + 1, s);
                str.remove(str.size() - 1);
            }
        }
    }

    public static boolean isTrue(String substring) {
        int left = 0;
        int right = substring.length() - 1;
        while (right > left) {
            if (substring.charAt(left) != substring.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
