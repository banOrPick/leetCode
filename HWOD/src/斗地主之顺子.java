import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class 斗地主之顺子 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        List<Integer> list = Arrays.stream(split).map(m -> {
            if (m.equals("J")) {
                return 11;
            } else if (m.equals("Q")) {
                return 12;
            } else if (m.equals("K")) {
                return 13;
            } else if (m.equals("A")) {
                return 14;
            }
            return Integer.parseInt(m);
        }).filter(m -> m != 2).sorted().collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        result = getMaxShunzi(list, 0, list.get(0), result);

        result = result.stream().map(s -> {
            String[] split1 = s.split(" ");
            StringBuffer tmpResult = new StringBuffer();
            Arrays.stream(split1).map(m -> {
                if (11 == Integer.parseInt(m)) {
                    return "J";
                } else if (12 == Integer.parseInt(m)) {
                    return "Q";
                } else if (13 == Integer.parseInt(m)) {
                    return "K";
                } else if (14 == Integer.parseInt(m)) {
                    return "A";
                }
                return Integer.parseInt(m);
            }).forEach(k -> {
                tmpResult.append(k).append(" ");
            });
            return tmpResult.toString().trim();
        }).collect(Collectors.toList());
        if(result.size() == 0){
            System.out.println("No");
        }
        result.forEach(System.out::println);

    }

    private static List<String> getMaxShunzi(List<Integer> list, int index, int start, List<String> result) {
        if (index >= list.size() - 5) {
            return result;
        }
        int end = start;
        while (list.contains(end)) {
            end++;
        }
        if (end - 1 >= start) {
            end = end - 1;
        }
        if (end - start >= 4) {
            StringBuilder builder = new StringBuilder();
            for (int i = start; i <= end; i++) {
                builder.append(i).append(" ");
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j) == i) {
                        list.remove(j);
                        list.add(j, -1);
                        break;
                    }

                }
            }
            result.add(builder.toString().trim());
        }
        index++;
        return getMaxShunzi(list, index, list.get(index), result);
    }
}
