import java.util.ArrayList;
import java.util.List;

public class 全排列46 {
    public static void main(String[] args) {
        permute(new int[]{1, 2, 3});
    }

    public static List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int dept = 0;
        dfs(visited, nums, resultList, result, dept);
        return resultList;
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
