import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class 最小覆盖子串76 {
    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }


        public static String minWindow(String s, String t) {
            Map<Character, Integer> cnt = new HashMap<>();
            for (char c : t.toCharArray()) {
                cnt.put(c, cnt.getOrDefault(c, 0) + 1);
            }
            int ans_l = -1;
            int ans_r = s.length();
            int l = 0;
            int count = cnt.size();
            for (int r = 0; r < s.length(); r++) {
                char c = s.charAt(r);
                if (cnt.containsKey(c)) {
                    cnt.put(c, cnt.get(c) - 1);
                    if (cnt.get(c) == 0) {
                        count--;
                    }
                }
                while (count == 0) {
                    if (ans_r - ans_l > r - l) {
                        ans_l = l;
                        ans_r = r;
                    }
                    char ch = s.charAt(l);
                    if (cnt.containsKey(ch)) {
                        if (cnt.get(ch) == 0) {
                            count++;
                        }
                        cnt.put(ch, cnt.get(ch) + 1);
                    }
                    l++;
                }
            }
            return ans_l == -1 ? "" : s.substring(ans_l, ans_r+1);
        }


//    public static String minWindow(String s, String t) {
//        int left = 0, right = 1, min = Integer.MAX_VALUE;
//        char[] charArrayA = s.toCharArray();
//        char[] charArrayB = t.toCharArray();
//        String result = "";
//        while (left <= charArrayA.length - charArrayB.length) {
//            String tmp1 = s.substring(left, right);
//            String tmp2 = s.substring(left, right);
//            char[] tmpCharArray = tmp1.toCharArray();
//            boolean flag = true;
//            for (int i = 0; i < charArrayB.length; i++) {
//                int index = tmp2.indexOf(String.valueOf(charArrayB[i]));
//                if (index != -1 && tmpCharArray[index] != '_') {
//                    tmpCharArray[index] = '_';
//                    tmp2 = getString(tmpCharArray);
//                } else {
//                    flag = false;
//                    break;
//                }
//            }
//            if (flag) {
//                if (min > right - left) {
//                    result = tmp1;
//                    min = right - left;
//                }
//                left++;
//            } else {
//                if (right != charArrayA.length) {
//                    right++;
//                } else {
//                    left++;
//                }
//            }
//        }
//        return result;
//    }
//
//    private static String getString(char[] tmpCharArray) {
//        StringBuffer result = new StringBuffer();
//        for (int i = 0; i < tmpCharArray.length; i++) {
//            result.append(tmpCharArray[i]);
//        }
//        return result.toString();
//    }



}
