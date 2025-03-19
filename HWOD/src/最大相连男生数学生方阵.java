import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 最大相连男生数学生方阵 {
    public  static int[][] dir=new int[][]{{0,1},{1,0},{1,1},{-1,1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int n=Integer.parseInt(split[0]);
        int m=Integer.parseInt(split[1]);
        char[][] arr=new char[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = sc.nextLine().split(",");
            for (int j = 0; j < tmp.length; j++) {
                arr[i][j]=tmp[j].charAt(0);
            }
        }
        List<Integer> resultList=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(arr[i][j]=='M'){
                    for (int k = 0; k < 4; k++) {
                        int tmpi=i;
                        int tmpj=j;
                        int max=1;
                        int x=dir[k][0];
                        int y=dir[k][1];
                        while (tmpi+x>=0&&tmpi+x<n&&tmpj+y>=0&&tmpj+y<m&&arr[tmpi+x][tmpj+y]=='M'){
                            tmpi=tmpi+x;
                            tmpj=tmpj+y;
                            max++;
                        }
                        resultList.add(max);
                    }
                }
            }
        }
        Collections.sort(resultList);
        System.out.println(resultList.get(resultList.size()-1));
    }
}
