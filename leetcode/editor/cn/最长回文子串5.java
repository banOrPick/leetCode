public class 最长回文子串5 {
    public String longestPalindrome(String s) {
        String result = "";
        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isTrue(substring) && substring.length() > result.length()) {
                    result = substring;
                }
            }
        }


        return result;
    }

    private boolean isTrue(String substring) {
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
