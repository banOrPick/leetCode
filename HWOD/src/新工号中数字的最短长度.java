import java.util.Scanner;

public class 新工号中数字的最短长度 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long y = scanner.nextLong();
        long nums = (long)Math.pow(26, y);
        int result=1;
        while (nums*(Math.pow(10,result))<x){
            result++;
        }
        System.out.println(result);
        scanner.close();
    }
}
