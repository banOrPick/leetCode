import java.util.*;

public class 题目3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(",");
            for (int j = 0; j < m; j++) {
                arr[i][j] = tmp[j].charAt(0);
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'M') {
                    int[][] dir = {{0, 1}, {1, 0}, {1, 1}, {-1, 1}};
                    for (int k = 0; k < 4; k++) {
                        int tmpi = i;
                        int tmpj = j;
                        int max = 1;
                        int x = dir[k][0];
                        int y = dir[k][1];
                        while (x+tmpi >= 0 && x+tmpi < n && y+tmpj >= 0 && y+tmpj < m && arr[tmpi+x][tmpj+y] == 'M') {
                            tmpi = x+tmpi;
                            tmpj = y+tmpj;
                            max++;
                        }
                        resultList.add(max);
                    }
                }
            }
        }
        Collections.sort(resultList);
        System.out.println(resultList.isEmpty()?0:resultList.get(resultList.size() - 1));
        sc.close();
    }
}
