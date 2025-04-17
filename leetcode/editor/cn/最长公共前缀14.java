public class 最长公共前缀14 {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int max = Integer.MAX_VALUE;
        for (String str : strs) {
            max = Math.min(max, str.length());
        }
        for (int i = 0; i < max; i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (ch != strs[j].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(ch);
        }
        return result.toString();
    }
}
