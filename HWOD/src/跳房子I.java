import java.util.Arrays;
import java.util.Scanner;

public class 跳房子I {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] inputInts = Arrays.asList(input.substring(1, input.length() - 1).split(",")).stream().mapToInt(Integer::parseInt).toArray();
        int count = Integer.parseInt(sc.nextLine());
        String result = "";
        boolean flag = true;
        // 初始化最小索引和为最大整数值
        int minIdxSum = Integer.MAX_VALUE;
        for (int i = 0; i < inputInts.length && flag; i++) {
            for (int j = i + 1; j < inputInts.length; j++) {
                if (inputInts[i] + inputInts[j] == count) {
                    int tmpSUm = i + j;
                    if (tmpSUm < minIdxSum) {
                        minIdxSum = tmpSUm;
                        result = "[" + inputInts[i] + "," + inputInts[j] + "]";
                    }
                    break;
                }

            }
        }
        System.out.println(result);
    }
}
