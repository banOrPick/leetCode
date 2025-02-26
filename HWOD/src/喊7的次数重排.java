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

        List<String> list = Arrays.stream(strings).collect(Collectors.toList());
        int pes = strings.length;
//        List<Integer> initList = new LinkedList<>();
        int[] initList = new int[pes];
//        for (int i = 0; i < pes; i++) {
//            initList.add(i,0);
//        }
        int num = 1;
        int currentP = 0;
        while (all != 0) {

            if (guo(num)) {
                all--;
                initList[currentP]++;
//                int cur=initList.get(currentP);
//                initList.remove(currentP);
//                initList.add(currentP,initList.get(currentP)+1);
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

//        Scanner scanner = new Scanner(System.in);
//
//        // 读取输入，将喊过的次数存储在数组中
//        int[] counts =
//                Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//
//        // 计算总共喊过的次数
//        int totalPass = Arrays.stream(counts).sum();
//
//        int numberOfPeople = counts.length;
//        int[] peopleCounts = new int[numberOfPeople]; // 存储每个人喊过的次数
//
//        int currentNumber = 1; // 当前要喊的数字
//        int currentIndex = 0; // 当前喊过的人的索引
//        while (totalPass > 0) {
//            if (currentNumber % 7 == 0 || (currentNumber + "").contains("7")) { // 如果当前数字是7的倍数或包含7
//                totalPass--;
//                peopleCounts[currentIndex]++; // 当前喊过的人喊过的次数加1
//            }
//            currentNumber++;
//            currentIndex = (currentIndex + 1) % numberOfPeople; // 更新喊过的人的索引
//        }
//
//        // 构造输出字符串
//        StringJoiner stringJoiner = new StringJoiner(" ");
//        for (int count : peopleCounts) {
//            stringJoiner.add(Integer.toString(count));
//        }
//        System.out.println(stringJoiner.toString());
//    }
}
