import java.util.LinkedList;

public class 腐烂的橘子994 {
    public static void main(String[] args) {
//        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(orangesRotting(new int[][]{{1},{2}}));
    }

    public  static int orangesRotting(int[][] grid) {
        int count=0;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    list.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        int res = 0;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        res=getGanRan(grid, dirs, list, res,count);
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return res;

    }

    public static int getGanRan(int[][] grid, int[][] dirs, LinkedList<int[]> list, int res,int count) {
        if (list.isEmpty()) {
            return res-1;
        }
        LinkedList<int[]> newList = new LinkedList<>();
        res++;
        while (!list.isEmpty()) {
            int[] pop = list.pop();
            int x = pop[0], y = pop[1];
            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                    count--;
                    grid[newX][newY] = 2;
                    newList.push(new int[]{newX, newY});
                }
            }
        }
        return getGanRan(grid, dirs, newList, res,count);
    }
}
