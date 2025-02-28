import java.util.*;

public class 找数字找等值元素 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int[][] arrs = new int[i][j];
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                arrs[k][l] = scanner.nextInt();
                List<int[]> list = map.get(arrs[k][l]);
                int[] ints = new int[2];
                ints[0] = k;
                ints[1] = l;
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(ints);
                map.put(arrs[k][l], list);
            }
        }
        int[][] result = new int[i][j];
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                List<int[]> list = map.get(arrs[k][l]);
                if (list.size() == 1) {
                    result[k][l] = -1;
                } else {
                    List<int[]> tmpList = new ArrayList<>();
                    int[] tmpInt = new int[2];
                    tmpInt[0] = k;
                    tmpInt[1] = l;
                    for (int m = 0; m < list.size(); m++) {
                        int[] ints = list.get(m);
                        if (!(ints[0] == tmpInt[0] && ints[1] == tmpInt[1])) {
                            tmpList.add(ints);
                        }
                    }
                    for (int m = 0; m < tmpList.size(); m++) {
                        int[] ints = tmpList.get(m);
                        if (result[k][l] == 0) {
                            result[k][l] = Math.abs(ints[0] - k) + Math.abs(ints[1] - l);
                        } else {
                            result[k][l] = Math.min(result[k][l], Math.abs(ints[0] - k) + Math.abs(ints[1] - l));
                        }

                    }
                }

            }
        }
        // 将结果矩阵转换为字符串并输出
        String[] resultStrings = new String[result.length];
        for (int k = 0; k < result.length; k++) {
            resultStrings[k] = Arrays.toString(result[k]);
        }
        System.out.println(Arrays.toString(resultStrings));
    }
}
