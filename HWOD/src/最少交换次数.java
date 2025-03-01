import java.util.Arrays;
import java.util.Scanner;

public class 最少交换次数 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(scanner.nextLine());
        int nums = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] < k) {
                nums++;
            }
        }
        int left = 0;
        int right = left + nums;
        int min = Integer.MAX_VALUE;
        for (; right < ints.length; left++) {
            int tmp = 0;
            for (int i = left; i < right; i++) {
                if (ints[i] >= k) {
                    tmp++;
                }
            }
            min = Math.min(min, tmp);
            right = left + nums;
        }
        System.out.println(min);
    }


}


//public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    int[] ints = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//    int left = 0;
//    int right = ints.length - 1;
//
//    int k = Integer.parseInt(scanner.nextLine());
//    for (int i = 0; i < ints.length; i++) {
//        if (ints[i] < k) {
//            left = i;
//            break;
//        }
//    }
//    for (int i = ints.length - 1; i > 0; i--) {
//        if (ints[i] < k) {
//            right = i;
//            break;
//        }
//    }
//    int total = 0;
//    for (; left < ints.length; left++) {
//        if (left >= right) {
//            break;
//        }
//        if (ints[left] >= k) {
//            int tmp = ints[left];
//            ints[left] = ints[right];
//            ints[right] = tmp;
//            total++;
//            for (int j = right; j > left; j--) {
//                if (ints[j] >= k) {
//                    right = j;
//                    break;
//                }
//            }
//        }
//
//    }
//    System.out.println(total);
//
//}
