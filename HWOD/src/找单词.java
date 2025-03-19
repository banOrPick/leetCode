import java.util.Scanner;

public class 找单词 {
    public static String[] input;
    public static int n;
    public static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine());
        char[][] array = new char[n][n];

        for (int i = 0; i < n; i++) {
            String[] split = sc.nextLine().split(",");
            for (int j = 0; j < n; j++) {
                array[i][j] = split[j].charAt(0);

            }
        }
        input = sc.nextLine().split("");
        boolean[][] visit = new boolean[n][n];
        StringBuilder result = new StringBuilder();
        int i = 0;
        int j = 0;
        char current = input[0].charAt(0);
        boolean flag = true;
        for (; i < n && flag; i++) {
            for (; j < n; j++) {
                if (array[i][j] == current) {
                    visit[i][j] = true;
                    result.append(i).append(",").append(j).append(",");
                    if (dfs(1, array, visit, result, i, j)) {
                        flag = false;
                        break;
                    }

                }
            }
        }
        System.out.println(result.toString().trim());
    }

    private static boolean dfs(int index, char[][] array, boolean[][] visit, StringBuilder result, int i, int j) {
        char current = input[index].charAt(0);

        for (int k = 0; k < 4; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if (x >= 0 && x < n && y >= 0 && y < n && !visit[x][y] && array[x][y] == current) {
                visit[x][y] = true;
                result.append(x).append(",").append(y).append(",");
                if (index == input.length - 1) {
                    return true;
                }
                if (dfs(index + 1, array, visit, result, x, y)) {
                    return true;
                }
                visit[x][y] = false;
            }
        }
        return false;

    }


}
