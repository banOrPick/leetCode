import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 组合总和39 {


    @Test
    public void test() {
        combinationSum(new int[]{2, 3, 5}, 8);
    }

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int sum = 0;
        dfs(0, target, sum, candidates);
        return result;
    }

    private void dfs(int i, int target, int sum, int[] candidates) {
        if (i == candidates.length) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(temp));
            return;
        }


        dfs(i + 1, target, sum, candidates);
        if (sum + candidates[i] <= target) {
            sum = sum + candidates[i];
            temp.add(candidates[i]);
            dfs(i , target, sum, candidates);
            temp.remove(temp.size() - 1);
        }

    }
}
