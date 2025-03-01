import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 最小的调整次数特异性双端队列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Queue<Integer> queue = new LinkedList<>();
        int addNums = 0;
        boolean isOrder = true;
        for (int i = 0; i < n * 2; i++) {
            String inputString = scanner.nextLine();
            String[] split = inputString.split(" ");
            if (split[0].equals("head")) {
                if (!queue.isEmpty()) {
                    isOrder = false;
                }
                queue.add(Integer.parseInt(split[2]));
            } else if (split[0].equals("tail")) {
                queue.add(Integer.parseInt(split[2]));
            } else {
                if (queue.isEmpty()) {
                    continue;
                }
                queue.remove();
                if (!isOrder) {
                    addNums++;
                    isOrder = true;
                }
            }
        }
        System.out.println(addNums);
    }
}

//5
//head add 1
//head add 2
//remove
//head add 3
//remove
//tail add 4
//head add 5
//remove
//remove
//remove
