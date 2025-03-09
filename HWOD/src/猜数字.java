import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class 猜数字 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> resultList = new ArrayList<>();

        for (int j = 0; j <= 9999; j++) {
            resultList.add(String.format("%04d", j));
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(" ");
            String intput = String.format("%04d", Integer.parseInt(split[0]));
            String match = split[1];
            int a = Integer.parseInt(match.substring(0, 1));
            int b = Integer.parseInt(match.substring(2, 3));
            resultList = getMatch(resultList, a, b, intput);
        }
        if (resultList.size() != 1) {
            System.out.println("NA");
        } else {
            System.out.println(resultList.get(0));
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static List<String> getMatch(List<String> resultList, int a, int b, String intput) {
        List<String> tempList = new ArrayList<>();
        for (int k = 0; k < resultList.size(); k++) {
            String s = resultList.get(k);
            int[] in = new int[4];
            int[] out = new int[4];
            for (int i = 0; i < intput.length(); i++) {
                in[i] = Integer.parseInt(intput.substring(i, i + 1));
            }
            for (int i = 0; i < s.length(); i++) {
                out[i] = Integer.parseInt(s.substring(i, i + 1));
            }
            int tmpa = 0;
            for (int i = 0; i < intput.length(); i++) {
                if (in[i] == out[i] && in[i] != -1 && out[i] != -1) {
                    tmpa++;
                    in[i] = -1;
                    out[i] = -1;
                }
            }
            int temb = 0;
            for (int i = 0; i < intput.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    if (in[i] == out[j] && in[i] != -1 && out[i] != -1) {
                        temb++;
                        in[i] = -1;
                        out[j] = -1;
                    }
                }
            }
            if (tmpa == a && temb == b) {
                tempList.add(s);
            }
        }
        return tempList;
    }


}
