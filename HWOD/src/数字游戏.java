import java.util.Arrays;
import java.util.Scanner;

public class 数字游戏 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(" ");
            int n=Integer.parseInt(split[0]);
            int m=Integer.parseInt(split[1]);
            String[] input = scanner.nextLine().split(" ");
            int[] inputInts = Arrays.asList(input).stream().mapToInt(x -> Integer.parseInt(x)).toArray();
            int left=0;
            int sum=0;
            int right=0;
            boolean flag=false;
            for(;left<n-1;right++){
                sum+=inputInts[right];
                if(sum%m==0){
                    flag=true;
                    break;
                }
                if(right==n-1){
                    sum=0;
                    left++;
                    right=left;
                }
            }
            System.out.println(flag?1:0);
        }
    }
}
