import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 串联所有单词的子串30 {
    @Test
    public void test() {
findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"});
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int max=words.length;
        int[] nums=new int[max];
        for (int i = 0; i <max; i++) {
            nums[i]=i;
        }
        boolean[] visited = new boolean[words.length];
        List<List<Integer>> resultList = new ArrayList<>();
        Set<String> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        int dept = 0;
        dfs(visited, nums, resultList, result, dept);
        for (int i = 0; i < resultList.size(); i++) {
            List<Integer> temp = resultList.get(i);
            StringBuffer stringBuffer = new StringBuffer();
            for (int j = 0; j < temp.size(); j++) {
                stringBuffer.append(words[temp.get(j)]);
            }
            set.add(stringBuffer.toString());

        }
        set.forEach(s1 -> {
            if (s.contains(s1)) {
                list.add(s.indexOf(s1));
            }
        });
        return list;

    }

    private static void dfs(boolean[] visited, int[] nums, List<List<Integer>> resultList, List<Integer> result, int dept) {
        if (dept == nums.length) {
            resultList.add(new ArrayList<>(result));
//            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            result.add(nums[i]);
            dfs(visited, nums, resultList, result, dept + 1);
            visited[i] = false;
            result.remove(result.size() - 1);
        }
    }
}
