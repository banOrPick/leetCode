import java.util.*;
import java.util.stream.Collectors;

public class 字符统计及重排 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> resultMap = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char charAt = input.charAt(i);
            int total = 0;
            if (resultMap.keySet().contains(charAt)) {
                total = resultMap.get(charAt);

            }
            resultMap.put(charAt, total + 1);
        }
        List<Map.Entry<Character, Integer>> list = resultMap.entrySet().stream().sorted((a, b) -> {
            if (a.getValue().equals(b.getValue())) {
                char left = a.getKey();
                Integer aValue = (int) left;
                if (left <= 'Z' && left >= 'A') {
                    aValue = Integer.valueOf(String.valueOf(a.getKey()).toLowerCase().charAt(0)) + aValue;
                }
                char right = b.getKey();
                Integer bValue = (int) right;
                if (right <= 'Z' && right >= 'A') {
                    bValue = String.valueOf(b.getKey()).toLowerCase().charAt(0) + bValue;
                }
                return aValue - bValue;
            } else {
                return b.getValue() - a.getValue();
            }
        }).collect(Collectors.toList());
        StringBuffer result = new StringBuffer();
        list.forEach(entry -> {
            result.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        });
        System.out.println(result.toString().trim());

    }
}
