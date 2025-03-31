import java.util.*;

public class 单词拆分139 {
    static class Position {
        int start;
        int end;

        public Position(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {
        System.out.println(wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

//    public static boolean wordBreak(String s, List<String> wordDict) {
//
//        List<Position> positions = new LinkedList<>();
//        for (int i = 0; i < wordDict.size(); i++) {
//            int subStart = 0;
//            while (s.substring(subStart).contains(wordDict.get(i))) {
//                int start = s.indexOf(wordDict.get(i), subStart);
//                int end = start + wordDict.get(i).length();
//                positions.add(new Position(start, end));
//                subStart++;
//            }
//
//        }
//        positions.sort((a, b) -> {
//            if (a.start == b.start) {
//                return a.end - b.end;
//            } else {
//                return a.start - b.start;
//            }
//        });
//        int currenttart = 0;
//        for (int i = 0; i < positions.size(); i++) {
//            if (positions.get(i).start == currenttart) {
//                currenttart = positions.get(i).end;
//            }
//            if (positions.get(i).start > currenttart) {
//                return false;
//            }
//        }
//        return currenttart == s.length();
//    }
}
