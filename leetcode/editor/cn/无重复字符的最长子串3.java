public class 无重复字符的最长子串3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length()==1) {
            return 1;
        }
        int left = 0, right = 1;
        int max = 0;
        while (right < s.length()) {
            String tmp = s.substring(left, right);
            if (tmp.contains(String.valueOf(s.charAt(right)))) {
                left++;
            } else {
                max = Math.max(max, right - left + 1);
                right++;
            }
        }
        return max;
    }
}
