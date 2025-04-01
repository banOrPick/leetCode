import org.junit.Test;

public class 单词搜索79 {
    String word = "";
    char[][] board;
    boolean[][] visited;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean result = false;

    @Test
    public void test() {
//        exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED");
        exist(new char[][]{{'a'}, {'a'}}, "aa");
    }

    public boolean exist(char[][] board, String word) {
        this.word = word;
        this.board = board;
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = true;
                dfs(i, j, 0);
                visited[i][j] = false;
            }
        }

        return result;
    }

    private void dfs(int i, int j, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        if (board[i][j] == word.charAt(index)) {
            if (index == word.length()-1) {
                result = true;
                return;
            }
            for (int k = 0; k < 4; k++) {
                int x = i + dirs[k][0];
                int y = j + dirs[k][1];
                if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
                    visited[x][y] = true;
                    dfs(x, y, index + 1);
                    visited[x][y] = false;
                }
            }
        }
    }
}
