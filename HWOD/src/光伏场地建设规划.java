import java.util.Scanner;

public class 光伏场地建设规划 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split(" ");
        int width=Integer.parseInt(strings[0]);
        int length=Integer.parseInt(strings[1]);
        int side=Integer.parseInt(strings[2]);
        int power=Integer.parseInt(strings[3]);
        int[][] arrs = new int[width][length];
        for (int i = 0; i < width; i++) {
            String line1 = scanner.nextLine();
            String[] split = line1.split(" ");
            for (int j = 0; j < split.length; j++) {
                arrs[i][j]=Integer.parseInt(split[j]);
            }
        }
        int result=0;
        for (int i = 0; i <=width - side; i++) {
            for (int j = 0; j <= length - side; j++) {
                int powers=0;
                for (int k = 0; k < side; k++) {
                    for (int l = 0; l < side; l++) {
                        powers+=arrs[i+k][j+l];
                    }

                }
                if(powers>=power){
                    result++;
                }

            }
        }
        System.out.println(result);
    }
}
