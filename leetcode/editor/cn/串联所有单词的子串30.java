import org.junit.Test;

import java.util.*;

public class 串联所有单词的子串30 {
    @Test
    public void test() {
findSubstring("foobarfoobar",new String[]{"foo","bar"});
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        // 统计 words 中「每个目标单词」的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String str : words) map.put(str, map.getOrDefault(str, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            // 构建一个当前子串对应的哈希表，统计当前子串中「每个目标单词」的出现次数
            Map<String, Integer> temp = new HashMap<>();
            // 滑动窗口的大小固定是 m * w，每次将下一个单词添加进 temp，上一个单词移出 temp
            for (int j = i; j + w <= n; j += w) {
                String cur = s.substring(j, j + w);
                temp.put(cur, temp.getOrDefault(cur, 0) + 1);
                if (j >= i + (m * w)) {
                    int idx = j - m * w;
                    String prev = s.substring(idx, idx + w);
                    if (temp.get(prev) == 1) temp.remove(prev);
                    else temp.put(prev, temp.get(prev) - 1);
                    if (!temp.getOrDefault(prev, 0).equals(map.getOrDefault(prev, 0))) continue;
                }
                if (!temp.getOrDefault(cur, 0).equals(map.getOrDefault(cur, 0))) continue;
                // 上面两个 continue 可以减少 map 之间的 equals 操作
                if (temp.equals(map)) ans.add(j - (m - 1) * w);
            }
        }
        return ans;
    }
    //dfs解法，会超时
//    public List<Integer> findSubstring(String s, String[] words) {
//        List<Integer> list = new ArrayList<>();
//        int max=words.length;
//        int[] nums=new int[max];
//        for (int i = 0; i <max; i++) {
//            nums[i]=i;
//        }
//        boolean[] visited = new boolean[words.length];
//        List<List<Integer>> resultList = new ArrayList<>();
//        Set<String> set = new HashSet<>();
//        List<Integer> result = new ArrayList<>();
//        int dept = 0;
//        dfs(visited, nums, resultList, result, dept);
//        for (int i = 0; i < resultList.size(); i++) {
//            List<Integer> temp = resultList.get(i);
//            StringBuffer stringBuffer = new StringBuffer();
//            for (int j = 0; j < temp.size(); j++) {
//                stringBuffer.append(words[temp.get(j)]);
//            }
//            set.add(stringBuffer.toString());
//
//        }
//        set.forEach(s1 -> {
//            int start = 0;
//            while (s.indexOf(s1, start) != -1) {
//                list.add(s.indexOf(s1, start));
//                start = s.indexOf(s1, start) + 1;
//            }
//        });
//        return list;
//
//    }
//
//    private static void dfs(boolean[] visited, int[] nums, List<List<Integer>> resultList, List<Integer> result, int dept) {
//        if (dept == nums.length) {
//            resultList.add(new ArrayList<>(result));
////            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (visited[i]) {
//                continue;
//            }
//            visited[i] = true;
//            result.add(nums[i]);
//            dfs(visited, nums, resultList, result, dept + 1);
//            visited[i] = false;
//            result.remove(result.size() - 1);
//        }
//    }
}
