import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 最左侧冗余覆盖子串 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        int left = 0, right = left + k + s1.length();
        int result = -1;
        for (; right < s2.length(); left++) {
            right = left + k + s1.length();
            if (isMaxString(left, right, s2, s1)) {
                result = left;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean isMaxString(int left, int right, String s2, String s1) {
        boolean flag = true;
        Map<Character, Integer> s1map = getResultMap(s1);
//        Map<Character, Integer> s2map = getResultMap(s2);
        Map<Character, Integer> s3map = getResultMap(s2.substring(left, right));
        if (s3map.keySet().containsAll(s1map.keySet())) {
            for (Character c : s1map.keySet()) {
                if (s3map.get(c) >= s1map.get(c)) {
                    flag = false;
                    return !flag;
                }
            }
        }


        return !flag;
    }

    private static Map<Character, Integer> getResultMap(String s1) {
        Map<Character, Integer> s1map = new HashMap<Character, Integer>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1map.containsKey(s1.charAt(i))) {
                Integer cishu = s1map.get(s1.charAt(i));
                s1map.put(s1.charAt(i), cishu + 1);
            } else {
                s1map.put(s1.charAt(i), 1);
            }

        }
        return s1map;
    }
}
