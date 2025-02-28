import java.util.*;

public class 找终点 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] split = input.split(" ");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        TreeMap<Integer, Integer> result = new TreeMap<>();
        for (int i = 1; i < list.size() / 2; i++) {
            int step = 1;
            result.put(getResult(list, i, step), i);
        }
        int stepResult = -1;
        for (Integer key :
                result.keySet()) {
            if (key > 0) {
                stepResult = key;
            }
        }
        System.out.println(stepResult);
        scanner.close();

    }

    private static Integer getResult(List<Integer> list, int i, int step) {
        if (i == list.size()-1) {
            return step;
        }
        if (i > list.size()-1) {
            return -1;
        }
        step++;
        Integer value = list.get(i);
        int index = value + i;
        return getResult(list, index, step);
    }
}
