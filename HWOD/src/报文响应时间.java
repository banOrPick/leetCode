import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 报文响应时间 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = Integer.parseInt(scanner.nextLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            list.add(Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }

        int currentRespTime = list.get(0)[1];
        if (currentRespTime >= 128) {
            String secondString = Integer.toString(currentRespTime, 2);
            currentRespTime = (Integer.valueOf(secondString.substring(4, 8), 2) | 0X10) << (Integer.valueOf(secondString.substring(1, 4), 2) + 3);
        }


        for (int i = 1; i < c; i++) {
            int[] ints = list.get(i);
            if (ints[1] < 128) {
                int tmpRespTime = ints[0] + ints[1];
                currentRespTime = Math.min(currentRespTime, tmpRespTime);
            } else {
                String secondString = Integer.toString(ints[1], 2);
                int tmpRespTime = ints[0] + (Integer.valueOf(secondString.substring(4, 8), 2) | 0X10) << (Integer.valueOf(secondString.substring(1, 4), 2) + 3);
                currentRespTime = Math.min(currentRespTime, tmpRespTime);
            }

        }
        System.out.println(currentRespTime);
    }
}
