import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 组合77 {

    @Test
            public void test() {
        combine(4,2);
    }
    List<List<Integer>> result=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        boolean[] visit=new boolean[n];
        dfs(n,k,0);

        return result;

    }

    private void dfs(int n, int k,int depth) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = depth; i < n; i++) {
                temp.add(i+1);
                dfs(n,k,i+1);
                temp.remove(temp.size()-1);

        }

    }
}
