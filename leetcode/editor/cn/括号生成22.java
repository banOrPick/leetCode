import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 括号生成22 {

    @Test
    public void test() {
        generateParenthesis(3);
    }

    List<String> result = new ArrayList<>();
    int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        char[] arr = new char[2 * n];
        dfs(0, 0, arr, 0);
        return result;
    }

    private void dfs(int left, int right, char[] arr, int index) {
        if (index == 2 * n) {
            result.add(new String(arr));
            return;
        }
        if (left < n) {
            arr[index] = '(';
            dfs(left + 1, right, arr, index + 1);
            arr[index] = ' ';
        }
        if (right < n && left > right) {
            arr[index] = ')';
            dfs(left, right + 1, arr, index + 1);
            arr[index] = ' ';
        }

    }
}
