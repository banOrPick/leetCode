import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 项目排期 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取第一行输入，即需求的工作量，并以空格分隔
        String[] workloads = scanner.nextLine().split(" ");
        // 读取第二行输入，即项目组人员数量
        int N = Integer.parseInt(scanner.nextLine());
        // 创建一个数组来存放每个需求的工作量
        int[] tasks = new int[workloads.length];
        int[] pensonTask = new int[N];
        // 将输入的工作量转换为整数并存入数组
        for (int i = 0; i < workloads.length; i++) {
            tasks[i] = Integer.parseInt(workloads[i]);
        }
        Arrays.sort(tasks);
        for (int i = tasks.length-1; i >= 0; i--) {
            int task = tasks[i];
            Arrays.sort(pensonTask);
            pensonTask[0]+=task;
        }
        Arrays.sort(pensonTask);
        System.out.println(pensonTask[pensonTask.length-1]);

    }
}
