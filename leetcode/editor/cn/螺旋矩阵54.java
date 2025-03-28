import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵54 {
    public static void main(String[] args) {
//        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
//        int[][] matrix = new int[][]{{1}};
        int[][] matrix = new int[][]{{1, 2}, {3, 4}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] directions = new int[4][2];
        if (n > 1) {
            directions[0] = new int[]{0, 1};
            directions[2] = new int[]{0, -1};
        }
        if (m > 1) {
            directions[1] = new int[]{1, 0};
            directions[3] = new int[]{-1, 0};
        }
        boolean[][] visited = new boolean[m][n];
        int startI = 0, startJ = 0;
        int dirI = 0;
        int[] tmpDir = directions[dirI];
        List<Integer> result = new ArrayList<>();
        visited[startI][startJ] = true;
        int size = 0;
        while (size < m * n) {
            result.add(matrix[startI][startJ]);
            size++;
            visited[startI][startJ] = true;
            startI = startI + tmpDir[0];
            startJ = startJ + tmpDir[1];
            if (startI < 0 || startI >= m || startJ < 0 || startJ >= n || visited[startI][startJ]) {
                startI = startI - tmpDir[0];
                startJ = startJ - tmpDir[1];
                dirI++;
                if (dirI == directions.length) {
                    dirI = 0;
                }
                tmpDir = directions[dirI];
                startI = startI + tmpDir[0];
                startJ = startJ + tmpDir[1];
            }

        }
        return result;
    }
}
