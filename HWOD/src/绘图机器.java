import java.util.Scanner;

public class 绘图机器 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int maxX = sc.nextInt();
//        int result = 0;
//        if (maxX == 0) {
//            System.out.println(0);
//            return;
//        }
//        int[] ints = new int[maxX];
//        for (int i = 0; i < n; i++) {
//            int x = sc.nextInt();
//            int offsetY = sc.nextInt();
//            ints[x] = offsetY;
//        }
//        int[] yints = new int[maxX];
//        yints[0] = ints[0];
//        for (int i = 1; i < maxX; i++) {
//            yints[i] = ints[i] + yints[i - 1];
//        }
//        for (int i = 0; i < maxX; i++) {
//            result = result + Math.abs(yints[i]);
//        }
//        System.out.println(result);

        Scanner scanner = new Scanner(System.in);
        // 读取指令数量 N 和终点横坐标 E
        int N = scanner.nextInt();
        int E = scanner.nextInt();

        // 如果终点横坐标为 0，直接输出面积为 0
        if (E == 0) {
            System.out.println(0);
            return;
        }

        // 存储绘图指令
        int[][] commands = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            commands[i][0] = scanner.nextInt();
            commands[i][1] = scanner.nextInt();
        }
        // 添加终点作为最后一条指令
        commands[N][0] = E;
        commands[N][1] = 0;

        // 计算总面积
        long area = 0;
        int currentY = 0;
        for (int i = 0; i < N; i++) {
            // 计算底边长度
            int base = commands[i + 1][0] - commands[i][0];
            // 计算高度
            int height = currentY + commands[i][1];
            // 计算梯形面积并累加到总面积中
            area += (long) base * Math.abs(height);
            // 更新当前纵坐标偏移
            currentY += commands[i][1];
        }

        // 输出总面积
        System.out.println(area);
        scanner.close();

    }
}
