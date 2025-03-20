import java.util.*;
import java.util.stream.Collectors;

public class 喊7的次数重排 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] strings = line.split(" ");
        int all = 0;
        for (String s :
                strings) {
            all += Integer.parseInt(s);
        }
        int pes = strings.length;
        int[] initList = new int[pes];
        int num = 1;
        int currentP = 0;
        while (all != 0) {

            if (guo(num)) {
                all--;
                initList[currentP]++;
            }
            num++;
            currentP++;
            if (currentP == pes) {
                currentP = 0;
            }
        }
        StringBuffer result = new StringBuffer();
        Arrays.stream(initList).forEach(s -> {
            result.append(s).append(" ");
        });
        System.out.println(result.toString().trim());


    }

    static Boolean guo(int num) {
        return num % 7 == 0 || (num + "").contains("7");
    }
}
