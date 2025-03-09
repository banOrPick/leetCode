import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 出租车计费靠谱的车 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int tmpn = n;
        for (int i = 0; i < n; i++) {
            List<String> nints = getInts(i);
            if (nints.contains("4")) {
                for (int j = 0; j < nints.size(); j++) {
                    if (nints.get(j).equals("4")) {
                        tmpn -= (int) Math.pow(10, nints.size() - (j + 1));
                        i += (int) Math.pow(10, nints.size() - (j + 1)) - 1;
                        break;
                    }
                }
            }
        }
        System.out.println(tmpn);
    }

    private static List<String> getInts(int n) {
        return Arrays.asList(String.valueOf(n).split(""));
    }
}
