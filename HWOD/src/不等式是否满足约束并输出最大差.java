import java.util.*;
import java.util.stream.Collectors;

public class 不等式是否满足约束并输出最大差 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputList = input.split(";");
        List<Double> a1List = new LinkedList<>();
        List<Double> a2List = new LinkedList<>();
        List<Double> a3List = new LinkedList<>();
        List<Integer> xList = new LinkedList<>();
        List<Double> bList = new LinkedList<>();
        List<String> signalList = new LinkedList<>();
        for (int i = 0; i < inputList.length; i++) {
            if (i == 0) {
                a1List = Arrays.stream(inputList[i].split(",")).map(p -> Double.parseDouble(p)).collect(Collectors.toList());
            }
            if (i == 1) {
                a2List = Arrays.stream(inputList[i].split(",")).map(p -> Double.parseDouble(p)).collect(Collectors.toList());
            }
            if (i == 2) {
                a3List = Arrays.stream(inputList[i].split(",")).map(p -> Double.parseDouble(p)).collect(Collectors.toList());
            }
            if (i == 3) {
                xList = Arrays.stream(inputList[i].split(",")).map(p -> Integer.parseInt(p)).collect(Collectors.toList());
            }
            if (i == 4) {
                bList = Arrays.stream(inputList[i].split(",")).map(p -> Double.parseDouble(p)).collect(Collectors.toList());
            }
            if (i == 5) {
                signalList = Arrays.stream(inputList[i].split(",")).collect(Collectors.toList());
            }
        }
        Boolean flag = true;
        Double maxResult = 0d;
        LinkedList<Double> leftList = new LinkedList<>();
        Double left1 = 0d;
        Double left2 = 0d;
        Double left3 = 0d;
        for (int i = 0; i < a1List.size(); i++) {
            left1 = a1List.get(i) * xList.get(i) + left1;
            left2 = a2List.get(i) * xList.get(i) + left2;
            left3 = a3List.get(i) * xList.get(i) + left3;
        }
        leftList.add(left1);
        leftList.add(left2);
        leftList.add(left3);
        for (int i = 0; i < bList.size(); i++) {
            if (">".equals(signalList.get(i))) {
                if (leftList.get(i) - bList.get(i) <= 0) {
                    flag = false;
                }
            }
            if (">=".equals(signalList.get(i))) {
                if (leftList.get(i) - bList.get(i) < 0) {
                    flag = false;
                }
            }
            if ("<".equals(signalList.get(i))) {
                if (leftList.get(i) - bList.get(i) >= 0) {
                    flag = false;
                }
            }
            if ("<=".equals(signalList.get(i))) {
                if (leftList.get(i) - bList.get(i) > 0) {
                    flag = false;
                }
            }
            if ("=".equals(signalList.get(i))) {
                if (leftList.get(i) - bList.get(i) != 0) {
                    flag = false;
                }
            }
            Double maxTmp = 0d;
            if (leftList.get(i) - bList.get(i) < 0) {
                maxTmp = bList.get(i) - leftList.get(i);
            } else {
                maxTmp = leftList.get(i) - bList.get(i);
            }
            if (maxResult < maxTmp) {
                maxResult = maxTmp;
            }
        }
        System.out.println(flag+" "+(int)Math.round(maxResult));
    }
}
